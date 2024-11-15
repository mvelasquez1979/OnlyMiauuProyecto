package com.example.onlymiauu;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

public class Adopta_act extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adopta); // Asegúrate de establecer el contenido correcto

        // Inicializar dataList y ListView
        dataList = new ArrayList<>();
        listView = findViewById(R.id.listView); // ListView en el Activity
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);

        // URL del JSON
        String url = "http://10.110.44.155/onlymiauu/consultar.php"; // Reemplaza con tu URL local

        // Crear una cola de solicitudes
        RequestQueue requestQueue = Volley.newRequestQueue(this);

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
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String nombre = jsonObject.getString("nombre");
                                String color = jsonObject.getString("color");
                                String raza = jsonObject.getString("raza");

                                // Construir la cadena y agregarla al ArrayList
                                //String item = nombre + " - " + raza + " - " + color;
                                dataList.add("Nombre: " + nombre + " - Raza: " + raza + " - Color: " + color);
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
    public final void adopta(){
        TextView nombreIngresado = findViewById(R.id.txtNombre);
        //TextView sueldoIngresado = findViewById(R.id.txtSueldo);

        String vNombreIngresado = nombreIngresado.getText().toString().trim();
        //Integer vSueldoIngresado = Integer.parseInt(sueldoIngresado.getText().toString().trim());

        // Verificar que el nombre no esté vacío
        if (vNombreIngresado.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un nombre", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear la URL para la actualización
        String url2 = "http://10.110.44.155/onlymiauu/updateAdopcion.php"; // Cambia esto a tu URL real

        // Crear la cola de solicitudes
        RequestQueue requestQueue2 = Volley.newRequestQueue(this);

        // Crear la solicitud de actualización
        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, url2,
                response -> {
                    // Manejar la respuesta
                    if (response.equals("success")) {
                        Toast.makeText(this, "Adopción registrada con éxito", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Error al registrar la adopción", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> Toast.makeText(this, "Error en la conexión: " + error.getMessage(), Toast.LENGTH_SHORT).show()
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", vNombreIngresado);
                return params;
            }
        };

        // Agregar la solicitud a la cola
        requestQueue2.add(stringRequest2);
    }

}
