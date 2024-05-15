package org.antonio;
/**
 * Clase de Fruta
 * @version 1.0
 */
public class Fruta {
    private String nombre;
    private boolean esDeliciosa;
    /**
     * Constructor de la clase Fruta
     * @param nombre nombre de la fruta
     * @param esDeliciosa si la fruta es deliciosa o no
     */
    public Fruta(String nombre, boolean esDeliciosa) {
        this.nombre = nombre;
        this.esDeliciosa = esDeliciosa;
    }

    /**
     * Devuelve en nombre de la fruta
     * @return el nombre de la fruta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve si la fruta es deliciosa o no
     * @return true si es deliciosa, false si no es deliciosa
     */
    public boolean esDeliciosa() {
        return esDeliciosa;
    }

    /**
     * Devuelve si se puede comer la fruta o no
     * @return true si es deliciosa y su nombre no es Fruta del diablo, false todo lo contrario
     */
    public boolean puedoComer() {
        return esDeliciosa && !nombre.equals("Fruta del Diablo");
    }
}
