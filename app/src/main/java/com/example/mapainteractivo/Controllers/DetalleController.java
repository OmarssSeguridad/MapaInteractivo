package com.example.mapainteractivo.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mapainteractivo.ConnBD.BaseDatos;
import com.example.mapainteractivo.Modelos.DetalleEventos;
import com.example.mapainteractivo.Modelos.Eventos;

import java.util.ArrayList;

public class DetalleController {
    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "deteventos";

    public DetalleController(Context contexto){
        ayudanteBaseDeDatos = new BaseDatos(contexto);
    }

    public long  nuevoDetalle(DetalleEventos detalle) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("id",detalle.getId());
        valoresParaInsertar.put("idedificio", detalle.getIdEdificio());
        valoresParaInsertar.put("idevento", detalle.getIdEvento());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int eliminarDetalle(String id) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        return baseDeDatos.delete(NOMBRE_TABLA, "idevento = '"+id+"'", null);
    }

    public int guardarCambios(DetalleEventos detalle) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("idedificio", detalle.getIdEdificio());
        valoresParaInsertar.put("idevento", detalle.getIdEvento());
        // where id...
        String campoParaActualizar = "id = ?";
        String[] argumentosParaActualizar = {String.valueOf(detalle.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaInsertar, campoParaActualizar, argumentosParaActualizar);
    }

    public ArrayList<DetalleEventos> obtenerEventos(String idevento) {
        ArrayList<DetalleEventos> detalles = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "idedificio", "idevento"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                "idevento = '"+idevento+"'",
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            return detalles;

        }
        if (!cursor.moveToFirst()) return detalles;

        do {

            DetalleEventos detalle = new DetalleEventos();
            detalle.setId(cursor.getString(0));
            detalle.setIdEdificio(cursor.getString(1));
            detalle.setIdEvento(cursor.getString(2));

            detalles.add(detalle);
        } while (cursor.moveToNext());

        cursor.close();
        return detalles;
    }

}
