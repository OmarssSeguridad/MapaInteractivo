package com.example.mapainteractivo.ConnBD;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DE_DATOS = "mapaescolar";

    private static final int VERSION_BASE_DE_DATOS = 1;

    public BaseDatos(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, nombre text, usuario text, contrasenia text, " +
                "tipousuario text, matricula text)", "usuarios"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, nombre text, desc text, latitud real, longitud real, " +
                "etiquetas text)", "edificios"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, idedificio integer, ruta text, desc text)", "fotos"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, idedificio integer, idevento integer)","deteventos"));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id text, nombre text, desc text, fechai text, fechaf text)","eventos"));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}


