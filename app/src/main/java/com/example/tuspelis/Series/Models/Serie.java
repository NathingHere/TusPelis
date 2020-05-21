package com.example.tuspelis.Series.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Serie implements Serializable {

    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("name")
    private String name;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("genre_ids")
    private List<Integer> genreId;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("number_of_seasons")
    private int number_of_seasons;
    @SerializedName("number_of_episodes")
    private int number_of_episodes;
    @SerializedName("status")
    private String status;

    public Serie(int voteCount, int id, double voteAverage, String name, double popularity, String posterPath, String originalLanguage, List<Integer> genreId, boolean adult, String overview, int number_of_seasons, int number_of_episodes, String status) {
        this.voteCount = voteCount;
        this.id = id;
        this.voteAverage = voteAverage;
        this.name = name;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.genreId = genreId;
        this.adult = adult;
        this.overview = overview;
        this.number_of_seasons = number_of_seasons;
        this.number_of_episodes = number_of_episodes;
        this.status = status;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public List<Integer> getGenreId() {
        return genreId;
    }

    public void setGenreId(List<Integer> genreId) {
        this.genreId = genreId;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getNumber_of_seasons() {
        return number_of_seasons;
    }

    public void setNumber_of_seasons(int number_of_seasons) {
        this.number_of_seasons = number_of_seasons;
    }

    public int getNumber_of_episodes() {
        return number_of_episodes;
    }

    public void setNumber_of_episodes(int number_of_episodes) {
        this.number_of_episodes = number_of_episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
