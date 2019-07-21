package com.example.mapainteractivo;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mapainteractivo.Adaptadores.AdapterEdificios;
import com.example.mapainteractivo.Controllers.EdificioController;
import com.example.mapainteractivo.Modelos.Edificios;

import java.util.ArrayList;
import java.util.List;


public class EdificiosFragment extends Fragment {
    private List<Edificios> listaDeEdificios;
    private RecyclerView recyclerView;
    private AdapterEdificios adaptadorEdificios;
    private EdificioController edificiosController;
    // private FloatingActionButton fabAgregarMascota;


    public EdificiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edificios, container, false);
        edificiosController = new EdificioController(getContext());

        // Instanciar vistas
        recyclerView = view.findViewById(R.id.rvEdificios);
        // Boton flotante  fabAgregarMascota = findViewById(R.id.fabAgregarMascota);


        // Por defecto es una lista vacía,
        // se la ponemos al adaptador y configuramos el recyclerView
        listaDeEdificios = new ArrayList<>();
        adaptadorEdificios = new AdapterEdificios(listaDeEdificios);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorEdificios);

        // Una vez que ya configuramos el RecyclerView le ponemos los datos de la BD
        refrescarListaDeEdificios();

        // Listener de los clicks en la lista, o sea el RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override // Un toque sencillo
            public void onClick(View view, int position) {
                // Pasar a la actividad EditarMascotaActivity.java
                Edificios edificioSeleccionado = listaDeEdificios.get(position);
               Intent intent = new Intent(getContext(),MapsActivity.class);
                intent.putExtra("latitud", edificioSeleccionado.getLatitud());
                intent.putExtra("longitud", edificioSeleccionado.getLongitud());
                intent.putExtra("edificio",edificioSeleccionado.getNombre());
                intent.putExtra("id",edificioSeleccionado.getId());
                intent.putExtra("desc",edificioSeleccionado.getDesc());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        return view;
    }


   /* @Override
    protected void onResume() {
        super.onResume();
        refrescarListaDeEdificios();
    }*/

    public void refrescarListaDeEdificios() {
        if (adaptadorEdificios == null) return;
        listaDeEdificios = edificiosController.obtenerEdificios();
        adaptadorEdificios.setListaDeEdificios(listaDeEdificios);
        adaptadorEdificios.notifyDataSetChanged();
    }

}
