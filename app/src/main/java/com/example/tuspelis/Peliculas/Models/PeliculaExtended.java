package com.example.tuspelis.Peliculas.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaExtended {
    public List<GenerosPeliculas> getGenres() {
        return genres;
    }

    public void setGenres(List<GenerosPeliculas> genres) {
        this.genres = genres;
    }

    @SerializedName("genres")
    private List<GenerosPeliculas> genres;
}
