package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GenerosSeries implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected GenerosSeries(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GenerosSeries> CREATOR = new Creator<GenerosSeries>() {
        @Override
        public GenerosSeries createFromParcel(Parcel in) {
            return new GenerosSeries(in);
        }

        @Override
        public GenerosSeries[] newArray(int size) {
            return new GenerosSeries[size];
        }
    };
}
