package com.example.tuspelis.Series;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.Peliculas.Adapters.AdapterListado;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Adapters.Adapter_Series;
import com.example.tuspelis.Series.Models.Detalles_Serie;
import com.example.tuspelis.Series.Models.GenerosSeries;
import com.example.tuspelis.Series.Models.ListadoSerie;
import com.example.tuspelis.Series.Models.ListadoTrailerSerie;
import com.example.tuspelis.Series.Models.Serie;
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

public class SerieDetalle extends AppCompatActivity {

    private Serie serie;
    private String trailerkey, genero;
    private ImageView portada, fondo;
    private TextView titulo, fecha_estreno, descripcion, valoracion, generoserie;
    private FloatingActionButton trailer;
    private Adapter_Series adapter;
    private RecyclerView recyclerView;
    private List<GenerosSeries> generosSeries;
    private List<Serie> seriesRecomendadas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepelisseries);

        Intent intent = getIntent();

        serie = intent.getParcelableExtra("data");

        trailer = findViewById(R.id.btnDetalleTrailer);
        titulo = findViewById(R.id.txtDetallleTitulo);
        titulo.setText(serie.getName());
        fecha_estreno = findViewById(R.id.txtDetalleFecha);
        fecha_estreno.setText(serie.getFirst_air_date());
        descripcion = findViewById(R.id.txtDetalleDescripcion);
        descripcion.setText(serie.getOverview());
        valoracion = findViewById(R.id.txtDetalleValoracion);
        valoracion.setText(String.valueOf(serie.getVote_average()));
        generoserie = findViewById(R.id.txtDetalleGenero);
        generoserie.setText(genero);

        portada = findViewById(R.id.ivDetalleMiniatura);
        fondo = findViewById(R.id.ivDetalleFondoPortada);

        Picasso.get().load("https://image.tmdb.org/t/p/original"+serie.getPoster_path()).into(portada);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+serie.getBackdrop_path()).into(fondo);
        
        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestTrailer();
            }
        });

        requestDetails();

        seriesRecomendadas = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerDetalle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new Adapter_Series(seriesRecomendadas, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        requestRecommended();
    }
    
    private void requestTrailer(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoTrailerSerie> call = client.getTrailersSeries(serie.getId(), MainActivity.KEY);
        call.enqueue(new Callback<ListadoTrailerSerie>() {
            @Override
            public void onResponse(Call<ListadoTrailerSerie> call, Response<ListadoTrailerSerie> response) {
                trailerkey = response.body().getTrailerResult().get(0).getKey();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+ trailerkey)));
            }

            @Override
            public void onFailure(Call<ListadoTrailerSerie> call, Throwable t) {
                Toast.makeText(SerieDetalle.this, "FALLO EL TRAILER", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestDetails(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<Detalles_Serie> call = client.getSerieDetails(serie.getId(), MainActivity.KEY);
        call.enqueue(new Callback<Detalles_Serie>() {
            @Override
            public void onResponse(Call<Detalles_Serie> call, Response<Detalles_Serie> response) {
                generosSeries = response.body().getGenres();
                generoserie.setText(generosSeries.get(0).getName());
            }

            @Override
            public void onFailure(Call<Detalles_Serie> call, Throwable t) {

            }
        });
    }

    private void requestRecommended(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoSerie> call = client.getRecommendedSeries(serie.getId(), MainActivity.KEY);
        call.enqueue(new Callback<ListadoSerie>() {
            @Override
            public void onResponse(Call<ListadoSerie> call, Response<ListadoSerie> response) {
                seriesRecomendadas = response.body().getResults();
                adapter.setLista(seriesRecomendadas);
            }

            @Override
            public void onFailure(Call<ListadoSerie> call, Throwable t) {

            }
        });
    }
}
