package com.example.david.revisao.API;

import com.example.david.revisao.Model.Pojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("/3/movie/{category}")
    Call<Pojo> getMovies(
        @Path("category") String category,
        @Query("api_key") String api_key,
        @Query("language") String language,
        @Query("page") int page,
        @Query("region") String region
        );
    }