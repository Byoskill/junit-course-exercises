package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class DtoConversion {
    private final ObjectMapper mapper;

    public DtoConversion(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<AnimeVO> convertMedia(AniListPayload body) {
        if (body == null) return emptyList();
        final TypeReference<MediaPage> typeReference = new TypeReference<>() {};
        final MediaPage genreCollection = body.getValue("Page", typeReference, mapper);

        return genreCollection.getMedia().stream()
                       .map(MediaObject::toValueObject)
                       .collect(Collectors.toList());
    }

    public List<GenreVO> convertGenres(AniListPayload body) {

        final TypeReference<List<String>> typeReference = new TypeReference<>() {};
        final List<String> genreCollection = body.getValue("GenreCollection", typeReference,
                                                           mapper);

        return genreCollection
                .stream()
                .map(GenreVO::new)
                .collect(Collectors.toList());
    }
}
