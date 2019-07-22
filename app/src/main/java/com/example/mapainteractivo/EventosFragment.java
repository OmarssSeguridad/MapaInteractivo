package com.example.mapainteractivo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.example.mapainteractivo.Adaptadores.AdapterEventos;
import com.example.mapainteractivo.ConnBD.BaseDatos;
import com.example.mapainteractivo.Controllers.EventoController;
import com.example.mapainteractivo.Modelos.Eventos;
import com.example.mapainteractivo.firebase.FirebaseFirestore;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.Objects;

import java.util.ArrayList;
import java.util.List;

public class EventosFragment extends Fragment {

    private Button nuevo;
    private Fragment fragment;
    private List<Eventos> listaDeEventos;
    private RecyclerView recyclerView;
    private AdapterEventos adaptadorEventos;
    private EventoController eventosController;
    private FirebaseFirestore firestore = new FirebaseFirestore();
    private DatabaseReference myRef;

    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "eventos";

    public EventosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_eventos2, container, false);
        nuevo = view.findViewById(R.id.eventos_btnNuevo);
        recyclerView = view.findViewById(R.id.eventos_rvEventos);
        eventosController = new EventoController(getContext());

        ayudanteBaseDeDatos = new BaseDatos(getContext());
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();

        nuevo.setOnClickListener(v -> {
            fragment = new AgregarEventoFragment();

            FragmentTransaction transaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
            transaction.replace(R.id.contenedor, fragment).addToBackStack(null);
            transaction.commit();
        });

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

        myRef = firestore.getReference("events");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                listaDeEventos.clear();
                ContentValues valoresParaInsertar = new ContentValues();
                Eventos evento = dataSnapshot.getValue(Eventos.class);
                if (evento != null) {
                    valoresParaInsertar.put("id", evento.getId());
                    valoresParaInsertar.put("nombre", evento.getNombre());
                    valoresParaInsertar.put("desc", evento.getDesc());
                    valoresParaInsertar.put("fechai",evento.getFechaI());
                    valoresParaInsertar.put("fechaf", evento.getFechaF());
                    baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                listaDeEventos.clear();
                ContentValues valoresParaInsertar = new ContentValues();
                Eventos evento = dataSnapshot.getValue(Eventos.class);
                if (evento != null) {
                    valoresParaInsertar.put("id", evento.getId());
                    valoresParaInsertar.put("nombre", evento.getNombre());
                    valoresParaInsertar.put("desc", evento.getDesc());
                    valoresParaInsertar.put("fechai",evento.getFechaI());
                    valoresParaInsertar.put("fechaf", evento.getFechaF());
                    String[] argumentos = {String.valueOf(evento.getId())};
                    baseDeDatos.update(NOMBRE_TABLA, valoresParaInsertar, "id = ?", argumentos);
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Listener de los clicks en la lista, o sea el RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override // Un toque sencillo
            public void onClick(View view, int position) {
                fragment = new AgregarEventoFragment();

                Eventos eventoSeleccionado = listaDeEventos.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("id", eventoSeleccionado.getId());
                bundle.putString("name", eventoSeleccionado.getNombre());
                bundle.putString("description", eventoSeleccionado.getDesc());
                bundle.putString("start", eventoSeleccionado.getFechaI());
                bundle.putString("end", eventoSeleccionado.getFechaF());

                fragment.setArguments(bundle);
                Objects.requireNonNull(getFragmentManager()).beginTransaction().replace(R.id.contenedor, fragment).addToBackStack(null).commit();
            }

            @Override
            public void onLongClick(View view, int position) {
                Eventos eventoSeleccionado = listaDeEventos.get(position);

                AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext())
                        .setMessage("¿Seguro que desea eliminarlo?")
                        .setTitle("Eliminar evento")
                        .setPositiveButton("Aceptar", (dialogInterface, i) -> {
                            eventosController.eliminarEvento(eventoSeleccionado.getId());
                            Toast.makeText(view.getContext(), "Evento eliminado", Toast.LENGTH_SHORT).show();
                        });
                dialog.show();
            }
        }));

        return view;
    }

   /* @Override
    protected void onResume() {
        super.onResume();
        refrescarListaDeEdificios();
    }*/

    private void refrescarListaDeEventos() {
        if (adaptadorEventos == null) return;
        listaDeEventos = eventosController.obtenerEventos();
        adaptadorEventos.setListaDeEventos(listaDeEventos);
        adaptadorEventos.notifyDataSetChanged();
    }
}

