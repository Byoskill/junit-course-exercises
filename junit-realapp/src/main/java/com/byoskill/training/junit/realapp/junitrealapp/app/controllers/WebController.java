package com.byoskill.training.junit.realapp.junitrealapp.app.controllers;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Anime;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.AnimeRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.GenreRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    private final AnimeRepository animeRepository;
    private final GenreRepository genreRepository;

    public WebController(AnimeRepository animeRepository,
                         GenreRepository genreRepository) {
        this.animeRepository = animeRepository;
        this.genreRepository = genreRepository;
    }

    @RequestMapping(path = {"/", ""})
    public ModelAndView homePage() {
        
        final ModelAndView home = new ModelAndView("home");
        final List<AnimeVO> top10Animes = animeRepository.getTop10Animes();
        home.addObject("top10", top10Animes);
        home.addObject("genres", genreRepository.getGenresAndStatistics());
        return home;
    }

    @RequestMapping(path = {"/manga/{id}"})
    public ModelAndView mangaPage(@PathVariable("id") String animeId) {

        final Optional<Anime> anime = animeRepository.findById(animeId);
        if (anime.isPresent()) {
            final ModelAndView home = new ModelAndView("manga");
            home.addObject("anime", anime.get().toValueObject());
            return home;
        } else {
            throw new IllegalArgumentException("Manga not found");
        }
    }
}
