package com.example.mapainteractivo.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.mapainteractivo.ConnBD.BaseDatos;
import com.example.mapainteractivo.Modelos.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioController {
    private BaseDatos ayudanteBaseDeDatos;
    private String NOMBRE_TABLA = "usuarios";

    long result = -1;

    public  UsuarioController(Context contexto){
        ayudanteBaseDeDatos = new BaseDatos(contexto);

    }

    public long nuevoUsuario(Usuarios usuario) {
        // writable porque vamos a insertar
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("id",usuario.getId());
        valoresParaInsertar.put("nombre", usuario.getNombre());
        valoresParaInsertar.put("contrasenia", usuario.getContrasenia());
        valoresParaInsertar.put("usuario",usuario.getUsuario());
        valoresParaInsertar.put("tipousuario", usuario.getTipoUsuario());
        valoresParaInsertar.put("matricula",usuario.getMatricula());
        valoresParaInsertar.put("active", true);

        Map<String, Object> user = new HashMap<>();
        user.put("id", usuario.getId());
        user.put("nombre", usuario.getNombre());
        user.put("contrasenia", usuario.getContrasenia());
        user.put("usuario", usuario.getUsuario());
        user.put("tipousuario", usuario.getTipoUsuario());
        user.put("matricula", usuario.getMatricula());
        user.put("activate", true);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference users = db.collection("users");
        DocumentReference document = db.collection("users").document(usuario.getMatricula());
        document.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document1 = task.getResult();
                if (Objects.requireNonNull(document1).exists()) {
                    result = 0;
                } else {
                    users.document(usuario.getMatricula()).set(user);
                    result = baseDeDatos.insert(NOMBRE_TABLA, null, valoresParaInsertar);
                }
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int eliminarUsuario(String id) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        return baseDeDatos.delete(NOMBRE_TABLA, "id = '"+ id+"'", null);
    }

    public int guardarCambios(Usuarios usuario) {
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresParaInsertar = new ContentValues();
        valoresParaInsertar.put("nombre", usuario.getNombre());
        valoresParaInsertar.put("contrasenia", usuario.getContrasenia());
        valoresParaInsertar.put("usuario",usuario.getUsuario());
        valoresParaInsertar.put("tipousuario", usuario.getTipoUsuario());
        valoresParaInsertar.put("matricula",usuario.getMatricula());
        // where id...
        String campoParaActualizar = "id = ?";
        // ... = idMascota
        String[] argumentosParaActualizar = {String.valueOf(usuario.getId())};
        return baseDeDatos.update(NOMBRE_TABLA, valoresParaInsertar, campoParaActualizar, argumentosParaActualizar);
    }

    public ArrayList<Usuarios> obtenerUsuarios() {
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        // readable porque no vamos a modificar, solamente leer
        SQLiteDatabase baseDeDatos = ayudanteBaseDeDatos.getReadableDatabase();
        // SELECT nombre, edad, id
        String[] columnasAConsultar = {"id", "nombre", "contrasenia", "usuario", "tipousuario", "matricula"};
        Cursor cursor = baseDeDatos.query(
                NOMBRE_TABLA,//from mascotas
                columnasAConsultar,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            return usuarios;

        }
        if (!cursor.moveToFirst()) return usuarios;

        do {
            Usuarios usuario = new Usuarios();
            usuario.setId(cursor.getString(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setContrasenia(cursor.getString(2));
            usuario.setUsuario(cursor.getString(3));
            usuario.setTipoUsuario(cursor.getString(4));
            usuario.setMatricula(cursor.getString(5));
            usuarios.add(usuario);
        } while (cursor.moveToNext());

        cursor.close();
        return usuarios;
    }

}
