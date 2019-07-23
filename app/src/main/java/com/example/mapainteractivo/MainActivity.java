package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.mapainteractivo.Modelos.Usuarios;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;

import com.example.mapainteractivo.Controllers.UsuarioController;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;

    private ConnectivityManager con;
    private NetworkInfo network;

    private EditText user;
    private EditText pass;

    private View focusView = null;
    private EditText[] campos;
    private UsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button btnIng = findViewById(R.id.ingresar);
        btnIng.setOnClickListener(this);
        Button btnClo = findViewById(R.id.salir);
        btnClo.setOnClickListener(this);
        TextView nuevoUsuario = findViewById(R.id.nuevoUsuario);
        nuevoUsuario.setOnClickListener(this);

        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.pass);

        campos = new EditText[2];
        campos[0] = user;
        campos[1] = pass;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ingresar:

                if (isEmpty(campos)) {
                    focusView.requestFocus();
                } else {
                    String valorCorreo = user.getText().toString();
                    String valorContrasena = pass.getText().toString();

//                FirebaseFirestore db = FirebaseFirestore.getInstance();
//                DocumentReference document = db.collection("users").whereEqualTo().document(valorCorreo);
//                document.get().addOnCompleteListener();

                    if ((valorCorreo.equals("omar.blanco@8w.com.mx") || valorCorreo.equals("lourdesvega21@hotmail.com") || valorCorreo.equals("djdaan86@gmail.com ")) && valorContrasena.equals("123456")) {
                        intent = new Intent(view.getContext(), MenuActivity.class);
                        startActivity(intent);

                        Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Usuario y/o Contraseña incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.nuevoUsuario:
                if (verifyInternet(this)) {
                    intent = new Intent(view.getContext(), Registro.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Necesitas conexión internet", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.salir:
                Toast.makeText(this, "Adios", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    private boolean verifyInternet(Context context) {
        con = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        network = Objects.requireNonNull(con).getActiveNetworkInfo();
        return network != null && network.isConnected();
    }

    private boolean isEmpty(EditText[] campos) {
        boolean cancel = false;
        for (TextView campo : campos) {
            if (TextUtils.isEmpty(campo.getText().toString())) {
                campo.setError("Campo requerido");
                focusView = campo;
                cancel = true;
            }
        }
        return cancel;
    }
}
