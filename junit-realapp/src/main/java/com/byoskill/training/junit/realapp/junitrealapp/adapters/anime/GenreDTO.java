package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;

public class GenreDTO {
    private final String label;

    public GenreDTO(String label) {
        this.label = label;
    }

    public static GenreVO toValueObject(GenreDTO genreDTO) {
        return new GenreVO(genreDTO.label);
    }

    public static GenreDTO importData(GenreVO vo) {
        return new GenreDTO(vo.getLabel());
    }

    public String getLabel() {
        return label;
    }
}
