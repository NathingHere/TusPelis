package com.example.tuspelis.Buscador;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class PeliculasBuscar implements Parcelable {

    private double popularity,vote_average;
    private int vote_count,id;
    private boolean video,adult;
    private String poster_path,backdrop_path,original_language,original_title,title,overview,release_date;
    private List<Integer> genre_ids;

    protected PeliculasBuscar(Parcel in) {
        popularity = in.readDouble();
        vote_average = in.readDouble();
        vote_count = in.readInt();
        id = in.readInt();
        video = in.readByte() != 0;
        adult = in.readByte() != 0;
        poster_path = in.readString();
        backdrop_path = in.readString();
        original_language = in.readString();
        original_title = in.readString();
        title = in.readString();
        overview = in.readString();
        release_date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(popularity);
        dest.writeDouble(vote_average);
        dest.writeInt(vote_count);
        dest.writeInt(id);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        dest.writeString(original_language);
        dest.writeString(original_title);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(release_date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PeliculasBuscar> CREATOR = new Creator<PeliculasBuscar>() {
        @Override
        public PeliculasBuscar createFromParcel(Parcel in) {
            return new PeliculasBuscar(in);
        }

        @Override
        public PeliculasBuscar[] newArray(int size) {
            return new PeliculasBuscar[size];
        }
    };

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
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

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }
}


