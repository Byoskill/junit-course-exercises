package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

import com.byoskill.training.junit.realapp.junitrealapp.domain.connectors.AnimeConnector;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.AnimeVO;
import com.byoskill.training.junit.realapp.junitrealapp.domain.vo.GenreVO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * This class implements the REST Client that download data from the AniList web site.
 */
public class AniListRestAdapter implements AnimeConnector {

    private static final Logger log = LoggerFactory.getLogger(AniListRestAdapter.class);
    private final AniListClientService client;
    private final DtoConversion dtoConversion;
    private final MediaType mediaType;

    public AniListRestAdapter(DtoConversion dtoConversion) {
        this.dtoConversion = dtoConversion;
        Retrofit retrofit = initRestClient();
        client = retrofit.create(AniListClientService.class);
        mediaType = MediaType.parse("application/json; charset=utf-8");
    }

    @NotNull private Retrofit initRestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl("https://graphql.anilist.co")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Override
    public List<AnimeVO> getAnimeListByGenre(GenreVO genre, int page, int perPage) {
        if (page < 1) throw new IllegalArgumentException("page arg is equal or greater than 1");
        if (perPage < 1) throw new IllegalArgumentException("perPage arg is equal or greater than 1");
        Validate.notNull(genre, "GenreDTO should be defined");
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            //
        }
        final String req = "query ($page: Int, $perPage: Int, $genre: String) {\n" +
                "  Page(page: $page, perPage: $perPage) {\n" +
                "    pageInfo {\n" +
                "      total\n" +
                "      currentPage\n" +
                "      lastPage\n" +
                "      hasNextPage\n" +
                "      perPage\n" +
                "    }\n" +
                "    media(genre: $genre) {\n" +
                "      id\n" +
                "      title {\n" +
                "        english\n" +
                "        native\n" +
                "      }\n" +
                "      type \n" +
                "      popularity\n" +
                "      description\n" +
                "      countryOfOrigin\n" +
                "      coverImage { medium\nlarge}\n" +
                "      genres\n" +
                "      averageScore\n" +
                "      endDate {\n" +
                "        year\n" +
                "        month\n" +
                "        day\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n";

        final GraphQlRequest graphQlRequest = new GraphQlRequest(req);
        graphQlRequest.putVariable("genre", genre.getLabel());
        graphQlRequest.putVariable("page", page);
        graphQlRequest.putVariable("perPage", perPage);
        final Call<AniListPayload> listCall = client.listAnimeByGenre(graphQlRequest);
        try {
            return dtoConversion.convertMedia(listCall.execute().body());
        } catch (IOException e) {
            log.error("List of anime could not be fetched", e);
            return emptyList();
        }
    }

    @Override
    public List<GenreVO> getGenres() {
        final String req = "{\n" +
                "  GenreCollection\n" +
                "}";

        final GraphQlRequest graphQlRequest = new GraphQlRequest(req);
        final Call<AniListPayload> listCall = client.listGenres(graphQlRequest);
        try {
            return dtoConversion.convertGenres(listCall.execute().body());
        } catch (IOException e) {
            log.error("List of anime could not be fetched", e);
            return emptyList();
        }
    }
}
