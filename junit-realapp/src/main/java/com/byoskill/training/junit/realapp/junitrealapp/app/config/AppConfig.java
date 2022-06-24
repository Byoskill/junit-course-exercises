package com.byoskill.training.junit.realapp.junitrealapp.app.config;

import com.byoskill.training.junit.realapp.junitrealapp.adapters.anime.AniListRestAdapter;
import com.byoskill.training.junit.realapp.junitrealapp.adapters.anime.DtoConversion;
import com.byoskill.training.junit.realapp.junitrealapp.app.cron.AniListImportTask;
import com.byoskill.training.junit.realapp.junitrealapp.domain.connectors.AnimeConnector;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.AnimeRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.GenreRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.services.AnimeImportService;
import com.byoskill.training.junit.realapp.junitrealapp.infra.h2support.AnimeJpaRepository;
import com.byoskill.training.junit.realapp.junitrealapp.infra.h2support.GenreJpaRepository;
import com.byoskill.training.junit.realapp.junitrealapp.infra.h2support.H2AnimeRepository;
import com.byoskill.training.junit.realapp.junitrealapp.infra.h2support.H2GenreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;

@Configuration
public class AppConfig {

    @Bean
    public GenreRepository genreRepository(GenreJpaRepository genreJpa) {
        return new H2GenreRepository(genreJpa);
    }

    @Bean
    public AnimeRepository animeRepository(AnimeJpaRepository animeJPA,
                                           JdbcTemplate jdbcTemplate, 
                                           EntityManager entityManager) {
        return new H2AnimeRepository(animeJPA, jdbcTemplate, entityManager);
    }

    @Bean
    public AnimeImportService animeImportService(AnimeRepository animeRepository,
                                                 GenreRepository genreRepository, 
                                                 AnimeConnector animeConnector) {
        return new AnimeImportService(animeRepository, genreRepository, animeConnector);
    }

    @Bean
    public AniListImportTask importTask(AnimeImportService animeImportService) {
        return new AniListImportTask(animeImportService);

    }
    
    @Bean
    public AnimeConnector animeConnector(DtoConversion dtoConversion) {
        return new AniListRestAdapter(dtoConversion);
    }
    
    @Bean
    public DtoConversion dtoConversion(ObjectMapper objectMapper) {
        return new DtoConversion(objectMapper);
    }
}
