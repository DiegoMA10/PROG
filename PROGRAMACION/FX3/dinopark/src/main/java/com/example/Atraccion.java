package com.example;

public class Atraccion {
    private String nombre;
    private Dinosaurio dinosaurio;
    private int capacidad;
    private int edad;
    private Zona zona;

    public Atraccion(String nombre, Dinosaurio dinosaurio, int capacidad, int edad, Zona zona) {
        this.nombre = nombre;
        this.dinosaurio = dinosaurio;
        this.capacidad = capacidad;
        this.edad = edad;
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dinosaurio getDinosaurio() {
        return dinosaurio;
    }

    public void asignarDino(Dinosaurio dinosaurio) {
        this.dinosaurio = dinosaurio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Zona getZona() {
        return zona;
    }

    public void asignarZona(Zona zona) {
        this.zona = zona;
    }

    

    
}
