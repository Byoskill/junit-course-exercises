package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AniListClientService {
    
    //@Body RequestBody payload
    @POST("/")
    Call<AniListPayload> listAnimeByGenre(@Body GraphQlRequest req);

    @POST("/")
    Call<AniListPayload> listGenres(@Body GraphQlRequest req);
    
}
