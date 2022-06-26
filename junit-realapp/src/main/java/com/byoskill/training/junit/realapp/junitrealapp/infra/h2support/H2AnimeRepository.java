package com.byoskill.training.junit.realapp.junitrealapp.infra.h2support;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Anime;
import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Genre;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.AnimeRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import org.jetbrains.annotations.Nullable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class H2AnimeRepository implements AnimeRepository {
    private final AnimeJpaRepository animeJPA;
    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    public H2AnimeRepository(AnimeJpaRepository animeJPA,
                             JdbcTemplate jdbcTemplate,
                             EntityManager entityManager) {
        this.animeJPA = animeJPA;
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    @Override public Optional<Anime> findByTitle(String title) {
        return animeJPA.findByTitle(title);
    }

    @Override public void save(Anime anime) {
        List<Genre> updatedGenres = new ArrayList<>();
        for (Genre genre : anime.getGenres()) {
            updatedGenres.add(entityManager.merge(genre));
        }
        anime.setGenres(updatedGenres);
        animeJPA.save(anime);
    }

    @Override public List<AnimeVO> getTop10Animes() {
        final String sql = "SELECT * FROM TAB_ANIME  ORDER BY AVERAGE_SCORE ASC LIMIT 10";
        List<AnimeVO> animes = jdbcTemplate.query(sql, new AnimeVORowMapper());
        for (AnimeVO vo : animes) {
            // Fetch genres
            final String sql2 = "SELECT g.* FROM tab_anime_genre tag LEFT JOIN tab_genre g ON tag.label = g.GENRE_ID WHERE id = ?";
            final PreparedStatementCreatorFactory pstmtFactory = new PreparedStatementCreatorFactory(sql2,
                                                                                                     Types.INTEGER);
            final PreparedStatementCreator psc = pstmtFactory.newPreparedStatementCreator(
                    new Object[]{12});
            jdbcTemplate.query(psc, new GenreMapper(vo));
        }
        return animes;
    }

    @Nullable @Override public Optional<Anime> findById(String animeId) {
        final int id = Integer.parseInt(animeId);
        return animeJPA.findById(id);
    }

    @Override public Iterable<Anime> findAll() {
        return this.animeJPA.findAll();
    }

}
