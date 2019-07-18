package com.example.mapainteractivo;

import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class id {
    private String id;

    public String getId() {
        //Hora del sistema
        Date now = new Date(); // java.util.Date, NOT java.sql.Date or java.sql.Timestamp!
        id = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss.SSS", Locale.ENGLISH).format(now);
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
