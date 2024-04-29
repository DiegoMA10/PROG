package com.example;

public class Zona {
    private String nombre;
    private String ubicacion;
    private int numAtraccion;
    
     public Zona(String nombre, String ubicacion, int numAtraccion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.numAtraccion = numAtraccion;
    }
    
    public String getNombre() {
        return nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public int getNumAtraccion() {
        return numAtraccion;
    }
   
    
}
