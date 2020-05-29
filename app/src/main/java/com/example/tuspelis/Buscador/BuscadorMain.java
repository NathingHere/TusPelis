package com.example.tuspelis.Buscador;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.R;
import com.example.tuspelis.WebService.MyClient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscadorMain extends AppCompatActivity {
    private ImageButton btnBuscar;
    private TextInputEditText txtTexto;
    private String nombre;
    private RecyclerView recyclerView;
    private List<PeliculasBuscar> buscarList;
    private AdapterBuscador adapterBuscador;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador);

        btnBuscar = findViewById(R.id.btnBuscar);
        txtTexto = findViewById(R.id.txtTextoBuscador);

        initApp();
    }
    private void initApp(){
        setBtnBuscar();
    }

    private void setBtnBuscar(){
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuscadorMain.this, "Buscando", Toast.LENGTH_SHORT).show();
                nombre = txtTexto.getText().toString();
                setupView();
                txtTexto.setText("");

            }
        });
    }
    private void setupView(){
        buscarList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerbuscador);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapterBuscador = new AdapterBuscador(buscarList,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterBuscador);
        lanzarPeticion(nombre);
    }

    private void lanzarPeticion(String nombre){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        MyClient client = retrofit.create(MyClient.class);
        Call<ResultadoBuscar> call = client.buscarPorPalabra(MainActivity.KEY, nombre);
        call.enqueue(new Callback<ResultadoBuscar>() {
            @Override
            public void onResponse(Call<ResultadoBuscar> call, Response<ResultadoBuscar> response) {

                buscarList = response.body().getResults();
                adapterBuscador.setLista(buscarList);
            }

            @Override
            public void onFailure(Call<ResultadoBuscar> call, Throwable t) {
                Toast.makeText(BuscadorMain.this, "Fallo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
