package com.example.tuspelis.Series.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuspelis.R;
import com.example.tuspelis.Series.Models.Serie;
import com.example.tuspelis.Series.SerieDetalle;
import com.squareup.picasso.Picasso;

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
        holder.titulo.setText(serie.getName());



        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SerieDetalle.class);
                intent.putExtra("data", series.get(position));
                context.startActivity(intent);
            }
        });

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

        LinearLayout layout;
        TextView titulo;
        ImageView portada;

        public SerieHolder(@NonNull View v) {
            super(v);
            layout = v.findViewById(R.id.layout);
            titulo = v.findViewById(R.id.txtTituloItem);
            portada = v.findViewById(R.id.ivPortadaItem);

        }
    }
}
