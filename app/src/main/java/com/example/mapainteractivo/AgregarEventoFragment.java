package com.example.mapainteractivo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mapainteractivo.Controllers.EventoController;
import com.example.mapainteractivo.Modelos.Eventos;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;


public class AgregarEventoFragment extends Fragment {

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

        acept.setOnClickListener(view1 -> {
            String nombre = name.getText().toString();
            String descripcion = description.getText().toString();
            String inicio = start.getText().toString();
            String fin = end.getText().toString();

            evento = new Eventos();
            evento.setId(String.valueOf(new Random().nextInt(max-min+1)+min));
            evento.setNombre(nombre);
            evento.setDesc(descripcion);
            evento.setFechaI(inicio);
            evento.setFechaF(fin);

            controller.nuevoEvento(evento);
        });

        return view;
    }


}
