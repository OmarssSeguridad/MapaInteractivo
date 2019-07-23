package com.example.mapainteractivo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GenerateId {

    private String id;

    public String getId() {
        //Hora del sistema
        Date now = new Date();
        id = new SimpleDateFormat("HHmmssSSS", Locale.ENGLISH).format(now);
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
