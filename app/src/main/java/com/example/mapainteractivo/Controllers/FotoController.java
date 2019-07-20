package com.example.mapainteractivo.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mapainteractivo.ConnBD.BaseDatos;
import com.example.mapainteractivo.Modelos.Fotos;

import java.util.ArrayList;

public class FotoController {
    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "fotos";

    public FotoController(Context contexto){
        ayudanteBaseDeDatos = new BaseDatos(contexto);

    }

    public long  nuevaFoto(Fotos foto) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("id",foto.getId());
        valoresParaInsertar.put("desc", foto.getDesc());
        valoresParaInsertar.put("idedificio", foto.getIdEdificio());
        valoresParaInsertar.put("desc",foto.getDesc());
        valoresParaInsertar.put("ruta", foto.getRuta());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int eliminarFoto(String id) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        return baseDeDatos.delete(NOMBRE_TABLA, "id = '"+ id+"'", null);
    }

    public int guardarCambios(Fotos foto) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("desc", foto.getDesc());
        valoresParaInsertar.put("idedificio", foto.getIdEdificio());
        valoresParaInsertar.put("ruta", foto.getRuta());
        // where id...
        String campoParaActualizar = "id = ?";
        String[] argumentosParaActualizar = {String.valueOf(foto.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaInsertar, campoParaActualizar, argumentosParaActualizar);
    }

    public ArrayList<Fotos> obtenerFotos(String idedificio) {
        ArrayList<Fotos> fotos = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "idedificio", "ruta", "desc"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,
                columnasAConsultar,
                "idedificio = '"+idedificio+"'",
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            return fotos;

        }
        if (!cursor.moveToFirst()) return fotos;

        do {

            Fotos foto = new Fotos();
            foto.setId(cursor.getString(0));
            foto.setIdEdificio(cursor.getString(1));
            foto.setRuta(cursor.getString(2));
            foto.setDesc(cursor.getString(3));
            fotos.add(foto);
        } while (cursor.moveToNext());

        cursor.close();
        return fotos;
    }
}
