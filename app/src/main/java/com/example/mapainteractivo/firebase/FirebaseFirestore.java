package com.example.mapainteractivo.firebase;

import com.example.mapainteractivo.Modelos.Eventos;
import com.example.mapainteractivo.Modelos.Usuarios;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseFirestore {

    // Write a message to the database
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String childEvents = "events";

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

    public void insertUpdateEvent(Eventos evento) {
        getInstance().getReference().child(childEvents).child(evento.getId()).setValue(evento);
    }

    public void deleteEvent(String id) {
        getInstance().getReference().child(childEvents).child(id).removeValue();
    }

    public void insertNewUser(Usuarios usuario) {
        String tipoUsuario;
        if (usuario.getId().equals("1")) {
            tipoUsuario = "admin";
        } else {
            tipoUsuario = "student";
        }
        getInstance().getReference().child("users")
                .child(tipoUsuario)
                .child(usuario.getId())
                .setValue(usuario);
    }

}
