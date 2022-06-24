package com.byoskill.training.junit.realapp.junitrealapp.domain.vo;

import java.util.Objects;

public class GenreVO {
    private final String label;

    public GenreVO(String label) {

        this.label = label;
    }


    @Override public int hashCode() {
        return Objects.hash(label);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreVO genreVO = (GenreVO) o;
        return Objects.equals(label, genreVO.label);
    }

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("GenreVO{");
        sb.append("label='").append(label).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getLabel() {
        return label;
    }
}
