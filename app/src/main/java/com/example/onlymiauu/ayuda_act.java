package com.example.onlymiauu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ayuda_act extends AppCompatActivity {

    private Spinner spayuda;
    private TextView txtayuda;
    String[] asunto = {"Seleccionar opción","Usuario Invalido","Problemas al Adoptar","Datos Erroneos","Otro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ayuda);
        //Inicializar el Spinner y el text View
        spayuda = findViewById(R.id.spna);
        txtayuda = findViewById(R.id.tva);

        //Crear un ArrayAdapter usando el array de ayuda y un layout predeterminado
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, asunto);

        //Aplicar el Adaptadot al Spinner
        spayuda.setAdapter(adapter);

        //Configurar lista pra spinner
        spayuda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedasunto = parent.getItemAtPosition(position).toString();

                if (position == 0) {
                    txtayuda.setText("Querido Usuario Seleccione un motivo predeterminado para poder ayudarlo");
                    return;
                }

                //Usando Swith para manejar la seleccion
                switch (selectedasunto) {
                    case "Usuario Invalido":
                        txtayuda.setText("Estimado Area de TI,\n" +
                                "\n" +
                                "Espero que este mensaje le encuentre bien. Me dirijo a usted para solicitar asistencia con un problema que he encontrado al intentar acceder a mi cuenta.\n" +
                                "\n" +
                                "Descripción del Problema: Al intentar iniciar sesión, recibo un mensaje que indica que mi usuario es inválido. He verificado mis credenciales y estoy seguro de que estoy utilizando el nombre de usuario correcto.\n" +
                                "\n" +
                                "Información Adicional:\n" +
                                "\n" +
                                "Nombre de usuario: [Tu Nombre de Usuario]\n" +
                                "Correo asociado: [Tu Correo Electrónico]\n" +
                                "Fecha y hora del intento de inicio de sesión: [Fecha y Hora]\n" +
                                "Agradecería su ayuda para resolver este inconveniente lo antes posible, ya que necesito acceder a mi cuenta con urgencia.\n" +
                                "\n" +
                                "Gracias por su atención y apoyo.\n" +
                                "\n" +
                                "Atentamente,\n" +
                                "\n" +
                                "[Tu Nombre]\n" +
                                "[Tu Número de Teléfono, si es necesario]\n" +
                                "[Tu Cargo, si aplica]");
                        break;

                    case "Problemas al Adoptar":
                        txtayuda.setText("Estimado Area de TI,\n" +
                                "\n" +
                                "Espero que este mensaje le encuentre bien. Me comunico con usted para solicitar ayuda con un problema que he encontrado al intentar adoptar a un [especificar el tipo de mascota, si aplica].\n" +
                                "\n" +
                                "Descripción del Problema: He intentado completar el proceso de adopción, pero he encontrado dificultades en [detallar el paso específico donde se presenta el problema, como \"el formulario de inscripción\", \"la verificación de datos\", etc.].\n" +
                                "\n" +
                                "Información Adicional:\n" +
                                "\n" +
                                "Nombre de usuario: [Tu Nombre de Usuario]\n" +
                                "Correo asociado: [Tu Correo Electrónico]\n" +
                                "Fecha y hora del intento de adopción: [Fecha y Hora]\n" +
                                "Detalles específicos del error (si los hay): [Describir cualquier mensaje de error o comportamiento inesperado]\n" +
                                "Agradecería su orientación para resolver este inconveniente, ya que estoy muy interesado/a en completar el proceso de adopción.\n" +
                                "\n" +
                                "Gracias por su atención y apoyo.\n" +
                                "\n" +
                                "Atentamente,\n" +
                                "\n" +
                                "[Tu Nombre]\n" +
                                "[Tu Número de Teléfono, si es necesario]\n" +
                                "[Tu Cargo, si aplica]");
                        break;

                    case "Datos Erroneos":
                        txtayuda.setText("Estimado Area TI,\n" +
                                "\n" +
                                "Espero que se encuentre bien. Me pongo en contacto con usted para solicitar ayuda respecto a un problema que he encontrado relacionado con la información de mi cuenta.\n" +
                                "\n" +
                                "Descripción del Problema: Al intentar [especificar la acción, como \"actualizar mis datos\", \"realizar un pedido\", etc.], me he dado cuenta de que algunos de los datos asociados a mi cuenta son incorrectos. Esto me ha impedido avanzar en el proceso.\n" +
                                "\n" +
                                "Información Adicional:\n" +
                                "\n" +
                                "Nombre de usuario: [Tu Nombre de Usuario]\n" +
                                "Correo asociado: [Tu Correo Electrónico]\n" +
                                "Datos incorrectos: [Especificar qué datos son erróneos, como \"mi dirección\", \"número de teléfono\", etc.]\n" +
                                "Fecha y hora de la última actualización: [Fecha y Hora]\n" +
                                "Agradecería mucho su ayuda para corregir esta información y poder continuar utilizando su servicio sin inconvenientes.\n" +
                                "\n" +
                                "Gracias por su atención y apoyo.\n" +
                                "\n" +
                                "Atentamente,\n" +
                                "\n" +
                                "[Tu Nombre]\n" +
                                "[Tu Número de Teléfono, si es necesario]\n" +
                                "[Tu Cargo, si aplica]");
                        break;
                    case "Otro":
                        txtayuda.setText("Estimado Area TI,\n" +
                                "\n" +
                                "[Completar con el requerimiento necesario]"+
                                "Gracias por su atención y apoyo.\n" +
                                "\n" +
                                "Atentamente,\n" +
                                "\n" +
                                "[Tu Nombre]\n" +
                                "[Tu Número de Teléfono, si es necesario]\n" +
                                "[Tu Cargo, si aplica]");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                txtayuda.setText("Querido Usuario Seleccione un motivo predeterminado para poder ayudarlo"); // Puedes agregar un mensaje por defecto
            }

        });
    }
}