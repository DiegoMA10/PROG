package org.antonio;
/**
 * Clase de Barco
 * @version 1.0
 */
public class Barco {
    private String nombre;
    private int capacidad;
    /**
     * Constructor de la clase Barco
     * @param nombre el nombre de el barco
     * @param capacidad la capacidad de el barco
     */
    public Barco(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    /**
     * Devuelve el nombre de el barco
     * @return el nombre de el barco
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la capacidad de el barco
     * @return la capacidad de el barco
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Agrega un tripulante al barco 
     * @return true si la capacidad menor a 10, false si la capacidad mayor a 10
     *  
     */
    public boolean agregarTripulante() {
        if (capacidad < 10) {
            capacidad++;
            return true;
        }
        return false;
    }
}
