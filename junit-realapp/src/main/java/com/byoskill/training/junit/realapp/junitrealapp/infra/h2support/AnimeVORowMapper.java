package com.byoskill.training.junit.realapp.junitrealapp.infra.h2support;


import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimeVORowMapper implements RowMapper<AnimeVO> {

    @Override public AnimeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        final AnimeVO animeVO = new AnimeVO();
        //FIXME
        animeVO.setId(rs.getInt("ANIME_ID"));
        animeVO.setTitle(rs.getString("TITLE"));
        animeVO.setDescription(rs.getString("DESCRIPTION"));
        animeVO.setAverageScore(rs.getInt("AVERAGE_SCORE"));
        final Date end_date = rs.getDate("END_DATE");
        animeVO.setEndDate(end_date == null ? null : end_date.toLocalDate());
        animeVO.setPopularity(rs.getInt("POPULARITY"));
        animeVO.setType(rs.getString("TYPE"));
        animeVO.setCoverImage(rs.getString("COVER_IMAGE"));
        animeVO.setLargeImage(rs.getString("LARGE_IMAGE"));
        animeVO.setCountryOfOrigin(rs.getString("COUNTRY"));
        animeVO.setGenres(new ArrayList<>());
        return animeVO;
    }
}
