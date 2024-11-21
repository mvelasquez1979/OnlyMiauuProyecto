package com.example.onlymiauu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.ViewTransitionController;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import models.Administrador;

public class Ingresar_act extends AppCompatActivity {

    EditText etUsername, etPassword;
    ImageButton btnIngresar, btnVolverIngresar;
    //Button btnIngresar = findViewById(R.id.btnIngresar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ingresar);

        etUsername  = findViewById(R.id.etUsername);
        etPassword  = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnVolverIngresar = findViewById(R.id.btnVolverIngresar);
        Intent miHome = new Intent(this, Home_act.class);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                Administrador adUser = new Administrador();

                if (username.isEmpty() || password.isEmpty()) //  <------------ login y/o contraseña esta vacío
                    Toast.makeText(Ingresar_act.this, "Por favor, ingrese nombre de Usuario y Contraseña", Toast.LENGTH_SHORT).show();
                else if(adUser.validaLogin(username,password)){  //  <------------ login y contraseña correcto
                    Toast.makeText(Ingresar_act.this,"Login correcto" , Toast.LENGTH_LONG).show();
                    startActivity(miHome);
                }else if(!adUser.validaLogin(username,password)){   //  <------------ login y/o contraseña incorrecto
                    Toast.makeText(Ingresar_act.this,"Login incorrecto ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void irRegistro(View view){
        Intent miRegistro = new Intent(this, Activity_registro.class);
        startActivity(miRegistro);
    }

    public void irMain(View view){
        Intent miMain = new Intent(this, MainActivity.class);
        startActivity(miMain);
    }
}





