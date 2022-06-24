package com.byoskill.training.junit.realapp.junitrealapp.domain.entities;

import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity()
@Table(name = "TAB_ANIME")
public class Anime {
    @Column(name = "TITLE")
    private String title;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tab_anime_genre",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "label"))
    private List<Genre> genres;

    @Column(name = "ANIME_ID")
    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(unique = true, nullable = false, name = "ANI_WEB_ID")
    private Integer aniWebId;

    @Column(name = "POPULARITY")
    private Integer popularity;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "AVERAGE_SCORE")
    private Integer averageScore;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "COUNTRY", length = 16)
    private String countryOfOrigin;

    @Column(name = "COVER_IMAGE", length = 4000)
    private String coverImage;
    
    @Column(name = "LARGE_IMAGE", length = 4000)
    private String largeImage;

    public static Anime importData(AnimeVO mvo) {
        final Anime anime = new Anime();

        anime.title = mvo.getTitle();
        anime.genres = new ArrayList<>();
        anime.aniWebId = mvo.getId();
        anime.averageScore = mvo.getAverageScore();
        if (anime.averageScore == null) {
            anime.averageScore = 0;
        }
        anime.endDate = mvo.getEndDate();
        anime.popularity = mvo.getPopularity();
        anime.type = mvo.getType();
        anime.coverImage = mvo.getCoverImage();
        anime.largeImage = mvo.getLargeImage();
        anime.countryOfOrigin = mvo.getCountryOfOrigin();
        //FIXME
        anime.description = mvo.getDescription();

        return anime;
    }

    @Override public int hashCode() {
        return Objects.hash(title, genres, aniWebId, popularity, type, averageScore, endDate, description,
                            countryOfOrigin,
                            coverImage);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return Objects.equals(title, anime.title) && Objects.equals(genres,
                                                                    anime.genres) && Objects.equals(
                aniWebId, anime.aniWebId) && Objects.equals(popularity,
                                                            anime.popularity) && Objects.equals(type,
                                                                                                anime.type) && Objects.equals(
                averageScore, anime.averageScore) && Objects.equals(endDate,
                                                                    anime.endDate) && Objects.equals(
                description, anime.description) && Objects.equals(countryOfOrigin,
                                                                  anime.countryOfOrigin) && Objects.equals(
                coverImage, anime.coverImage);
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Anime{");
        sb.append("title='").append(title).append('\'');
        sb.append(", genres=").append(genres);
        sb.append(", id=").append(id);
        sb.append(", popularity=").append(popularity);
        sb.append(", type='").append(type).append('\'');
        sb.append(", averageScore=").append(averageScore);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAniWebId() {
        return aniWebId;
    }

    public void setAniWebId(Integer aniWebId) {
        this.aniWebId = aniWebId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void addGenre(Genre genre) {
        if (genre == null) return;
        this.genres.add(genre);
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public AnimeVO toValueObject() {
        final AnimeVO animeVO = new AnimeVO();
        animeVO.setId(this.id);
        animeVO.setTitle(this.title);
        animeVO.setAverageScore(this.averageScore);
        animeVO.setCoverImage(this.coverImage);
        animeVO.setLargeImage(this.largeImage);
        animeVO.setCountryOfOrigin(this.countryOfOrigin);
        animeVO.setPopularity(this.popularity);
        animeVO.setDescriptionOrDefaultValue(this.description);
        animeVO.setGenres(this.genres.stream().map(Genre::toValueObject).collect(Collectors.toUnmodifiableList()));
        animeVO.setEndDate(this.endDate);
        return animeVO;
    }
}
