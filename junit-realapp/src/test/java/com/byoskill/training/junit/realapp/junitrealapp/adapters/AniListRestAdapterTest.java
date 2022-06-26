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

    }


    @Test
    public void listGenre() {
        final AniListRestAdapter aniListRestAdapter = fixture();
   
    }

    @NotNull private AniListRestAdapter fixture() {
        
        return null;
    }

}