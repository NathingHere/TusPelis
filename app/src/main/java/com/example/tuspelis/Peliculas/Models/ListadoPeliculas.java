package com.example.tuspelis.Peliculas.Models;

import java.util.ArrayList;

public class ListadoPeliculas {
    private ArrayList<Pelicula> results;

    public ListadoPeliculas(ArrayList<Pelicula> results) {
        this.results = results;
    }

    public ArrayList<Pelicula> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pelicula> results) {
        this.results = results;
    }
}
