package org.antonio;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFruta {

    @Test
    public void testPuedoComerFrutaDeliciosa() {
        Fruta fruta = new Fruta("Manzana", true);

        assertTrue(fruta.puedoComer());
        assertEquals(true, fruta.puedoComer());
    }

    @Test
    public void testPuedoComerFrutaDelDiablo() {
        Fruta fruta = new Fruta("Fruta del Diablo", true);

        assertFalse(fruta.puedoComer());
        assertEquals(false, fruta.puedoComer());
    }

    @Test
    public void testPuedoComerFrutaNoDeliciosa() {
        Fruta fruta = new Fruta("Gomu Gomu", false);

        assertFalse(fruta.puedoComer());
        assertEquals(false, fruta.puedoComer());
    }
}
