package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class AniListPayload {
    private Map<String, JsonNode> data;

    public Map<String, JsonNode> getData() {
        return data;
    }

    public <T> T getValue(String genreCollection, TypeReference<T> typeReference, ObjectMapper objectMapper) {
        return objectMapper.convertValue(data.get(genreCollection), typeReference);
    }
}
