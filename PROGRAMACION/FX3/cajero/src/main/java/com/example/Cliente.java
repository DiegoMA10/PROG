package com.example;

public class Cliente {
    private String nif;
    private String clave;
    private String nombre;
    private String apellidos;
    private String movil;
    
    public Cliente(String nif, String clave, String nombre, String apellidos, String movil) {
        this.nif = nif;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.movil = movil;
    }

    public String getNif() {
        return nif;
    }

    public String getClave() {
        return clave;
    }
   
    public String getNombre() {
        return nombre;
    }
   
    public String getApellidos() {
        return apellidos;
    }
   
    public String getMovil() {
        return movil;
    }
  

  
}
