package com.example.tuspelis.Series.Models;

import java.util.ArrayList;

public class ListadoSerie {

    private ArrayList<Serie> results;
    private ArrayList<Seasons> seasons_results;

    public ArrayList<Seasons> getSeasons_results() {
        return seasons_results;
    }

    public void setSeasons_results(ArrayList<Seasons> seasons_results) {
        this.seasons_results = seasons_results;
    }

    public ListadoSerie(ArrayList<Serie> results, ArrayList<Seasons> seasons_results) {
        this.results = results;
        this.seasons_results = seasons_results;
    }

    public ArrayList<Serie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Serie> results) {
        this.results = results;
    }


}
