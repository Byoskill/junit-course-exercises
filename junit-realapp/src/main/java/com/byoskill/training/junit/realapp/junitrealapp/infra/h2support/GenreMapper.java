package com.byoskill.training.junit.realapp.junitrealapp.infra.h2support;

import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowCallbackHandler {
    private final AnimeVO animeVO;

    public GenreMapper(AnimeVO animeVO) {this.animeVO = animeVO;}

    @Override public void processRow(ResultSet rs) throws SQLException {
        final String label1 = rs.getString("LABEL");
        final GenreVO genre = new GenreVO(label1);
        animeVO.addGenre(genre);
    }
}
