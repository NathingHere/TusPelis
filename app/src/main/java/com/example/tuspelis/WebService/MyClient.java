package com.example.tuspelis.WebService;

import com.example.tuspelis.Peliculas.Models.ListadoPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoTrailerPelicula;
import com.example.tuspelis.Peliculas.Models.PeliculaExtended;
import com.example.tuspelis.Series.Models.Detalles_Serie;
import com.example.tuspelis.Series.Models.ListadoSerie;
import com.example.tuspelis.Series.Models.GenerosSeries;
import com.example.tuspelis.Series.Models.ListadoTrailerSerie;
import com.example.tuspelis.Sesion.GuestSesion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyClient {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("authentication/guest_session/new")
    Call<GuestSesion> getGuestToken(@Query("api_key") String key);

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

    @GET("movie/{movie_id}/recommendations")
    Call<ListadoPeliculas> getRecommendedMovies(@Path("movie_id") int movieId, @Query("api_key") String key);

    @GET("tv/{tv_id}")
    Call<Detalles_Serie> getSerieDetails(@Path("tv_id") int tv_id, @Query("api_key") String key);

    @GET("tv/popular")
    Call<ListadoSerie> getPopularSeries(@Query("api_key") String key);

    @GET("tv/airing_today")
    Call<ListadoSerie> getLastSeries(@Query("api_key") String key);

    @GET("tv/top_rated")
    Call<ListadoSerie> getTopRatedSeries(@Query("api_key") String key);

    @GET("tv/on_the_air")
    Call<ListadoSerie> getOnAirSeries(@Query("api_key") String key);

    @GET("tv/{id}/videos")
    Call<ListadoTrailerSerie> getTrailersSeries(@Path("id") int tv_id, @Query("api_key") String key);

    @GET("tv/{tv_id}/recommendations")
    Call<ListadoSerie> getRecommendedSeries(@Path("tv_id") int tv_id, @Query("api_key") String key);

    @GET("search/movie")
    Call<ListadoPeliculas> buscarPorPalabra(@Query("api_key") String key, @Query("query") String buscar);



}
