package com.example.tuspelis.Peliculas;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.Peliculas.Models.GenerosPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoGenerosPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoPeliculas;
import com.example.tuspelis.Peliculas.Models.ListadoTrailerPelicula;
import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.Peliculas.Models.TrailerPelicula;
import com.example.tuspelis.R;
import com.example.tuspelis.WebService.MyClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

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

    Context context;

    String genero;
    ImageView portada, fondo;
    TextView titulo, fechaSalida, descripcion, valoraciones, generoPelicula;
    FloatingActionButton trailer;
    List<GenerosPeliculas> generosPeliculas;

    String trailerKey;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepelisseries);

        Intent intent = getIntent();
        pelicula = intent.getParcelableExtra("data");

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

        //request();

        generoPelicula = findViewById(R.id.txtDetalleGenero);
        generoPelicula.setText(genero);

        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getPosterPath()).into(portada);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getBackdropPath()).into(fondo);


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

    public void request() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoGenerosPeliculas> call = client.getGenerosPeliculas(MainActivity.KEY);
        call.enqueue(new Callback<ListadoGenerosPeliculas>() {
            @Override
            public void onResponse(Call<ListadoGenerosPeliculas> call, Response<ListadoGenerosPeliculas> response) {
                generosPeliculas = response.body().getGenreResults();
                for(int i=0; i<generosPeliculas.size(); i++) {
                    if (pelicula.getGenreId().get(0) == generosPeliculas.get(i).getId()) { //coger lista de id de la peliculadetalle
                        genero = generosPeliculas.get(i).getName();
                        break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ListadoGenerosPeliculas> call, Throwable t) {

            }
        });
    }

}
