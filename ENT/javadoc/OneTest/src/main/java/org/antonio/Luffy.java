package org.antonio;

/**
 * Clase de Luffy
 * @version 1.0
 */
public class Luffy implements Personaje{
    private String nombre;
    private int poder;

    /**
     * Constructor de la clase Luffy
     * @param nombre el nombre de Luffy
     * @param poder el poder de Luffy
     */
    public Luffy(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    /**
     * Obtiene el nombre del personaje
     * @return el nombre del personaje
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el poder del personaje
     * @return el poder del personaje
     */
    @Override
    public int getPoder() {
        return poder;
    }

    /**
     * Metodo para atacar a otro personaje
     * @see #recibirDanio(int)
     * @param enemigo el personaje que recibe daño
     */
    public void atacar(Personaje enemigo) {
        enemigo.recibirDanio(poder);
    }

    /**
     * Reduce el poder del personaje que recibe el danio
     * @param danio cantidad hecha al personaje
     */
    @Override
    public void recibirDanio(int danio) {
        this.poder-=danio;
    }
}