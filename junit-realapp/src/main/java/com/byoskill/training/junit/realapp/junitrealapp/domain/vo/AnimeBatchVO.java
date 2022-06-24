package com.byoskill.training.junit.realapp.junitrealapp.domain.vo;

import java.util.List;

/**
 * This component contains the data to import.
 */
public class AnimeBatchVO {
    private List<GenreVO> genres;
    private List<AnimeVO> medias;

    public List<AnimeVO> getMedias() {
        return medias;
    }

    public void setMedias(List<AnimeVO> medias) {
        this.medias = medias;
    }

    public List<GenreVO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreVO> genres) {
        this.genres = genres;
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("AnimeBatchVO{");
        sb.append("genres=").append(genres);
        sb.append(", medias=").append(medias);
        sb.append('}');
        return sb.toString();
    }
}
