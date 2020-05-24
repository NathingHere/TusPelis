package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Networks implements Parcelable {
    private int id;
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

    protected Networks(Parcel in) {
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

    public static final Creator<Networks> CREATOR = new Creator<Networks>() {
        @Override
        public Networks createFromParcel(Parcel in) {
            return new Networks(in);
        }

        @Override
        public Networks[] newArray(int size) {
            return new Networks[size];
        }
    };
}
