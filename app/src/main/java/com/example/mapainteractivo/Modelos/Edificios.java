package com.example.mapainteractivo.Modelos;

public class Edificios {

    private int id;
    private String nombre;
    private String desc;
    private double latitud;
    private double longitud;
    private double etiquetas;

    public Edificios(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(double etiquetas) {
        this.etiquetas = etiquetas;
    }
}
