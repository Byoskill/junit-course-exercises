package com.byoskill.training.junit.realapp.junitrealapp.domain.vo;

import java.util.HashMap;
import java.util.Map;

public class GenresAndStatisticsVO {
    private final Map<GenreVO, Integer> genres = new HashMap<>();

    /**
     * Gets genres.
     *
     * @return the genres
     */
    public Map<GenreVO, Integer> getGenres() {
        return genres;
    }
}
