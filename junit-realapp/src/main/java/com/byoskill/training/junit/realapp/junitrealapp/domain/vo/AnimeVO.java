package com.byoskill.training.junit.realapp.junitrealapp.domain.vo;

import java.time.LocalDate;
import java.util.List;

public class AnimeVO {
    private String title;
    private List<GenreVO> genres;
    private Integer id;
    private Integer popularity;
    private String type;
    private Integer averageScore;
    private LocalDate endDate;
    private String description;
    private String countryOfOrigin;
    private String coverImage;
    private String largeImage;

    public static AnimeVO demo(int v) {
        final AnimeVO animeVO = new AnimeVO();
        animeVO.setTitle("TITLE" +v);
        animeVO.setDescription("");
        return animeVO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GenreVO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreVO> genres) {
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("AnimeVO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", genres=").append(genres);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setDescriptionOrDefaultValue(String description) {
        if (description == null) {
            this.description = "No description available";
        } else {
            this.description = description;
        }
    }

    public void addGenre(GenreVO label) {
        this.genres.add(label);
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getLargeImage() {
        return largeImage;
    }
}
