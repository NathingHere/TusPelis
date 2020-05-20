package com.example.tuspelis.Favoritos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuspelis.R;

public class FavoritosMain extends AppCompatActivity {
    TextView texto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listados);

        texto = findViewById(R.id.txtPruebaInicio);
        setTitle("Favoritos");
        texto.setText("Favoritos");
    }
}
