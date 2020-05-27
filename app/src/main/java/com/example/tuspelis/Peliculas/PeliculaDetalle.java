package com.example.tuspelis.Peliculas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.Peliculas.Adapters.AdapterRecomendadoPeliculas;
import com.example.tuspelis.Series.Adapters.AdapterRecomendadoSeries;
import com.example.tuspelis.MainActivity;
import com.example.tuspelis.Peliculas.Models.GenerosPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoTrailerPelicula;
import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.Peliculas.Models.PeliculaExtended;
import com.example.tuspelis.R;
import com.example.tuspelis.WebService.MyClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculaDetalle extends AppCompatActivity {

    private Pelicula pelicula;
    private ImageView portada, fondo;
    private TextView titulo, fechaSalida, descripcion, valoraciones, generoPelicula;
    private FloatingActionButton trailer;
    private List<Pelicula> peliculasRecomendadas;
    private AdapterRecomendadoPeliculas adapter;
    private RecyclerView recyclerView;
    private List<GenerosPeliculas> generosPeliculas;
    private ProgressBar progressBar;

    String trailerKey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepelisseries);

        Intent intent = getIntent();
        pelicula = intent.getParcelableExtra("data");

        progressBar = findViewById(R.id.progressBarDetalle);
        generoPelicula = findViewById(R.id.txtDetalleGenero);
        trailer = findViewById(R.id.btnDetalleTrailer);
        titulo = findViewById(R.id.txtDetallleTitulo);
        titulo.setText(pelicula.getTitle());
        fechaSalida = findViewById(R.id.txtDetalleFecha);
        fechaSalida.setText(pelicula.getReleaseDate());
        descripcion = findViewById(R.id.txtDetalleDescripcion);
        descripcion.setText(pelicula.getOverview());
        valoraciones = findViewById(R.id.txtDetalleValoracion);
        valoraciones.setText(String.valueOf(pelicula.getVoteAverage()));

        portada = findViewById(R.id.ivDetalleMiniatura);
        fondo = findViewById(R.id.ivDetalleFondoPortada);

        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestTrailer();
            }
        });

        progressBar.setVisibility(View.VISIBLE);
        requestDetalles();

        //Cargar Imagenes
        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getPosterPath()).into(portada);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getBackdropPath()).into(fondo);

        //Adapter
        peliculasRecomendadas = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerDetalle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        adapter = new AdapterRecomendadoPeliculas(peliculasRecomendadas, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        requestRecommended();


    }

    private void requestTrailer() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoTrailerPelicula> call = client.getTrailers(pelicula.getId(), MainActivity.KEY);
        call.enqueue(new Callback<ListadoTrailerPelicula>() {
            @Override
            public void onResponse(Call<ListadoTrailerPelicula> call, Response<ListadoTrailerPelicula> response) {
                trailerKey = response.body().getTrailerResult().get(0).getKey();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+trailerKey)));

            }

            @Override
            public void onFailure(Call<ListadoTrailerPelicula> call, Throwable t) {

            }
        });
    }

    private void requestRecommended() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoPeliculas> call = client.getRecommendedMovies(pelicula.getId(), MainActivity.KEY);
        call.enqueue(new Callback<ListadoPeliculas>() {
            @Override
            public void onResponse(Call<ListadoPeliculas> call, Response<ListadoPeliculas> response) {
                peliculasRecomendadas = response.body().getResults();
                adapter.setLista(peliculasRecomendadas);
            }

            @Override
            public void onFailure(Call<ListadoPeliculas> call, Throwable t) {

            }
        });
    }

    private void requestDetalles() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<PeliculaExtended> call = client.getMovieDetails(pelicula.getId(), MainActivity.KEY);
        call.enqueue(new Callback<PeliculaExtended>() {
            @Override
            public void onResponse(Call<PeliculaExtended> call, Response<PeliculaExtended> response) {
                generosPeliculas = response.body().getGenres();
                generoPelicula.setText(generosPeliculas.get(0).getName());
            }

            @Override
            public void onFailure(Call<PeliculaExtended> call, Throwable t) {

            }
        });
    }

}
