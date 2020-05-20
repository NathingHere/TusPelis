package com.example.tuspelis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tuspelis.Peliculas.PeliculasMain;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ImageButton peliculas, series, watchLater, fav, buscador, votaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        peliculas = findViewById(R.id.btnPeliculas);
        series = findViewById(R.id.btnSeries);
        watchLater = findViewById(R.id.btnWatch);
        fav = findViewById(R.id.btnFav);
        buscador = findViewById(R.id.btnBuscador);
        votaciones = findViewById(R.id.btnVotos);

        initApp();
    }

    private void initApp(){
        optionPeliculas();
        optionSeries();
        optionWatchLater();
        optionFav();
        optionBuscador();
        optionVotos();
    }

    private void optionPeliculas(){
        peliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PeliculasMain.class);
                startActivity(i);
            }
        });
    }

    private void optionSeries(){
        series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Series", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void optionWatchLater(){
        watchLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Watch Later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void optionFav(){
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void optionVotos(){
        votaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Votos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void optionBuscador(){
        buscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Buscador", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_sobreNosotros:
                Toast.makeText(this, "Pinchaste en 'Sobre Nosotros'", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_config:
                Toast.makeText(this, "Pinchaste en 'Configuración de la Cuenta", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
