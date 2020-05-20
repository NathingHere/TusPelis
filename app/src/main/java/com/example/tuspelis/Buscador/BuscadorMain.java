package com.example.tuspelis.Buscador;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuspelis.R;
import com.google.android.material.textfield.TextInputEditText;

public class BuscadorMain extends AppCompatActivity {
    private ImageButton btnBuscar;
    private TextInputEditText txtTexto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscador);

        btnBuscar = findViewById(R.id.btnBuscar);
        txtTexto = findViewById(R.id.txtTextoBuscador);

        initApp();
    }
    private void initApp(){
        setBtnBuscar();
    }

    private void setBtnBuscar(){
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuscadorMain.this, "Buscando", Toast.LENGTH_SHORT).show();
                txtTexto.setText("");
            }
        });
    }
}
