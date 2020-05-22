package com.example.tuspelis.Series.Models;

import android.content.Context;

import java.util.ArrayList;

public class ListadoSeries {
    private ArrayList<Serie> results;

    public ListadoSeries(ArrayList<Serie> results) {
        this.results = results;
    }

    public ArrayList<Serie> getResults(){
        return results;
    }

    public void setResults(ArrayList<Serie> results){
        this.results = results;
    }
}
