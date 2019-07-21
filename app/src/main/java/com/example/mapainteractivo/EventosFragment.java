package com.example.mapainteractivo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.util.Objects;

public class EventosFragment extends Fragment {

    private Button nuevo;
    private Fragment fragment;

    public EventosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_eventos2, container, false);
        nuevo = view.findViewById(R.id.eventos_btnNuevo);
        RecyclerView eventos = view.findViewById(R.id.eventos_rvEventos);

        nuevo.setOnClickListener(v -> {
            if (fragment == null) {
                fragment = new AgregarEventoFragment();
            }

            FragmentTransaction transaction = Objects.requireNonNull(getFragmentManager()).beginTransaction();
            transaction.replace(R.id.contenedor, fragment);
            transaction.addToBackStack(null);
            // Commit a la transacción
            transaction.commit();
        });

        return view;
    }
}

