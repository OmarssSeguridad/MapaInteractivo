package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapainteractivo.Modelos.Usuarios;
import com.example.mapainteractivo.firebase.FirebaseFirestore;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DatabaseReference myRef;
    Usuarios user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRef = new FirebaseFirestore().getInstance();

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
                EditText contrasena = findViewById(R.id.pass);

                String valorCorreo = correo.getText().toString();
                String valorContrasena = contrasena.getText().toString();

                if ((valorCorreo.equals("omar.blanco@8w.com.mx") || valorCorreo.equals("lourdesvega21@hotmail.com") || valorCorreo.equals("djdaan86@gmail.com ")) && valorContrasena.equals("123456")) {
//                    intent = new Intent(view.getContext(), MenuActivity.class);
//                    startActivity(intent);
                    user = new Usuarios();
                    user.setUsuario(valorCorreo);
                    user.setContrasenia(valorContrasena);

                    myRef.setValue(user);

//                    Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Registro agregado en Firebase.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Usuario y/o Contraseña incorrecto", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nuevoUsuario:
                Toast.makeText(this,"Nuevo Usuario", Toast.LENGTH_SHORT).show();
                intent = new Intent(view.getContext(), Registro.class);
                startActivity(intent);
                break;
            case R.id.salir:
                Toast.makeText(this, "Adios", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

        // Read from the database
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }
}
