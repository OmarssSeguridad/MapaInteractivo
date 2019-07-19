package com.example.mapainteractivo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mapainteractivo.Adaptadores.AdapterEdificios;
import com.example.mapainteractivo.Controllers.EdificioController;
import com.example.mapainteractivo.Modelos.Edificios;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;


public class AgregarEventoFragment extends Fragment {

    private Button btnAgregarEvento, btnCancelarEvento;
    private TextInputLayout nombreEvento, descEvento;
    private EditText fecIni, fecFin;
    private List<Edificios> listaDeEdificios;
    private RecyclerView recyclerView;
    private AdapterEdificios adaptadorEdificios;
    private EdificioController edificiosController;

    public AgregarEventoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        edificiosController = new EdificioController(getContext());


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_agregar_evento, container, false);

        btnAgregarEvento= view.findViewById(R.id.btnAceptar);
        btnCancelarEvento= view.findViewById(R.id.btnCancelar);
        nombreEvento =view.findViewById(R.id.nombreEvento);
        descEvento = view.findViewById(R.id.descEvento);


        recyclerView = view.findViewById(R.id.agEdificio);
        // Boton flotante  fabAgregarMascota = findViewById(R.id.fabAgregarMascota);
        // Por defecto es una lista vacía,
        // se la ponemos al adaptador y configuramos el recyclerView
        listaDeEdificios = new ArrayList<>();
        adaptadorEdificios = new AdapterEdificios(listaDeEdificios);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorEdificios);
        listaDeEdificios = edificiosController.obtenerEdificios();
        adaptadorEdificios.setListaDeMascotas(listaDeEdificios);
        adaptadorEdificios.notifyDataSetChanged();


        return view;
    }


}
