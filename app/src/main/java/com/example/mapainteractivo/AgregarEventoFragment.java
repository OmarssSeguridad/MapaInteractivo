package com.example.mapainteractivo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mapainteractivo.Controllers.EventoController;
import com.example.mapainteractivo.Modelos.Eventos;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.Random;


public class AgregarEventoFragment extends Fragment {

    private String id;
    private Button acept, cancel;
    private EditText name, description;
    private EditText start, end;

    private EventoController controller;
    private Eventos evento;
    private int min = 1, max = 100;

    public AgregarEventoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_evento, container, false);

        controller = new EventoController(view.getContext());

        name = view.findViewById(R.id.eventos_nombre);
        description = view.findViewById(R.id.eventos_descripcion);
        start = view.findViewById(R.id.eventos_fechaInicio);
        end = view.findViewById(R.id.eventos_fechaFin);
        acept = view.findViewById(R.id.eventos_aceptar);
        cancel = view.findViewById(R.id.eventos_cancelar);

        Bundle arguments = getArguments();

        if (arguments != null) {
            id = arguments.getString("id", "");
            name.setText(arguments.getString("name", ""));
            description.setText(arguments.getString("description", ""));
            start.setText(arguments.getString("start", ""));
            end.setText(arguments.getString("end", ""));
            acept.setText("Guardar");
        } else {
            id = String.valueOf(new Random().nextInt(max-min+1)+min);
        }

        FragmentTransaction transaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
        transaction.replace(R.id.contenedor, new EventosFragment());

        acept.setOnClickListener(view1 -> {
            String nombre = name.getText().toString();
            String descripcion = description.getText().toString();
            String inicio = start.getText().toString();
            String fin = end.getText().toString();

            evento = new Eventos();
            evento.setId(id);
            evento.setNombre(nombre);
            evento.setDesc(descripcion);
            evento.setFechaI(inicio);
            evento.setFechaF(fin);

            String boton = acept.getText().toString().toLowerCase();
            long rl; int ri;
            if (boton.equals("aceptar")) {
                rl = controller.nuevoEvento(evento);
                if (rl == -1) {
                    Toast.makeText(view1.getContext(), "Ocurrío un error", Toast.LENGTH_SHORT).show();
                } else {
                    Objects.requireNonNull(getFragmentManager()).beginTransaction().replace(R.id.contenedor, new EventosFragment()).commit();
                }
            } else if (boton.equals("guardar")) {
                ri = controller.guardarCambios(evento);
                if (ri != 1) {
                    Toast.makeText(view1.getContext(), "Ocurrío un error", Toast.LENGTH_SHORT).show();
                } else {
                    Objects.requireNonNull(getFragmentManager()).beginTransaction().replace(R.id.contenedor, new EventosFragment()).commit();
                }
            }
        });

        return view;
    }
}
