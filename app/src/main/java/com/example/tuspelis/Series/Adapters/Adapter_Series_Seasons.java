package com.example.tuspelis.Series.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.R;
import com.example.tuspelis.Series.Models.Seasons;
import com.example.tuspelis.Series.Models.Serie;
import com.example.tuspelis.Series.Series_Seasons;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Series_Seasons extends RecyclerView.Adapter<Adapter_Series_Seasons.SerieSeasonHolder> {

    private List<Seasons> seasons;
    private Context context;

    public Adapter_Series_Seasons(List<Seasons> seasons, Context context) {
        this.seasons = seasons;
        this.context = context;
    }

    @NonNull
    @Override
    public SerieSeasonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        SerieSeasonHolder holder = new SerieSeasonHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SerieSeasonHolder holder, int position) {
        Seasons season = seasons.get(position);
        holder.titulo.setText(season.getName());

        Picasso.get().load("https://image.tmdb.org/t/p/original"+season.getPoster_path()).into(holder.portada);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Episodios: " + season.getEpisode_count(), Toast.LENGTH_SHORT).show();
                Toast.makeText(context, "Fecha de lanzamiento: " + season.getAir_date(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return seasons.size();
    }

    public void setLista (List<Seasons> lista) {
        this.seasons = lista;
        notifyDataSetChanged();
    }

    static class SerieSeasonHolder extends RecyclerView.ViewHolder{

        LinearLayout layout;
        TextView titulo;
        ImageView portada;

        public SerieSeasonHolder(@NonNull View v) {
            super(v);
            layout = v.findViewById(R.id.layout);
            titulo = v.findViewById(R.id.txtTituloItem);
            portada = v.findViewById(R.id.ivPortadaItem);

        }
    }
}

