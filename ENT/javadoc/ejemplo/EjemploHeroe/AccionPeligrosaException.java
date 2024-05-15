package org.antonio;

/**
 * Excepción que se lanza cuando ocurre un error en una acción peligrosa.
 */
public class AccionPeligrosaException extends Exception {
    /**
     * Crea una nueva instancia de la excepción con un mensaje de error.
     *
     * @param mensaje el mensaje de error.
     */
    public AccionPeligrosaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Crea una nueva instancia de la excepción con un mensaje de error y una causa.
     *
     * @param mensaje el mensaje de error.
     * @param causa la causa de la excepción.
     */
    public AccionPeligrosaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

