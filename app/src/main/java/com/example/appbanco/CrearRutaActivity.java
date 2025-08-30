package com.example.appbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearRutaActivity extends AppCompatActivity {

    EditText txtFecha, txtConductor, txtVehiculo, txtPaquetes;
    Button btnGuardarRuta;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ruta);

        // txtFecha = findViewById(R.id.txtFecha);//
        /*txtConductor = findViewById(R.id.txtConductor);
        txtVehiculo = findViewById(R.id.txtVehiculo);
        txtPaquetes = findViewById(R.id.txtPaquetes);
        btnGuardarRuta = findViewById(R.id.btnGuardarRuta);*/
        btnGuardarRuta.setOnClickListener(v -> {
            String fecha = txtFecha.getText().toString();
            String conductor = txtConductor.getText().toString();
            String vehiculo = txtVehiculo.getText().toString();
            String paquetes = txtPaquetes.getText().toString();

            if(fecha.isEmpty() || conductor.isEmpty() || vehiculo.isEmpty() || paquetes.isEmpty()){
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ruta creada:\n" + fecha + " - " + conductor + " - " + vehiculo + " - Paquetes: " + paquetes,
                        Toast.LENGTH_LONG).show();
                finish(); // Vuelve a la lista de rutas
            }
        });
    }
}
