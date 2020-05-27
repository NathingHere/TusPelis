package com.example.tuspelis.Series;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Adapters.Adapter_Series;
import com.example.tuspelis.Series.Adapters.Adapter_Series_Seasons;
import com.example.tuspelis.Series.Models.Detalles_Serie;
import com.example.tuspelis.Series.Models.ListadoSerie;
import com.example.tuspelis.Series.Models.Seasons;
import com.example.tuspelis.Series.Models.Serie;
import com.example.tuspelis.WebService.MyClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Series_Seasons extends AppCompatActivity {

    private TextView textView;
    private RecyclerView recyclerView;
    private Seasons season;
    private Serie serie;
    private Adapter_Series_Seasons adapter;
    private List<Seasons> listado_seasons;
    private int id_tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey("data_season")){
            serie = bundle.getParcelable("data_season");
            id_tv = serie.getId();
        }

        textView = findViewById(R.id.txtPrueba);
        recyclerView = findViewById(R.id.recyclerview);
        listado_seasons = new ArrayList<>();
        textView.setText("Temporadas");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter_Series_Seasons(listado_seasons, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        sendPeticion();
    }

    private void sendPeticion(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<Detalles_Serie> call = client.getSerieDetails(id_tv, MainActivity.KEY);
        call.enqueue(new Callback<Detalles_Serie>() {
            @Override
            public void onResponse(Call<Detalles_Serie> call, Response<Detalles_Serie> response) {
                listado_seasons = response.body().getSeasons();
                adapter.setLista(listado_seasons);
            }

            @Override
            public void onFailure(Call<Detalles_Serie> call, Throwable t) {

            }
        });



    }
}
