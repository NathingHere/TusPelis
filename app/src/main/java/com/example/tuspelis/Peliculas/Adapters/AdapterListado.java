package com.example.tuspelis.Peliculas.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.Peliculas.PeliculaDetalle;
import com.example.tuspelis.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AdapterListado extends RecyclerView.Adapter<AdapterListado.PeliculaHolder> {

    private List<Pelicula> peliculas;
    private Context context;

    public AdapterListado(List<Pelicula> peliculas, Context context) {
        this.peliculas = peliculas;
        this.context = context;
    }

    @NonNull
    @Override
    public PeliculaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        PeliculaHolder holder = new PeliculaHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        holder.titulo.setText(pelicula.getTitle());

        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getPosterPath()).into(holder.portada);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PeliculaDetalle.class);
                intent.putExtra("data", peliculas.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public void setLista (List<Pelicula> lista) {
        this.peliculas = lista;
        notifyDataSetChanged();
    }

    static class PeliculaHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;
        TextView titulo;
        ImageView portada;

        public PeliculaHolder(@NonNull View v) {
            super(v);
            layout = v.findViewById(R.id.layout);
            titulo = v.findViewById(R.id.txtTituloItem);
            portada = v.findViewById(R.id.ivPortadaItem);
        }
    }

}

