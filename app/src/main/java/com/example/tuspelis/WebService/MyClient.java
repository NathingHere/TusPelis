package com.example.tuspelis.WebService;

import com.example.tuspelis.Peliculas.Models.ListadoGenerosPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoTrailerPelicula;
import com.example.tuspelis.Peliculas.Models.PeliculaExtended;
import com.example.tuspelis.Series.Models.DatosSerie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyClient {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/{movie_id}")
    Call<PeliculaExtended> getMovieDetails(@Path("movie_id") int movieId, @Query("api_key") String key);

    @GET("movie/upcoming")
    Call<ListadoPeliculas> getUpcoming(@Query("api_key") String key);

    @GET("movie/popular")
    Call<ListadoPeliculas> getPopular(@Query("api_key") String key);

    @GET("movie/top_rated")
    Call<ListadoPeliculas> getTopRated(@Query("api_key") String key);

    @GET("movie/now_playing")
    Call<ListadoPeliculas> getNowPlaying(@Query("api_key") String key);

    @GET("movie/{id}/videos")
    Call<ListadoTrailerPelicula> getTrailers(@Path("id") int movieId, @Query("api_key") String key);

    @GET("genre/movie/list")
    Call<ListadoGenerosPeliculas> getGenerosPeliculas(@Query("api_key") String key);

    //@GET("tv/{tv_id}")
    //Call<SeriePlus> getSerieDetals(@Path("tv_id") int tv_id, @Query("api_key") String key);

    @GET("tv/popular")
    Call<DatosSerie> getPopularSeries(@Query("api_key") String key);


}
