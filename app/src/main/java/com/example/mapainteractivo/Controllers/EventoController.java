package com.example.mapainteractivo.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mapainteractivo.ConnBD.BaseDatos;
import com.example.mapainteractivo.Modelos.Eventos;
import com.example.mapainteractivo.Modelos.Fotos;

import java.util.ArrayList;

public class EventoController {

    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "eventos";

    public EventoController(Context contexto){
        ayudanteBaseDeDatos = new BaseDatos(contexto);
    }

    public long  nuevoEvento(Eventos evento) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("id",evento.getId());
        valoresParaInsertar.put("nombre", evento.getNombre());
        valoresParaInsertar.put("desc", evento.getDesc());
        valoresParaInsertar.put("fechai",evento.getFechaI());
        valoresParaInsertar.put("fechaf", evento.getFechaF());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int eliminarEvento(String id) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        baseDeDatos.delete("deteventos","idevento = '"+id+"'",null);
        return baseDeDatos.delete(NOMBRE_TABLA, "id = '"+ id+"'", null);
    }

    public int guardarCambios(Eventos evento) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("nombre", evento.getNombre());
        valoresParaInsertar.put("desc", evento.getDesc());
        valoresParaInsertar.put("fechai",evento.getFechaI());
        valoresParaInsertar.put("fechaf", evento.getFechaF());
        // where id...
        String campoParaActualizar = "id = ?";
        String[] argumentosParaActualizar = {String.valueOf(evento.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaInsertar, campoParaActualizar, argumentosParaActualizar);
    }

    public ArrayList<Eventos> obtenerEventos() {
        ArrayList<Eventos> eventos = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "nombre", "desc", "fechai","fechaf"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            return eventos;

        }
        if (!cursor.moveToFirst()) return eventos;

        do {

            Eventos evento = new Eventos();
            evento.setId(cursor.getString(0));
            evento.setNombre(cursor.getString(1));
            evento.setDesc(cursor.getString(2));
            evento.setFechaI(cursor.getString(3));
            evento.setFechaF(cursor.getString(4));
            eventos.add(evento);
        } while (cursor.moveToNext());

        cursor.close();
        return eventos;
    }
}