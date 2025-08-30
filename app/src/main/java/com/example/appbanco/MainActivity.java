package com.example.appbanco;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRutas, btnVehiculos, btnConductores, btnContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los botones
        btnRutas = findViewById(R.id.btnRutas);
        btnVehiculos = findViewById(R.id.btnVehiculos);
        btnConductores = findViewById(R.id.btnConductores);
        btnContacto = findViewById(R.id.btnContacto);

        // Eventos de los botones (por ahora solo ejemplo)
        btnRutas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RutasActivity.class);
            startActivity(intent);
        });

        btnVehiculos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VehiculosActivity.class);
            startActivity(intent);
        });
        btnConductores.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConductoresActivity.class);
            startActivity(intent);
        });

        btnContacto.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
            startActivity(intent);
        });
    }
}