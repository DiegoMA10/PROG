package org.antonio;
/**
 * Interfaz de los personaje
 * @version 1.0
 */
public interface Personaje {
    /**
     * Obtiene el nombre del personaje
     * @return el nombre del personaje
     */
    String getNombre();

     /**
     * Obtiene el poder del personaje
     * @return el poder del personaje
     */
    int getPoder();

    /**
     * Recude el poder del personaje que recibe el danio
     * @param cantidadDanio cantidad hecha al personaje
     */
    void recibirDanio(int cantidadDanio);
}
