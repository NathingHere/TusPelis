package com.example.tuspelis.WebService;

import com.example.tuspelis.Peliculas.Models.ListadoPeliculas;
import com.example.tuspelis.Series.Models.ListadoSeries;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MyClient {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/upcoming")
    Call<ListadoPeliculas> getUpcoming(@Query("api_key") String key);

    @GET("tv/popular")
    Call<ListadoSeries> getPopularSeries(@Query("api-key") String key);



}
