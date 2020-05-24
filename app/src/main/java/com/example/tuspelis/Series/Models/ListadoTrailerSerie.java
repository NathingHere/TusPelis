package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListadoTrailerSerie implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("results")
    private ArrayList<TrailerSerie> trailerResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TrailerSerie> getTrailerResult() {
        return trailerResult;
    }

    public void setTrailerResult(ArrayList<TrailerSerie> trailerResult) {
        this.trailerResult = trailerResult;
    }

    protected ListadoTrailerSerie(Parcel in) {
        id = in.readInt();
        trailerResult = in.createTypedArrayList(TrailerSerie.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeTypedList(trailerResult);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListadoTrailerSerie> CREATOR = new Creator<ListadoTrailerSerie>() {
        @Override
        public ListadoTrailerSerie createFromParcel(Parcel in) {
            return new ListadoTrailerSerie(in);
        }

        @Override
        public ListadoTrailerSerie[] newArray(int size) {
            return new ListadoTrailerSerie[size];
        }
    };
}
