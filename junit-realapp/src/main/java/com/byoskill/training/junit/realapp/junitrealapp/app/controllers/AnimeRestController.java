package com.byoskill.training.junit.realapp.junitrealapp.app.controllers;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Anime;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.AnimeRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/anime")
public class AnimeRestController {

    private final AnimeRepository animeRepository;

    public AnimeRestController(AnimeRepository animeRepository) {this.animeRepository = animeRepository;}

    @GetMapping
    public List<AnimeVO> getAll() {
        final Iterable<Anime> all = animeRepository.findAll();
        final ArrayList<AnimeVO> animeVOS = new ArrayList<>();
        for (Anime anime : all) {
            if (!anime.getTitle().isEmpty()) {
                animeVOS.add(anime.toValueObject());
            }
        }
        return animeVOS;
    }
    @GetMapping("/top10")
    public List<AnimeVO> top10() {
        return animeRepository.getTop10Animes();
    }

    @GetMapping("/anime/{id}")
    @ResponseBody
    public ResponseEntity findById(@PathVariable("id") String id) {
        final Optional<Anime> byId = this.animeRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get().toValueObject());
        }
        return ResponseEntity.notFound().build();
    }
    
}
