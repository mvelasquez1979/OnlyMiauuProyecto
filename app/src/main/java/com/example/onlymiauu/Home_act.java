package com.example.onlymiauu;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import models.UserSession;

public class Home_act extends AppCompatActivity {

//////////////////////////

        TextView textpersona;

        UserSession usuClase = new UserSession();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_home);

            textpersona  = findViewById(R.id.textpersona);

            textpersona.setText(usuClase.getUserName());

        }

   /* public void irAdoptar(View vista){
        Intent miAdopta = new Intent(this, Adopta_act.class);
        startActivity(miAdopta);
    }
    public void irDarAdopcion(View vista){
        Intent miDarAdopcion = new Intent(this, DarAdopcion_act.class);
        startActivity(miDarAdopcion);
    }

    public void irRRSS(View vista){
        Intent miRRSS = new Intent(this, redes_act.class);
        startActivity(miRRSS);
    }

    public void irAyuda(View vista){
        Intent miAyuda = new Intent(this, ayuda_act.class);
        startActivity(miAyuda);
    }

    public void irEntrada(View vista){
        Intent miEntrada = new Intent(this, Ingresar_act.class);
        startActivity(miEntrada);
    }*/



/////////////////////////

    }
