package com.example.tuspelis.Peliculas.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListadoGenerosPeliculas {
    public ArrayList<GenerosPeliculas> getGenreResults() {
        return genreResults;
    }

    public void setGenreResults(ArrayList<GenerosPeliculas> genreResults) {
        this.genreResults = genreResults;
    }

    @SerializedName("genres")
    private ArrayList<GenerosPeliculas> genreResults;
}
