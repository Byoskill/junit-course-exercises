package com.byoskill.training.junit.realapp.junitrealapp.domain.services;

import com.byoskill.training.junit.realapp.junitrealapp.domain.connectors.AnimeConnector;
import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Anime;
import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Genre;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.AnimeRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.GenreRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeBatchVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;

import javax.transaction.Transactional;
import java.util.*;

public class AnimeImportService {

    private final AnimeRepository animeRepository;
    private final GenreRepository genreRepository;
    private final AnimeConnector animeConnector;

    public AnimeImportService(AnimeRepository animeRepository,
                              GenreRepository genreRepository,
                              AnimeConnector animeConnector) {
        this.animeRepository = animeRepository;
        this.genreRepository = genreRepository;
        this.animeConnector = animeConnector;
    }

    /**
     * Refresh the list of anime by querying the connector for new anime.
     */
    public void refreshAnimeList() {
        final List<GenreVO> genres = this.animeConnector.getGenres();
        genres.forEach(this::importGenre);

        List<AnimeVO> animeList = new ArrayList<>();
        for (GenreVO genre : genres) {
            final AnimeBatchVO animeBatchVO = new AnimeBatchVO();
            animeBatchVO.setGenres(genres);
            // Fetch rest data
            final List<AnimeVO> animeListByGenre = animeConnector.getAnimeListByGenre(genre, 1, 50);
            animeList.addAll(animeListByGenre);
            animeBatchVO.setMedias(animeList);
            
            importAnimeList(animeBatchVO);
        }

    }

    private Genre importGenre(GenreVO gvo) {
        Genre result;
        final Optional<Genre> byLabel = genreRepository.findByLabel(gvo.getLabel());
        if (byLabel.isEmpty()) {
            Genre genre = Genre.importData(gvo);
            genreRepository.save(genre);
            result = genre;
        } else {
            result = byLabel.get();
        }
        return result;
    }

    /**
     * This service offers the possibility to import an anime list and returns the number of animes imported.
     */
    public void importAnimeList(AnimeBatchVO animeBatch) {
        Map<String, Genre> genres = new HashMap<>();
        for (GenreVO gvo : animeBatch.getGenres()) {
            Genre genre = importGenre(gvo);
            genres.put(genre.getLabel(), genre);
        }

        for (AnimeVO mvo : animeBatch.getMedias()) {
            if (animeRepository.findByTitle(mvo.getTitle()).isEmpty()) {
                importAnime(genres, mvo);
            }
        }
        genres.values().forEach(e -> genreRepository.save(e));
    }

    private void importAnime(Map<String, Genre> genres, AnimeVO mvo) {
        Anime anime = Anime.importData(mvo);
        for (GenreVO genre : mvo.getGenres()) {
            final Genre genre1 = genres.get(genre.getLabel());
            anime.addGenre(genre1);
        }
        animeRepository.save(anime);
    }
}
