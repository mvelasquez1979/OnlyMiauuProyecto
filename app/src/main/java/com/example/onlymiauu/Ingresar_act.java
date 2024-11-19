package com.example.onlymiauu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import models.UserSession;
import models.RedAdmin;


public class Ingresar_act extends AppCompatActivity {

    EditText etUsername, etPassword;
    ImageButton btnIngresar, btnVolverIngresar;

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
                String usernameT = etUsername.getText().toString().trim();
                String passwordT = etPassword.getText().toString().trim();

                if (usernameT.isEmpty() || passwordT.isEmpty()) //  <------------ login y/o contraseña esta vacío
                    Toast.makeText(Ingresar_act.this, "Por favor, ingrese nombre de Usuario y Contraseña", Toast.LENGTH_SHORT).show();
                else {

                    RedAdmin networkUtils = new RedAdmin();
                    UserSession usuActual = new UserSession();

                    // URL del JSON
                    //String ipLocal = networkUtils.localIps();
                    //String url = "http://192.168.1.108/onlymiauu/listaUsuarios.php"; // URL de lista de usuarios
                    String url = "http://10.110.47.72/onlymiauu/listaUsuarios.php"; // URL de lista de usuarios
                    //String url = "http://" + ipLocal.trim() +"/onlymiauu/listaUsuarios.php"; // URL de lista de usuarios

                    // Crear una cola de solicitudes
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

                    // Hacer una solicitud JSON Array
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                            Request.Method.GET,
                            url,
                            null,
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) { //Instancia el JSONArray en el objeto response
                                    try {
                                        // Iterar por cada objeto en el JSONArray
                                        boolean entroAOnly = false;
                                        for (int i = 0; i < response.length(); i++) {
                                            JSONObject jsonObject = response.getJSONObject(i);
                                            String usernamej = jsonObject.getString("username");
                                            String pwdj = jsonObject.getString("pwd");
                                            String nombrej = jsonObject.getString("nombre");

                                            // revisar credenciales

                                            if(usernameT.equals(usernamej) && passwordT.equals(pwdj)){
                                                usuActual.setUserName(nombrej.trim());
                                                entroAOnly = true;
                                                Toast.makeText(Ingresar_act.this,"Bienvenid@: " + nombrej , Toast.LENGTH_LONG).show();
                                                startActivity(miHome);
                                            }else{
                                                if( i == response.length()-1){
                                                    if (!entroAOnly) {
                                                        Toast.makeText(Ingresar_act.this, "Login incorrecto ", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    // Mostrar un mensaje en caso de error
                                    Toast.makeText(Ingresar_act.this, "Error al obtener datos: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    // Agregar la solicitud a la cola
                    requestQueue.add(jsonArrayRequest);
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





