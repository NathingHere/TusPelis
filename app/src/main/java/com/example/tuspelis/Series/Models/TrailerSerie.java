package com.example.tuspelis.Series.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TrailerSerie implements Parcelable {

    @SerializedName("id")
    private String id;
    @SerializedName("iso_639_1")
    private String originalLanguage;
    @SerializedName("iso_3166_1")
    private String countryofOrigin;
    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;
    @SerializedName("site")
    private String site;
    @SerializedName("size")
    private int size;
    @SerializedName("type")
    private String tpye;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getCountryofOrigin() {
        return countryofOrigin;
    }

    public void setCountryofOrigin(String countryofOrigin) {
        this.countryofOrigin = countryofOrigin;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTpye() {
        return tpye;
    }

    public void setTpye(String tpye) {
        this.tpye = tpye;
    }

    protected TrailerSerie(Parcel in) {
        id = in.readString();
        originalLanguage = in.readString();
        countryofOrigin = in.readString();
        key = in.readString();
        name = in.readString();
        site = in.readString();
        size = in.readInt();
        tpye = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(originalLanguage);
        dest.writeString(countryofOrigin);
        dest.writeString(key);
        dest.writeString(name);
        dest.writeString(site);
        dest.writeInt(size);
        dest.writeString(tpye);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TrailerSerie> CREATOR = new Creator<TrailerSerie>() {
        @Override
        public TrailerSerie createFromParcel(Parcel in) {
            return new TrailerSerie(in);
        }

        @Override
        public TrailerSerie[] newArray(int size) {
            return new TrailerSerie[size];
        }
    };
}
