package com.example.appbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    EditText etNombre, etEmail, etMensaje;
    Button btnEnviar;
    WebView wvMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etMensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);
        wvMapa = findViewById(R.id.wvMapa);

        // Configurar WebView para mostrar Google Maps
        WebSettings webSettings = wvMapa.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String mapaHtml = "<iframe " +
                "src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3976.7974501048895!2d-78.49219728472243!3d-0.1806538367539753!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91d59c67d62e705b%3A0x7a3f0d5bfa4f7b7c!2sQuito%2C%20Ecuador!5e0!3m2!1ses!2sus!4v1693333333333!5m2!1ses!2sus\" " +
                "width=\"100%\" height=\"100%\" style=\"border:0;\"allowfullscreen=\"\" loading=\"lazy\"></iframe>";

        wvMapa.loadData(mapaHtml, "text/html", "utf-8");

        // Botón enviar
        btnEnviar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String mensaje = etMensaje.getText().toString().trim();

            if(nombre.isEmpty() || email.isEmpty() || mensaje.isEmpty()){
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Mensaje enviado. Gracias, " + nombre, Toast.LENGTH_LONG).show();
                etNombre.setText("");
                etEmail.setText("");
                etMensaje.setText("");
            }
        });
    }
}
