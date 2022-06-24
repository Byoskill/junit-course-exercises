package com.byoskill.training.junit.realapp.junitrealapp.domain.entities;

import com.byoskill.training.junit.realapp.junitrealapp.adapters.anime.GenreDTO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity()
@Table(name = "TAB_GENRE")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "GENRE_ID", unique = true)
    private Long genreId;

    @Column(name = "LABEL", unique = true)
    private String label;
    
    @ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Anime> animes = new ArrayList<>();

    public Genre(String label) {
        this.label = label;
    }

    public Genre() {

    }

    public static Genre importData(GenreVO vo) {
        return new Genre(vo.getLabel());
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    @Override public int hashCode() {
        return Objects.hash(label);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(label, genre.label);
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Genre{");
        sb.append("label='").append(label).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public GenreVO toValueObject() {
        return new GenreVO(label);
    }

    public void addAnime(Anime anime) {
        this.animes.add(anime);
    }
}
