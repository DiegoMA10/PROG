package com.example;

public class Dinosaurio {
    private String nombre;
    private String tamanyo;
    private String alimentacion;
    private String tipo;

    public Dinosaurio(String nombre, String tamanyo, String alimentacion, String tipo) {
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.alimentacion = alimentacion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTamanyo() {
        return tamanyo;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public String getTipo() {
        return tipo;
    }

    

    
}
