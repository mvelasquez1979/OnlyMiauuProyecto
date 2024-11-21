package com.example.onlymiauu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.ViewTransitionController;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.RedAdmin;


public class Adopta_act extends AppCompatActivity {

    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adopta); // Asegúrate de establecer el contenido correcto

        // Inicializar dataList y ListView
        dataList = new ArrayList<>();
        ListView listView = findViewById(R.id.listView); // ListView en el Activity
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        RedAdmin networkUtils = new RedAdmin(); // Instanciar la clase RedAdmin: Donde se encuentra el parametro IP del servidor PHP para los servicios

        // URL del JSON
        String url = "http://"+ networkUtils.getIpLocal().trim() +"/onlymiauu/consultar.php"; // URL de lista de usuarios

        // URL del JSON
        //String url = "http://192.168.1.10/onlymiauu/consultar.php"; // Reemplaza con tu URL local

        // Crear una cola de solicitudes
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Hacer una solicitud JSON Array
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.POST,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) { //Instancia el JSONArray en el objeto response
                        try {
                            // Iterar por cada objeto en el JSONArray
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String nombre = jsonObject.getString("nombre");
                                String color = jsonObject.getString("color");
                                String raza = jsonObject.getString("raza");

                                // Construir la cadena y agregarla al ArrayList
                                //String item = nombre + " - " + raza + " - " + color;
                                dataList.add("Código: " +  id + " - Nombre: " + nombre + " - Raza: " + raza + " - Color: " + color);
                            }
                            // Notificar al adapter que los datos han cambiado
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Mostrar un mensaje en caso de error
                        Toast.makeText(Adopta_act.this, "Error al obtener datos: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // Agregar la solicitud a la cola
        requestQueue.add(jsonArrayRequest);

    }
    // Método para Adoptar(sin cambios)
    public void adopta(View vista){
        TextView nombreIngresado = findViewById(R.id.txtNombre);
        String vNombreIngresado = nombreIngresado.getText().toString().trim();

         //Verificar que el nombre no esté vacío
        if (vNombreIngresado.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un Código", Toast.LENGTH_SHORT).show();
            return;
        }

//-------------------------------------------------------------------------------
        RequestQueue requestQueue2 = Volley.newRequestQueue(this);

        EditText txtNombre = findViewById(R.id.txtNombre);
        EditText txtEdad = findViewById(R.id.txtEdad);
        EditText txtSueldo = findViewById(R.id.txtSueldo);
        
        RedAdmin redUtils = new RedAdmin();
        String URL2 = "http://"+ redUtils.getIpLocal() +"/onlymiauu/updateAdopcion.php";

        //String vtxtNombre = String.valueOf(txtSueldo.getText());
        String vtxtNombre = String.valueOf(txtSueldo.getText());
        StringRequest stringRequest2 = new StringRequest(
                Request.Method.POST,
                URL2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Adopta_act.this, "Listo! Puedes retirar a tu nuev@ amig@", Toast.LENGTH_LONG).show();
                        txtNombre.setText("");
                        txtEdad.setText("");
                        txtSueldo.setText("");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Adopta_act.this, "Error en actualizar estado", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", vNombreIngresado);
                return params;
            }
        };

        requestQueue2.add(stringRequest2);




//-------------------------------------------------------------------------------

    }

    public void irHome(View vista){
        Intent miHome = new Intent(this, Home_act.class);
        startActivity(miHome);
    }



}
