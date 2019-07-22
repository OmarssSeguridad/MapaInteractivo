package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapainteractivo.Modelos.Usuarios;
import com.example.mapainteractivo.firebase.FirebaseFirestore;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    Intent intent;

    EditText name;
    EditText username;
    EditText password;
    EditText enrollment;

    Button registrar;
    TextView regreso;
    Usuarios usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        name = findViewById(R.id.registro_name);
        username = findViewById(R.id.registro_user);
        password = findViewById(R.id.registro_password);
        enrollment = findViewById(R.id.registro_matricula);

        regreso = findViewById(R.id.regresoLogin);
        registrar = findViewById(R.id.btn_registrar);
        regreso.setOnClickListener(this);
        registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.btn_registrar:
                String nombre = name.getText().toString();
                String user = username.getText().toString();
                String contrasenia = password.getText().toString();
                String matricula = enrollment.getText().toString();

                usuario = new Usuarios();
                usuario.setNombre(nombre);
                usuario.setUsuario(user);
                usuario.setContrasenia(contrasenia);
                usuario.setTipoUsuario("0");
                usuario.setMatricula(matricula);

                Toast.makeText(this, "MenuActivity Principal", Toast.LENGTH_SHORT).show();
                intent = new Intent((view.getContext()), Menu.class);
                startActivity(intent);
            case R.id.regresoLogin:
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
                intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
