package com.example.tuspelis.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuspelis.MainActivity;
import com.example.tuspelis.R;

public class Login extends AppCompatActivity {
    private EditText usuario, password;
    private TextView olvidar;
    private Button registro, entrar, invitado;
    private CheckBox recordar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        usuario = findViewById(R.id.usuariotxt);
        password = findViewById(R.id.passwordtxt);
        olvidar = findViewById(R.id.olvidartxt);
        invitado = findViewById(R.id.invitadoBtn);
        entrar = findViewById(R.id.entrarBtn);
        registro = findViewById(R.id.registroBtn);
        recordar = findViewById(R.id.recordarBox);

        initApp();
    }

    private void initApp(){
        registroInput();
        entrarInput();
        invitadoInput();
    }

    private void registroInput(){
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Pulsaste el boton de registrarse", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void entrarInput(){
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Pulsaste el boton de entrar", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void invitadoInput(){
        invitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "Pulsaste el boton de invitado", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
