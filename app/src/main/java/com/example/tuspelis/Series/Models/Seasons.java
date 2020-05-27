package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import retrofit2.SkipCallbackExecutor;

public class Seasons implements Parcelable {

    @SerializedName("air_date")
    private String air_date;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("name")
    private String name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("episode_count")
    private int episode_count;
    @SerializedName("season_number")
    private int season_number;
    @SerializedName("id")
    private int id;

    protected Seasons(Parcel in) {
        air_date = in.readString();
        poster_path = in.readString();
        name = in.readString();
        overview = in.readString();
        episode_count = in.readInt();
        id = in.readInt();
        season_number = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(air_date);
        dest.writeString(poster_path);
        dest.writeString(name);
        dest.writeString(overview);
        dest.writeInt(episode_count);
        dest.writeInt(id);
        dest.writeInt(season_number);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Seasons> CREATOR = new Creator<Seasons>() {
        @Override
        public Seasons createFromParcel(Parcel in) {
            return new Seasons(in);
        }

        @Override
        public Seasons[] newArray(int size) {
            return new Seasons[size];
        }
    };

    public String getAir_date() {
        return air_date;
    }

    public void setAir_date(String air_date) {
        this.air_date = air_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }
}
