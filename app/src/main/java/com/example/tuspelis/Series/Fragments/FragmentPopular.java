package com.example.tuspelis.Series.Fragments;

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
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Adapters.Adapter_Series;
import com.example.tuspelis.Series.Models.ListadoSeries;
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

public class FragmentPopular extends Fragment {

    private View view;
    private TextView txtPrueba;
    private Adapter_Series adapter;
    private RecyclerView recyclerView;
    private List<Serie> listadoseries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments, container, false);
        txtPrueba = view.findViewById(R.id.txtPrueba);
        listadoseries = new ArrayList<>();
        txtPrueba.setText("Popular");
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new Adapter_Series(listadoseries, getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void sentPeticion(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ListadoSeries> call = client.getPopularSeries(MainActivity.KEY);
        call.enqueue(new Callback<ListadoSeries>() {
            @Override
            public void onResponse(Call<ListadoSeries> call, Response<ListadoSeries> response) {
                listadoseries = response.body().getResults();
                adapter.setLista(listadoseries);
            }

            @Override
            public void onFailure(Call<ListadoSeries> call, Throwable t) {

            }
        });
    }
}
