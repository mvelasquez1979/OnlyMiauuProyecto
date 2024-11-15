package com.example.onlymiauu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
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

public class DarAdopcion_act extends AppCompatActivity implements View.OnClickListener {

    //Inicializar los controles
    EditText etNombre, etRaza, etColores;
    Button btnAtras, btnAceptar;

    //Incializar el arreglo para el spinner
    private Spinner spnSexos;
    String[] sexos = {"Hembra", "Macho"};

    private static final int PICK_IMAGE = 50; // Para la carga de la foto
    Uri imageUri;
    ImageView foto_gallery;

    RequestQueue requestQueue;// para le conexion con la BBDD
    private static final String URL1 = "http://192.168.56.1/onlymiauu/darAdopcion.php";
    Administrador rUsuario = new Administrador(); // Instanciamos clase Administrador para las validaciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dar_adopcion);

        requestQueue = Volley.newRequestQueue(this);

        // Inicialización de las vistas
        etNombre = findViewById(R.id.etNombre);
        etRaza = findViewById(R.id.etRaza);
        etColores = findViewById(R.id.etColores);
        btnAtras = findViewById(R.id.btnAtras);
        btnAceptar = findViewById(R.id.btnAceptar);
        spnSexos = findViewById(R.id.spnSexos);
        foto_gallery = findViewById(R.id.foto_gallery);

        btnAceptar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);

        ArrayAdapter<String> adapterSexo = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, sexos);
        spnSexos.setAdapter(adapterSexo);

        foto_gallery.setOnClickListener(v -> openGallery());
    }

    private void registrarMascota(String nombre, String raza, String vcolor, String sexo) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(DarAdopcion_act.this, "Mascota agregada con éxito", Toast.LENGTH_LONG).show();
                        etNombre.setText("");
                        etRaza.setText("");
                        etColores.setText("");
                        foto_gallery.setImageURI(null); // Limpiar la imagen después de agregar
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DarAdopcion_act.this, "Error en agregar mascota: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("raza", raza);
                params.put("vcolor", vcolor);
                params.put("sexo", sexo);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnAceptar) {
            String nombre = etNombre.getText().toString().trim();
            String raza = etRaza.getText().toString().trim();
            String vcolor = etColores.getText().toString().trim();
            String sexo = spnSexos.getSelectedItem().toString().trim();
            if (!rUsuario.textVacios(3, nombre, vcolor, sexo)) {
                registrarMascota(nombre, raza, vcolor, sexo);
            } else {
                Toast.makeText(DarAdopcion_act.this, "Por favor, ingrese los datos completos", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.btnAtras) {
            Intent miIngreso = new Intent(this, Home_act.class);
            startActivity(miIngreso);
        }
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
        }
    }
}
