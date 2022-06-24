package com.byoskill.training.junit.realapp.junitrealapp.domain.repositories;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Genre;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenresAndStatisticsVO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GenreRepository {

    Optional<Genre> findByLabel(String label);

    void save(Genre genre);

    List<Genre> findAll();

    GenresAndStatisticsVO getGenresAndStatistics();
}
