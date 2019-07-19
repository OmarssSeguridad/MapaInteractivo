package com.example.mapainteractivo.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapainteractivo.Modelos.Edificios;
import com.example.mapainteractivo.R;

import java.util.List;

public class AdapterEdificios extends RecyclerView.Adapter<AdapterEdificios.MyViewHolder>{
    private List<Edificios> listaDeEdificios;

    public void setListaDeMascotas(List<Edificios> listaDeEdificios) {
        this.listaDeEdificios = listaDeEdificios;
    }

    public AdapterEdificios(List<Edificios> edificios)
    {
        this.listaDeEdificios = edificios;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View filaEdificio = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_edificio, viewGroup, false);
        return new MyViewHolder(filaEdificio);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        // Obtener la mascota de nuestra lista gracias al índice i
        Edificios edificio = listaDeEdificios.get(i);

        // Obtener los datos de la lista
       // String nombreEdificio = mascota.getNombre();
       // int edadMascota = mascota.getEdad();
        // Y poner a los TextView los datos con setText
        myViewHolder.nombre.setText(edificio.getNombre());
        myViewHolder.descrip.setText(edificio.getDesc());
    }

    @Override
    public int getItemCount() {
        return listaDeEdificios.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, descrip;

        MyViewHolder(View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.tvNombre);
            this.descrip = itemView.findViewById(R.id.tvDescrip);
        }
    }
}
