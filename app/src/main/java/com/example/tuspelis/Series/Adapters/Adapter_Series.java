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
import com.example.tuspelis.Series.Models.Series;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Series extends RecyclerView.Adapter<Adapter_Series.SerieHolder> {

    private List<Series> seriesList;
    private Context context;


    public Adapter_Series(List<Series> seriesList, Context context) {
        this.seriesList = seriesList;
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
        Series serie = seriesList.get(position);
        holder.titulo.setText(serie.getName());

        Picasso.get().load("https://image.tmdb.org/t/p/original"+serie.getPoster_path()).into(holder.portada);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(context, SerieDetalle.class);
                intent.putExtra("data", serie);
                context.startActivity(intent);*/
                Toast.makeText(context, serie.getOriginal_name(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }

    public void setLista (List<Series> lista) {
        this.seriesList = lista;
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
