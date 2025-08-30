package com.example.appbanco;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class RutasActivity extends AppCompatActivity {
    ListView listViewRutas;
    ArrayList<String> listaRutas;
    Button btnNuevaRuta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        listViewRutas = findViewById(R.id.listViewRutas);
        btnNuevaRuta = findViewById(R.id.btnNuevaRuta);

        // 🔹 Simulación de rutas
        listaRutas = new ArrayList<>();
        listaRutas.add("Ruta 1 - 20/08/2025 - Conductor: Juan Pérez - Vehículo: ABC123 - Paquetes: 15");
        listaRutas.add("Ruta 2 - 21/08/2025 - Conductor: María López - Vehículo: XYZ789 - Paquetes: 10");
        listaRutas.add("Ruta 3 - 22/08/2025 - Conductor: Carlos Ruiz - Vehículo: DEF456 - Paquetes: 20");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaRutas
        );

        listViewRutas.setAdapter(adapter);

        // Evento botón Nueva Ruta
        btnNuevaRuta.setOnClickListener(v -> {
            Intent intent = new Intent(RutasActivity.this, CrearRutaActivity.class);
            startActivity(intent);
        });
    }

}