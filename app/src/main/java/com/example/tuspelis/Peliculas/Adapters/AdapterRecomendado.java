package com.example.tuspelis.Peliculas.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.R;
import com.example.tuspelis.Series.Models.Serie;
import com.example.tuspelis.Series.SerieDetalle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecomendado extends RecyclerView.Adapter<AdapterRecomendado.RecomendadoHolder>{

    private List<Serie> serie;
    private Context context;

    public AdapterRecomendado(List<Serie> serie, Context context) {
        this.serie = serie;
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
        Serie series = serie.get(position);
        Picasso.get().load("https://image.tmdb.org/t/p/original"+series.getPoster_path()).into(holder.ivPortada);

        holder.ivPortada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SerieDetalle.class);
                intent.putExtra("data", series);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return serie.size();
    }

    public void setLista (List<Serie> lista) {
        this.serie = lista;
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
