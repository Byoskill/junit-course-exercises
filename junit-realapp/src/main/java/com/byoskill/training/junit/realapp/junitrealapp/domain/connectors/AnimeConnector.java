package com.byoskill.training.junit.realapp.junitrealapp.domain.connectors;

import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;

import java.util.List;

/**
 * This interface defines the methods offered by an Anime Connector. The implementation may change depending of the providers.
 */
public interface AnimeConnector {
    /**
     * Get anime list by genre
     *
     * @param genre   the genre
     * @param page    the page number
     * @param perPage the number of records
     * @return the list of media
     */
    List<AnimeVO> getAnimeListByGenre(GenreVO genre, int page, int perPage);

    /**
     * Returns the list of genres
     *
     * @return the list of genres
     */
    List<GenreVO> getGenres();
}
