package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Detalles_Serie implements Parcelable {

    @SerializedName("genres")
    private List<GenerosSeries> genres;

    protected Detalles_Serie(Parcel in) {
        genres = in.createTypedArrayList(GenerosSeries.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(genres);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Detalles_Serie> CREATOR = new Creator<Detalles_Serie>() {
        @Override
        public Detalles_Serie createFromParcel(Parcel in) {
            return new Detalles_Serie(in);
        }

        @Override
        public Detalles_Serie[] newArray(int size) {
            return new Detalles_Serie[size];
        }
    };

    public List<GenerosSeries> getGenres() {
        return genres;
    }

    public void setGenres(List<GenerosSeries> genres) {
        this.genres = genres;
    }
}
