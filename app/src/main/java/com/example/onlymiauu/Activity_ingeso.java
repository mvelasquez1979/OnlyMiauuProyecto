package com.example.onlymiauu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import models.Administrador;



public class Activity_ingeso extends AppCompatActivity {

   EditText etUsername, etPassword;
   Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ingeso);

        etUsername  = findViewById(R.id.etUsername);
        etPassword  = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        Intent miHome = new Intent(this, Home_act.class);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                Administrador adUser = new Administrador();

                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(Activity_ingeso.this,"Por favor, ingrese nombre de Usuario y Contraseña", Toast.LENGTH_SHORT).show();
                }else if(adUser.validaLogin(username,password)){

                    Toast.makeText(Activity_ingeso.this,"Login correcto" , Toast.LENGTH_LONG).show();
                    startActivity(miHome);
                }else if(!adUser.validaLogin(username,password)){

                    Toast.makeText(Activity_ingeso.this,"Login incorrecto ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void irRegistro(View vista){
        Intent miRegistro = new Intent(this, Activity_registro.class);
        startActivity(miRegistro);
    }

}