package com.example.onlymiauu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import models.Administrador;

public class Activity_registro extends AppCompatActivity implements  View.OnClickListener{

    EditText etNombreUsuario, etEmailUsuario, etContraUsuario;
    Button btnAtras,btnAceptar;
    RequestQueue requestQueue;
    private static final String URL1 = "http://10.110.44.155/onlymiauu/registrar.php";
    Administrador rUsuario = new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);// <------------------------------------
        setContentView(R.layout.activity_registro);

        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();

        btnAceptar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);
    }

    @SuppressLint("WrongViewCast")
    private void initUI(){
        //EditText
        etNombreUsuario = findViewById(R.id.etNombre);
        etEmailUsuario = findViewById(R.id.etRaza);
        etContraUsuario = findViewById(R.id.etColores);

        //Botones
        btnAtras = findViewById(R.id.btnAtras);
        btnAceptar = findViewById(R.id.btnAceptar);
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        if (id == R.id.btnAceptar){

            String nombre = etNombreUsuario.getText().toString().trim();
            String username = etEmailUsuario.getText().toString().trim();
            String pwd = etContraUsuario.getText().toString().trim();
            if(!rUsuario.textVacios(3,nombre,username,pwd)) {
                registrarUsuario(nombre, username, pwd);
            }else{
                Toast.makeText(Activity_registro.this,"Por favor, ingrese los datos completos", Toast.LENGTH_SHORT).show();
            }
        }else if (id == R.id.btnAtras){
            Intent miIngreso = new Intent(this, Ingresar_act.class);
            startActivity(miIngreso);        }
    }

    private void registrarUsuario( String nombre, String username, String pwd){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override

                    public void onResponse(String response) {
                        Toast.makeText(Activity_registro.this, "Usuario agregado", Toast.LENGTH_LONG).show();
                        etNombreUsuario.setText("");
                        etEmailUsuario.setText("");
                        etContraUsuario.setText("");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Activity_registro.this, "Error en agregar usuario", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("username", username);
                params.put("pwd", pwd);
                return params;
            }
        };

        requestQueue.add(stringRequest);

    }


}