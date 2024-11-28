package com.example.onlymiauu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import models.Animales;
import models.Gatos;
import models.UserSession;

public class ExitoActivity extends AppCompatActivity {

    TextView textpersona2,textgato;

    UserSession usuClase = new UserSession();
    Animales gatoNombre = new Gatos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exito);

        textpersona2  = findViewById(R.id.textpersona2);
        textgato  = findViewById(R.id.textgato);

        textpersona2.setText(usuClase.getUserName());
        textgato.setText(gatoNombre.getAnimalName());

    }
    public void irAdoptarExito(View vista){
        Intent miAdopta = new Intent(this, Adopta_act.class);
        startActivity(miAdopta);
    }

}