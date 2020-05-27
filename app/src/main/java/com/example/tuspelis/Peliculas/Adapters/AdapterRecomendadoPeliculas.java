package com.example.tuspelis.Peliculas.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Models.Serie;
import com.example.tuspelis.Series.SerieDetalle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecomendadoPeliculas extends RecyclerView.Adapter<AdapterRecomendadoPeliculas.RecomendadoHolder>{

    private List<Pelicula> peliculaList;
    private Context context;

    public AdapterRecomendadoPeliculas(List<Pelicula> peliculaList, Context context) {
        this.peliculaList = peliculaList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecomendadoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecomendado,parent,false);
        RecomendadoHolder holder = new RecomendadoHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecomendadoHolder holder, int position) {
        Pelicula pelicula = peliculaList.get(position);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+pelicula.getPosterPath()).into(holder.ivPortada);

        holder.ivPortada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SerieDetalle.class);
                intent.putExtra("data", pelicula);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    public void setLista (List<Pelicula> lista) {
        this.peliculaList = lista;
        notifyDataSetChanged();
    }

    static class RecomendadoHolder extends RecyclerView.ViewHolder{
        ImageView ivPortada;

        public RecomendadoHolder(@NonNull View v){
            super(v);
            ivPortada = v.findViewById(R.id.portadaIvRecomendado);
        }
    }
}
