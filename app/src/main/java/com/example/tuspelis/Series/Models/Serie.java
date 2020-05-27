package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Query;

public class Serie implements Parcelable {

    @SerializedName("original_name")
    private String original_name;
    @SerializedName("genre_ids")
    private List<Integer> genre_ids;
    @SerializedName("name")
    private String name;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("origin_country")
    private List<String> origin_country;
    @SerializedName("vote_count")
    private int vote_count;
    @SerializedName("first_air_date")
    private String first_air_date;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("seasons")
    private List<Seasons> seasons;


    protected Serie(Parcel in) {
        original_name = in.readString();
        name = in.readString();
        popularity = in.readDouble();
        origin_country = in.createStringArrayList();
        vote_count = in.readInt();
        first_air_date = in.readString();
        backdrop_path = in.readString();
        original_language = in.readString();
        id = in.readInt();
        vote_average = in.readDouble();
        overview = in.readString();
        poster_path = in.readString();
        seasons = in.createTypedArrayList(Seasons.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(original_name);
        dest.writeString(name);
        dest.writeDouble(popularity);
        dest.writeStringList(origin_country);
        dest.writeInt(vote_count);
        dest.writeString(first_air_date);
        dest.writeString(backdrop_path);
        dest.writeString(original_language);
        dest.writeInt(id);
        dest.writeDouble(vote_average);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeTypedList(seasons);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Serie> CREATOR = new Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel in) {
            return new Serie(in);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
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

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Seasons> seasons) {
        this.seasons = seasons;
    }
}
