package com.example;

import java.util.Map;

public class Cancion {
    private String nombre;
    private String autor;
    private double duracion;

    public Cancion(Map<String, Object> metadata, double duracion) {

        for (String key : metadata.keySet()) {

            if (key.equals("artist")) {
                this.autor = metadata.get("artist").toString();
            }

            if (key.equals("title")) {
                this.nombre = metadata.get("title").toString();
            }

        }
        this.duracion = duracion;
    }



    public double getDuracion() {
        return duracion;
    }
}
