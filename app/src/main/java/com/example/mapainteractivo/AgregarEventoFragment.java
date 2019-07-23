package com.example.mapainteractivo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapainteractivo.Controllers.EventoController;
import com.example.mapainteractivo.Controllers.UsuarioController;
import com.example.mapainteractivo.Modelos.Eventos;

import java.util.Objects;

public class AgregarEventoFragment extends Fragment {

    private String id;
    private Button acept, cancel;
    private EditText name, description;
    private EditText start, end;

    private EventoController controller;
    private Eventos evento;

    private View focusView = null;
    private EditText[] campos;

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

        campos = new EditText[4];
        campos[0] = name;
        campos[1] = description;
        campos[2] = start;
        campos[3] = end;

        Bundle arguments = getArguments();

        if (arguments != null) {
            id = arguments.getString("id", "");
            name.setText(arguments.getString("name", ""));
            description.setText(arguments.getString("description", ""));
            start.setText(arguments.getString("start", ""));
            end.setText(arguments.getString("end", ""));
            acept.setText("Guardar");
        } else {
            id = new GenerateId().getId();
        }

        FragmentTransaction transaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
        transaction.replace(R.id.contenedor, new EventosFragment());

        acept.setOnClickListener(view1 -> {
            if (isEmpty(campos)) {
                focusView.requestFocus();
            } else {
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
                long rl;
                int ri;
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
            }
        });

        return view;
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
