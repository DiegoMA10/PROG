package org.antonio;

/**
 * Clase que representa a un héroe.
 */
public class Heroe {
    private int id;
    private String nombre;
    private String superpoder;
    private String biografia;

    /**
     * Obtiene el ID del héroe.
     *
     * @return el ID del héroe.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del héroe.
     *
     * @param id el ID del héroe.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del héroe.
     *
     * @return el nombre del héroe.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del héroe.
     *
     * @param nombre el nombre del héroe.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el superpoder del héroe.
     *
     * @return el superpoder del héroe.
     */
    public String getSuperpoder() {
        return superpoder;
    }

    /**
     * Establece el superpoder del héroe.
     *
     * @param superpoder el superpoder del héroe.
     */
    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    /**
     * Obtiene la biografía del héroe.
     *
     * @return la biografía del héroe.
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * Establece la biografía del héroe.
     *
     * @param biografia la biografía del héroe.
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * Realiza una acción heroica.
     *
     * @param accion la acción heroica a realizar.
     */
    public void realizarAccionHeroica(String accion) {
        // Implementación de la acción heroica
    }

    /**
     * Recibe un golpe en una batalla.
     *
     * @param enemigo el enemigo que inflige el golpe.
     * @param fuerza la fuerza del golpe.
     * @return true si el héroe sobrevive al golpe, false si muere.
     */
    public boolean recibirGolpe(String enemigo, int fuerza) {
        // Implementación de la recepción de golpe
        return true;
    }

    /**
     * Aprende un nuevo superpoder.
     *
     * @param nuevoSuperpoder el nuevo superpoder a aprender.
     */
    public void aprenderNuevoSuperpoder(String nuevoSuperpoder) {
        // Implementación del aprendizaje del superpoder
    }

    /**
     * Realiza una acción peligrosa que puede lanzar una excepción personalizada.
     *
     * @throws AccionPeligrosaException si ocurre un error en la acción peligrosa.
     */
    public void realizarAccionPeligrosa() throws AccionPeligrosaException {
        // Implementación de la acción peligrosa
        if (true) {
            throw new AccionPeligrosaException("Error en la acción peligrosa");
        }
    }
}

