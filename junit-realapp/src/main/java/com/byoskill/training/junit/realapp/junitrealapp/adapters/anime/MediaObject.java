package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;

import java.util.List;
import java.util.stream.Collectors;

public class MediaObject {
    public Integer id;
    public MediaTitle title;
    public List<String> genres;
    public Integer popularity;
    public String type;
    public Integer averageScore;
    public FuzzyDate endDate;
    public String description;
    public String countryOfOrigin;
    public CoverImage coverImage;
    
    public AnimeVO toValueObject() {
        final AnimeVO animeVO = new AnimeVO();
        if (title.english != null) {
            animeVO.setTitle(title.english);
        } else {
            animeVO.setTitle(title.nativeName);
        }
        animeVO.setGenres(genres.stream().map(GenreVO::new).collect(Collectors.toUnmodifiableList()));
        animeVO.setId(id);
        animeVO.setPopularity(popularity);
        animeVO.setType(type);
        animeVO.setAverageScore(averageScore);
        animeVO.setDescriptionOrDefaultValue(description);
        animeVO.setEndDate(endDate.toLocalDate());
        animeVO.setCountryOfOrigin(countryOfOrigin);
        animeVO.setCoverImage(coverImage.medium);
        animeVO.setLargeImage(coverImage.large);
        return animeVO;
        
    }
}
