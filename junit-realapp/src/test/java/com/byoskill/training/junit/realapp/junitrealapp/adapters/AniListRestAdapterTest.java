package com.byoskill.training.junit.realapp.junitrealapp.adapters;

import com.byoskill.training.junit.realapp.junitrealapp.adapters.anime.AniListRestAdapter;
import com.byoskill.training.junit.realapp.junitrealapp.adapters.anime.DtoConversion;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("integration")
class AniListRestAdapterTest {

    @Test
    public void listAnimeByGenre() {
        final AniListRestAdapter aniListRestAdapter = fixture();
        int page = 1;
        int perPage = 20;
        final GenreVO comedy = new GenreVO("comedy");
        List<AnimeVO> medias = aniListRestAdapter.getAnimeListByGenre(comedy, page, perPage);
        assertThat(medias).isNotEmpty()
                          .allMatch(p -> p.getId() != null, "Id should not be empty")
                          .allMatch(p -> p.getTitle() != null, "Title should not be empty")
                          .hasSize(perPage);
    }


    @Test
    public void listGenre() {
        final AniListRestAdapter aniListRestAdapter = fixture();
        List<GenreVO> medias = aniListRestAdapter.getGenres();
        assertThat(medias)
                .allMatch(p -> !p.getLabel().isEmpty(), "Label should not be empty")
                .isNotEmpty();
    }

    @NotNull private AniListRestAdapter fixture() {
        ObjectMapper mapper = new ObjectMapper();
        DtoConversion dtoConversion = new DtoConversion(mapper);
        final AniListRestAdapter aniListRestAdapter = new AniListRestAdapter(dtoConversion);
        return aniListRestAdapter;
    }

}