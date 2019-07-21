package com.example.mapainteractivo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mapainteractivo.Adaptadores.AdapterEventos;
import com.example.mapainteractivo.Controllers.EventoController;
import com.example.mapainteractivo.Modelos.Eventos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EventosFragment extends Fragment {

    FloatingActionButton floatingActionButton;
    private List<Eventos> listaDeEventos;
    private RecyclerView recyclerView;
    private AdapterEventos adaptadorEventos;
    private EventoController eventosController;

    public EventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_eventos2, container, false);
        floatingActionButton = view.findViewById(R.id.btnAgregarEvento);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarEventoFragment nuevoFragmento = new AgregarEventoFragment();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor, nuevoFragmento);
                transaction.addToBackStack(null);
                // Commit a la transacción
                transaction.commit();

            }
        });
        eventosController = new EventoController(getContext());

        // Instanciar vistas
        recyclerView = view.findViewById(R.id.rvEventos);
        // Boton flotante  fabAgregarMascota = findViewById(R.id.fabAgregarMascota);


        // Por defecto es una lista vacía,
        // se la ponemos al adaptador y configuramos el recyclerView
        listaDeEventos = new ArrayList<>();
        adaptadorEventos = new AdapterEventos(listaDeEventos);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adaptadorEventos);

        // Una vez que ya configuramos el RecyclerView le ponemos los datos de la BD
        refrescarListaDeEventos();

        // Listener de los clicks en la lista, o sea el RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override // Un toque sencillo
            public void onClick(View view, int position) {
                // Pasar a la actividad EditarMascotaActivity.java
                /*Eventos eventoSeleccionado = listaDeEventos.get(position);
                Intent intent = new Intent(getContext(),MapsActivity.class);
                intent.putExtra("latitud", edificioSeleccionado.getLatitud());
                intent.putExtra("longitud", edificioSeleccionado.getLongitud());
                intent.putExtra("edificio",edificioSeleccionado.getNombre());
                intent.putExtra("id",edificioSeleccionado.getId());
                intent.putExtra("desc",edificioSeleccionado.getDesc());
                startActivity(intent);*/
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

    public void refrescarListaDeEventos() {
        if (adaptadorEventos == null) return;
        listaDeEventos= eventosController.obtenerEventos();
        adaptadorEventos.setListaDeEventos(listaDeEventos);
        adaptadorEventos.notifyDataSetChanged();
    }

}
