package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapainteractivo.Controllers.UsuarioController;
import com.example.mapainteractivo.Modelos.Usuarios;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    EditText username;
    EditText password;
    EditText enrollment;

    Button registrar;
    TextView regreso;
    Usuarios usuario;

    private View focusView = null;
    private EditText[] campos;
    private UsuarioController controller;

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
        controller = new UsuarioController(this);

        campos = new EditText[4];
        campos[0] = name;
        campos[1] = username;
        campos[2] = password;
        campos[3] = enrollment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.btn_registrar:
                if (isEmpty(campos)) {
                    focusView.requestFocus();
                } else {
                    String nombre = name.getText().toString();
                    String user = username.getText().toString();
                    String contrasenia = password.getText().toString();
                    String matricula = enrollment.getText().toString();

                    usuario = new Usuarios();
                    usuario.setId(new GenerateId().getId());
                    usuario.setNombre(nombre);
                    usuario.setUsuario(user);
                    usuario.setContrasenia(contrasenia);
                    usuario.setTipoUsuario("0");
                    usuario.setMatricula(matricula);

                    long rl = controller.nuevoUsuario(usuario);
                    if (rl == -1) {
                        Toast.makeText(this, "Ocurríó un error, inténtelo de nuevo", Toast.LENGTH_SHORT).show();
                    } else if (rl == 0) {
                        Toast.makeText(this, "Posible duplicación de matrícula, inténtelo de nuevo", Toast.LENGTH_LONG).show();
                    } else if (rl == 1) {
                        finish();
                        startActivity(new Intent(Registro.this, MenuActivity.class));
                    }
                }
                break;
            case R.id.regresoLogin:
                finish();
                break;
        }
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
