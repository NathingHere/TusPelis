package com.example.tuspelis.Peliculas.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.Peliculas.Adapters.AdapterListado;
import com.example.tuspelis.Peliculas.Models.ListadoPeliculas;
import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.R;
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

public class FragmentNowPlaying extends Fragment {
    private View v;
    private TextView txtPrueba;
    private AdapterListado adapter;
    private RecyclerView recyclerView;
    private List<Pelicula> listadoPeliculas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragments,container,false);
        txtPrueba = v.findViewById(R.id.txtPrueba);
        listadoPeliculas = new ArrayList<>();
        recyclerView = v.findViewById(R.id.recyclerview);
        txtPrueba.setText("En cines");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new AdapterListado(listadoPeliculas, getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        sendRequest();
        return v;
    }

    private void sendRequest() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoPeliculas> call = client.getNowPlaying(MainActivity.KEY);
        call.enqueue(new Callback<ListadoPeliculas>() {
            @Override
            public void onResponse(Call<ListadoPeliculas> call, Response<ListadoPeliculas> response) {
                 listadoPeliculas = response.body().getResults();
                 adapter.setLista(listadoPeliculas);
            }

            @Override
            public void onFailure(Call<ListadoPeliculas> call, Throwable t) {

            }
        });
    }
}
