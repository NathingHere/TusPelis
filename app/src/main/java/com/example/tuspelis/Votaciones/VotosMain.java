package com.example.tuspelis.Votaciones;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuspelis.R;

public class VotosMain extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listados);

        texto = findViewById(R.id.txtPruebaInicio);
        setTitle("Tus Votos");
        texto.setText("Votaciones");
    }
}
