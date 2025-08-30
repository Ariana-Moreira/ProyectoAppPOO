package com.example.appbanco;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VehiculosActivity extends AppCompatActivity {

    ListView lvVehiculos;
    Button btnAgregarVehiculo;
    ArrayList<String> listaVehiculos;
    ArrayAdapter<String> adapter;
    private final String ARCHIVO = "vehiculos.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculos);

        lvVehiculos = findViewById(R.id.lvVehiculos);
        btnAgregarVehiculo = findViewById(R.id.btnAgregarVehiculo);

        listaVehiculos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaVehiculos);
        lvVehiculos.setAdapter(adapter);

        // Cargar vehículos desde archivo
        cargarVehiculos();

        btnAgregarVehiculo.setOnClickListener(v -> {
            Intent intent = new Intent(VehiculosActivity.this, CrearVehiculoActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    private void cargarVehiculos() {
        try {
            FileInputStream fis = openFileInput(ARCHIVO);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String linea;
            while ((linea = reader.readLine()) != null) {
                listaVehiculos.add(linea);
            }
            reader.close();
            fis.close();
            adapter.notifyDataSetChanged();
        } catch (FileNotFoundException e) {
            // Archivo no existe aún, no pasa nada
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarVehiculo(String vehiculo) {
        try {
            FileOutputStream fos = openFileOutput(ARCHIVO, MODE_APPEND);
            fos.write((vehiculo + "\n").getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String vehiculo = data.getStringExtra("vehiculo");
            listaVehiculos.add(vehiculo);
            adapter.notifyDataSetChanged();
            guardarVehiculo(vehiculo);
        }
    }
}