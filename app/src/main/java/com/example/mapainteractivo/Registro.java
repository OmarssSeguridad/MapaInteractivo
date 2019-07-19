package com.example.mapainteractivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        TextView regreso = findViewById(R.id.regresoLogin);
        regreso.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case  R.id.btn_registrar:
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
