package com.example.tuspelis.Series.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.Peliculas.Models.Pelicula;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.Models.Serie;
import com.example.tuspelis.Series.SerieDetalle;

import java.util.List;

public class Adapter_Series extends RecyclerView.Adapter<Adapter_Series.SerieHolder> {

    private List<Serie> series;
    private Context context;

    public Adapter_Series(List<Serie> series, Context context) {
        this.series = series;
        this.context = context;
    }

    @NonNull
    @Override
    public SerieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        SerieHolder holder = new SerieHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SerieHolder holder, int position) {
        Serie serie = series.get(position);


    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public void setLista (List<Serie> lista) {
        this.series = lista;
        notifyDataSetChanged();
    }

    static class SerieHolder extends RecyclerView.ViewHolder{

        public SerieHolder(@NonNull View v) {
            super(v);
        }
    }
}
