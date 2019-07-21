package com.example.mapainteractivo.firebase;

import com.example.mapainteractivo.Modelos.Eventos;
import com.example.mapainteractivo.Modelos.Usuarios;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseFirestore {

    // Write a message to the database
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    public FirebaseFirestore() {
    }

    public FirebaseDatabase getInstance() {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
        }
        return database;
    }

    public DatabaseReference getReference(String path)
    {
        myRef = getInstance().getReference(path);
        return myRef;
    }

    public DatabaseReference getReferencesUrl(String url) {
        myRef = getInstance().getReferenceFromUrl(url);
        return myRef;
    }

    public void insertNewEvent(Eventos evento) {
        getInstance().getReference().child("events").child(evento.getId()).setValue(evento);
    }

    public void insertNewUser(Usuarios usuario) {
        DatabaseReference myRef;
        if (usuario.getId().equals("0")) {
            myRef = database.getReference("users/student/" + usuario.getId());
        } else if (usuario.getId().equals("1")){
            myRef = database.getReference("users/admin/" + usuario.getId());
        } else {
            myRef = database.getReference("users/" + usuario.getId());
            myRef.setValue(usuario.getTipoUsuario());
        }
        myRef.setValue(usuario.getNombre());
        myRef.setValue(usuario.getMatricula());
        myRef.setValue(usuario.getContrasenia());
        myRef.setValue(usuario.getMatricula());
    }

}
