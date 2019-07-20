package com.example.mapainteractivo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;


public class AgregarEventoFragment extends Fragment {

    private Button btnAgregarEvento, btnCancelarEvento;
    private TextInputLayout nombreEvento, descEvento;
    private EditText fecIni, fecFin;
    public AgregarEventoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_agregar_evento, container, false);

        return view;
    }


}
