package com.example.mapainteractivo.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mapainteractivo.ConnBD.BaseDatos;
import com.example.mapainteractivo.Modelos.Edificios;
import com.example.mapainteractivo.Modelos.Usuarios;

import java.util.ArrayList;

public class EdificioController {
    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "edificios";

    public EdificioController(Context contexto){
        ayudanteBaseDeDatos = new BaseDatos(contexto);

    }

    public long  nuevoEdificio(Edificios edificio) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("id",edificio.getId());
        valoresParaInsertar.put("nombre", edificio.getNombre());
        valoresParaInsertar.put("desc", edificio.getDesc());
        valoresParaInsertar.put("latitud",edificio.getLatitud());
        valoresParaInsertar.put("longitud", edificio.getLongitud());
        valoresParaInsertar.put("etiquetas",edificio.getEtiquetas());
        return baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
    }

    public int eliminarEdificio(String id) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        return baseDeDatos.delete(NOMBRE_TABLA, "id = '"+ id+"'", null);
    }

    public int guardarCambios(Edificios edificio) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("nombre", edificio.getNombre());
        valoresParaInsertar.put("desc", edificio.getDesc());
        valoresParaInsertar.put("latitud",edificio.getLatitud());
        valoresParaInsertar.put("longitud", edificio.getLongitud());
        valoresParaInsertar.put("etiquetas",edificio.getEtiquetas());
        // where id...
        String campoParaActualizar = "id = ?";
        String[] argumentosParaActualizar = {String.valueOf(edificio.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaInsertar, campoParaActualizar, argumentosParaActualizar);
    }

    public ArrayList<Edificios> obtenerEdificios() {
        ArrayList<Edificios> edificios = new ArrayList<>();
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        String[] columnasAConsultar = {"id", "nombre", "desc", "latitud", "longitud", "etiquetas"};
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
            return edificios;

        }
        if (!cursor.moveToFirst()) return edificios;

        do{
            Edificios edificio = new Edificios();
            edificio.setId(cursor.getString(0));
            edificio.setNombre(cursor.getString(1));
            edificio.setDesc(cursor.getString(2));
            edificio.setLatitud(cursor.getDouble(3));
            edificio.setLongitud(cursor.getDouble(4));
            edificio.setEtiquetas(cursor.getString(5));
            edificios.add(edificio);
        } while (cursor.moveToNext());

        cursor.close();
        return edificios;
    }

}
