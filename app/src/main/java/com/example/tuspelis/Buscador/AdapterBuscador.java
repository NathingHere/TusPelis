package com.example.tuspelis.Buscador;

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

import com.example.tuspelis.Peliculas.PeliculaDetalle;
import com.example.tuspelis.R;
import com.example.tuspelis.Series.SerieDetalle;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBuscador extends RecyclerView.Adapter<AdapterBuscador.BuscadorHolder>{

    private List<PeliculasBuscar> buscarList;
    private Context context;

    public AdapterBuscador(List<PeliculasBuscar> buscarList, Context context) {
        this.buscarList = buscarList;
        this.context = context;
    }

    @NonNull
    @Override
    public BuscadorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        BuscadorHolder holder = new BuscadorHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BuscadorHolder holder, int position) {
        PeliculasBuscar peliculasBuscar = buscarList.get(position);
        holder.titulo.setText(peliculasBuscar.getTitle());

        Picasso.get().load("https://image.tmdb.org/t/p/original"+ peliculasBuscar.getPoster_path()).into(holder.portada);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PeliculaDetalle.class);
                intent.putExtra("data", peliculasBuscar);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buscarList.size();
    }

    public void setLista(List<PeliculasBuscar> lista){
        this.buscarList = lista;
        notifyDataSetChanged();
    }

    static class BuscadorHolder extends RecyclerView.ViewHolder{
        LinearLayout layout;
        TextView titulo;
        ImageView portada;

        public BuscadorHolder (@NonNull View v){
            super(v);
            layout = v.findViewById(R.id.layout);
            titulo = v.findViewById(R.id.txtTituloItem);
            portada = v.findViewById(R.id.ivPortadaItem);
        }
    }
}
