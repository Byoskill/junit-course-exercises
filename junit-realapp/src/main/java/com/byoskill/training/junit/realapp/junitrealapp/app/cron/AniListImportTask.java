package com.byoskill.training.junit.realapp.junitrealapp.app.cron;

import com.byoskill.training.junit.realapp.junitrealapp.domain.services.AnimeImportService;
import org.springframework.scheduling.annotation.Scheduled;

public class AniListImportTask {
    
    private AnimeImportService animeImportService;
        
    public AniListImportTask(AnimeImportService animeImportService) {this.animeImportService = animeImportService;}

    @Scheduled(initialDelay = 2000, fixedDelay = 300_000)
    public void scheduleTask() {
        animeImportService.refreshAnimeList();
    }
}
