package com.example.tuspelis.Peliculas.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tuspelis.R;

public class FragmentGeneralPeliculas extends Fragment {
    View view;
    TextView txtPrueba;
    String title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragments,container,false);
        txtPrueba = view.findViewById(R.id.txtPrueba);

        if(getArguments() != null){
            title = getArguments().getString("title");
        }

        txtPrueba.setText(title);
        return view;
    }
}
