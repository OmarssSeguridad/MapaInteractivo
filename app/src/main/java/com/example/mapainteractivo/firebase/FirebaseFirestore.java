package com.example.mapainteractivo.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseFirestore {

    // Write a message to the database
    FirebaseDatabase database;
    DatabaseReference myRef;

    public FirebaseFirestore() {
    }

    public DatabaseReference getInstance() {
        if (myRef == null) {
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("");
        }
        return myRef;
    }

}
