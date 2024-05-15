package org.antonio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBarco {
    Barco sunny = null;
    Barco merry = null;
    @Before
    public void setUp() {
        sunny = new Barco("Thousand Sunny", 5);
        merry = new Barco("Going Merry", 10);
    }



     @Test
    public void testAgregarTripulante() {
        assertTrue(sunny.agregarTripulante());
        assertNotNull(sunny.getCapacidad());
        assertNotEquals(5, sunny.getCapacidad());
        assertEquals(6, sunny.getCapacidad());
    }

    @Test 
    public void testAgregarTripulanteMaximo(){
        assertFalse(merry.agregarTripulante());
        assertNotNull(merry.getCapacidad());
        assertNotEquals(11, merry.getCapacidad());
        assertEquals(10, merry.getCapacidad());
    }
}
