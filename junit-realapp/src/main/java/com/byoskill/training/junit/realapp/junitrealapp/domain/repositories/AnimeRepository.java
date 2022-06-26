package com.byoskill.training.junit.realapp.junitrealapp.domain.repositories;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Anime;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface AnimeRepository {
    Optional<Anime> findByTitle(String title);

    void save(Anime anime);

    List<AnimeVO> getTop10Animes();
    
    @Nullable Optional<Anime> findById(String animeId);

    List<AnimeVO> findAll();
}
