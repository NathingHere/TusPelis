package com.example.tuspelis.Series.Models;

import java.util.ArrayList;

public class ListadoSerie {

    private ArrayList<Serie> results;

    public ListadoSerie(ArrayList<Serie> results) {
        this.results = results;
    }

    public ArrayList<Serie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Serie> results) {
        this.results = results;
    }


}
