package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnIng = findViewById(R.id.ingresar);
        btnIng.setOnClickListener(this);
        Button btnClo = findViewById(R.id.salir);
        btnClo.setOnClickListener(this);
        TextView nuevoUsuario = findViewById(R.id.nuevoUsuario);
        nuevoUsuario.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.ingresar:
                EditText correo = findViewById(R.id.usuario);
                EditText contraseña = findViewById(R.id.pass);

                String valorCorreo = correo.getText().toString();
                String valorContraseña = contraseña.getText().toString();
                String usuario,pass;


                if ((valorCorreo.equals("omar.blanco@8w.com.mx") || valorCorreo.equals("lourdesvega21@hotmail.com") || valorCorreo.equals("djdaan86@gmail.com ")) && valorContraseña.equals("123456")) {
                    //intent = new Intent(view.getContext(), MenuActivity.class);
                    usuario= correo.getText().toString();
                    pass= contraseña.getText().toString();

                    startActivity(intent);
                    Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Usuario y/o Contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nuevoUsuario:
                intent = new Intent(view.getContext(), Registro.class);
                startActivity(intent);
                Toast.makeText(this,"Nuevo Usuario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.salir:
                Toast.makeText(this, "Adios", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

    }
}
