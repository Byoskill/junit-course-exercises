package com.byoskill.training.junit.realapp.junitrealapp.app.controllers;

import com.byoskill.training.junit.realapp.junitrealapp.domain.entities.Genre;
import com.byoskill.training.junit.realapp.junitrealapp.domain.repositories.GenreRepository;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/genre")
public class GenreRestController {
    
    private GenreRepository genreRepository;

    public GenreRestController(GenreRepository genreRepository) {this.genreRepository = genreRepository;}

    @GetMapping
    public List<GenreVO> getAll() {
        return genreRepository.findAll()
                              .stream()
                              .map(Genre::toValueObject)
                              .collect(Collectors.toList());
    }
}
