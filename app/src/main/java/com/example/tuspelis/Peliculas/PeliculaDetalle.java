package com.example.tuspelis.Peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.R;
import com.squareup.picasso.Picasso;

public class PeliculaDetalle extends AppCompatActivity {

    private Pelicula pelicula;
    ImageView portada, fondo;
    TextView titulo, fechaSalida, review;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detallepelisseries);

        Intent intent = getIntent();
        pelicula = intent.getParcelableExtra("data");

        titulo = findViewById(R.id.txtDetallleTitulo);
        titulo.setText(pelicula.getTitle());
        fechaSalida = findViewById(R.id.txtDetalleFecha);
        fechaSalida.setText(pelicula.getReleaseDate());
        review = findViewById(R.id.txtDetalleReview);
        review.setText(pelicula.getOverview());

        portada = findViewById(R.id.ivDetalleMiniatura);
        fondo = findViewById(R.id.ivDetalleFondoPortada);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getPosterPath()).into(portada);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getBackdropPath()).into(fondo);
    }


}
