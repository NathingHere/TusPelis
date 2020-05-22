package com.example.tuspelis.Peliculas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class ListadoTrailerPelicula {
    @SerializedName("id")
    private int id;
    @SerializedName("results")
    private ArrayList<TrailerPelicula> trailerResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TrailerPelicula> getTrailerResult() {
        return trailerResult;
    }

    public void setTrailerResult(ArrayList<TrailerPelicula> trailerResult) {
        this.trailerResult = trailerResult;
    }
}

