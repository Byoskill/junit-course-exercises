package com.byoskill.training.junit.realapp.junitrealapp.infra.h2support;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Genre;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.GenreRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenresAndStatisticsVO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class H2GenreRepository implements GenreRepository {

    private final GenreJpaRepository genreJPA;

    public H2GenreRepository(GenreJpaRepository genreJPA) {this.genreJPA = genreJPA;}

    @Override public Optional<Genre> findByLabel(String label) {
        return this.genreJPA.findByLabel(label);
    }

    @Override public void save(Genre genre) {
        this.genreJPA.save(genre);
    }

    @Override public List<Genre> findAll() {
        final Iterable<Genre> genres = genreJPA.findAll();
        List<Genre> returnList = new ArrayList<>();
        genres.forEach(returnList::add);
        return returnList;
    }

    @Override public GenresAndStatisticsVO getGenresAndStatistics() {
        return null;
    }
}
