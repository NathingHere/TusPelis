package com.example.tuspelis.Buscador;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ResultadoBuscar implements Parcelable {

    private int page, total_results, total_pages;
    private List<PeliculasBuscar> results;


    protected ResultadoBuscar(Parcel in) {
        page = in.readInt();
        total_results = in.readInt();
        total_pages = in.readInt();
        results = in.createTypedArrayList(PeliculasBuscar.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(total_results);
        dest.writeInt(total_pages);
        dest.writeTypedList(results);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResultadoBuscar> CREATOR = new Creator<ResultadoBuscar>() {
        @Override
        public ResultadoBuscar createFromParcel(Parcel in) {
            return new ResultadoBuscar(in);
        }

        @Override
        public ResultadoBuscar[] newArray(int size) {
            return new ResultadoBuscar[size];
        }
    };

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<PeliculasBuscar> getResults() {
        return results;
    }

    public void setResults(List<PeliculasBuscar> results) {
        this.results = results;
    }

    public void setResults(ArrayList<PeliculasBuscar> results) {
        this.results = results;
    }
}
