package com.example.mapainteractivo.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mapainteractivo.Modelos.Eventos;
import com.example.mapainteractivo.R;

import java.util.List;

public class AdapterEventos extends RecyclerView.Adapter<AdapterEventos.MyViewHolder>{
    private List<Eventos> listaDeEventos;

    public void setListaDeMascotas(List<Eventos> listaDeEventos) {
        this.listaDeEventos = listaDeEventos;
    }

    public AdapterEventos(List<Eventos> eventos)
    {
        this.listaDeEventos = eventos;
    }

    @NonNull
    @Override
    public AdapterEventos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View filaEvento = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_edificio, viewGroup, false);
        return new AdapterEventos.MyViewHolder(filaEvento);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEventos.MyViewHolder myViewHolder, int i) {
        // Obtener la mascota de nuestra lista gracias al índice i
        Eventos edificio = listaDeEventos.get(i);

        // Obtener los datos de la lista
        // String nombreEdificio = mascota.getNombre();
        // int edadMascota = mascota.getEdad();
        // Y poner a los TextView los datos con setText
        myViewHolder.nombre.setText(edificio.getNombre());
        myViewHolder.descrip.setText(edificio.getDesc());
    }

    @Override
    public int getItemCount() {
        return listaDeEventos.size();
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

