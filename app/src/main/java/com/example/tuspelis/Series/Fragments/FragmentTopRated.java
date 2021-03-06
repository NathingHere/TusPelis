package com.example.tuspelis.Series.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Adapters.Adapter_Series;
import com.example.tuspelis.Series.Models.ListadoSerie;
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

public class FragmentTopRated extends Fragment {

    private View view;
    private TextView txtPrueba;
    private Adapter_Series adapter;
    private RecyclerView recyclerview;
    private List<Serie> listadoseries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments, container, false);
        txtPrueba = view.findViewById(R.id.txtPrueba);
        listadoseries = new ArrayList<>();
        recyclerview = view.findViewById(R.id.recyclerview);
        txtPrueba.setText("Mejor Valoradas");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new Adapter_Series(listadoseries, getActivity());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);
        sendPeticion();
        return view;
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
        Call<ListadoSerie> peticion = client.getTopRatedSeries(MainActivity.KEY);
        peticion.enqueue(new Callback<ListadoSerie>() {
            @Override
            public void onResponse(Call<ListadoSerie> call, Response<ListadoSerie> response) {
                listadoseries = response.body().getResults();
                adapter.setLista(listadoseries);
            }

            @Override
            public void onFailure(Call<ListadoSerie> call, Throwable t) {
                Toast.makeText(getContext(), "Fallo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
