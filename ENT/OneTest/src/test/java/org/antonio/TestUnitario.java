package org.antonio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestUnitario {
    
     Luffy luffy = null;
    Zoro zoro = null;
    Fruta fruta = null;
    Barco barco = null;

    @Before
    public void setUp() {
        luffy = new Luffy("Luffy", 100);
        zoro = new Zoro("Zoro", 80);
        fruta = new Fruta("Manzana", true);
        barco = new Barco("Merry", 10);
    }

    @Test
    public void TestLuffyGetNombre(){
        assertNotNull(luffy.getNombre());
        assertEquals("Luffy", luffy.getNombre());
        assertNotEquals("Manolo", luffy.getNombre());
        assertSame("Luffy", luffy.getNombre());
    }

    @Test 
    public void TestLuffySetNombre(){
        luffy.setNombre("Monkey D. Luffy");
        assertNotNull(luffy.getNombre());
        assertEquals("Monkey D. Luffy", luffy.getNombre());
        assertNotEquals("Luffy", luffy.getNombre());
        assertSame("Monkey D. Luffy", luffy.getNombre());
    }

    @Test
    public void TestLuffyGetPoder(){
        assertNotNull(luffy.getPoder());
        assertEquals(100, luffy.getPoder());
        assertNotEquals(25, luffy.getPoder());
    }

    @Test
    public void TestLuffySetPoder(){
        luffy.setPoder(50);
        assertNotNull(luffy.getPoder());
        assertEquals(50, luffy.getPoder());
        assertNotEquals(25, luffy.getPoder());
    }

    @Test
    public void TestZoroGetNombre(){
        assertNotNull(zoro.getNombre());
        assertEquals("Zoro", zoro.getNombre());
        assertNotEquals("Manolo", zoro.getNombre());
        assertSame("Zoro", zoro.getNombre());
    }

    @Test 
    public void TestZoroSetNombre(){
        zoro.setNombre("Roronoa Zoro");
        assertNotNull(zoro.getNombre());
        assertEquals("Roronoa Zoro", zoro.getNombre());
        assertNotEquals("Zoro", zoro.getNombre());
        assertSame("Roronoa Zoro", zoro.getNombre());
    }

    @Test
    public void TestZoroGetPoder(){
        assertNotNull(zoro.getPoder());
        assertEquals(80, zoro.getPoder());
        assertNotEquals(25, zoro.getPoder());
    }

    @Test
    public void TestZoroSetPoder(){
        zoro.setPoder(60);
        assertNotNull(zoro.getPoder());
        assertEquals(60, zoro.getPoder());
        assertNotEquals(25, zoro.getPoder());
    }

    @Test
    public void testBarcoGetNombre(){
        assertNotNull(barco.getNombre());
        assertEquals("Merry", barco.getNombre());
        assertNotEquals("Suny", barco.getNombre());
        assertSame("Merry", barco.getNombre());

    }
    
    @Test 
    public void testBarcoSetNombre(){
        barco.setNombre("Suny");
        assertNotNull(barco.getNombre());
        assertEquals("Suny", barco.getNombre());
        assertNotEquals("Merry", barco.getNombre());
        assertSame("Suny", barco.getNombre());
    }

    @Test 
    public void testBarcoGetCapacidad(){
        assertNotNull(barco.getCapacidad());
        assertEquals(10, barco.getCapacidad());
        assertNotEquals(20, barco.getCapacidad());
        assertTrue(barco.getCapacidad()<=10);
    }

    public void testBarcoSetCapacidad(){
        barco.setCapacidad(5);
        assertNotNull(barco.getCapacidad());
        assertEquals(5, barco.getCapacidad());
        assertNotEquals(20, barco.getCapacidad());
        assertTrue(barco.getCapacidad()<=10);
    }


    @Test
    public void testFrutaGetNombre(){
        assertNotNull(fruta.getNombre());
        assertEquals("Manzana", fruta.getNombre());
        assertNotEquals("Gomu Gomu", fruta.getNombre());
        assertSame("Manzana", fruta.getNombre());

    }

    @Test 
    public void testFrutaSetNombre(){
        fruta.setNombre("Gomu Gomu");
        assertNotNull(fruta.getNombre());
        assertEquals("Gomu Gomu", fruta.getNombre());
        assertNotEquals("Manzana", fruta.getNombre());
        assertSame("Gomu Gomu", fruta.getNombre());
    }


    
    @Test
    public void testFrutaGetEsDelicisa(){
        assertNotNull(fruta.esDeliciosa());
        assertTrue(fruta.esDeliciosa());
        assertEquals(true, fruta.esDeliciosa());
        assertNotEquals(false, fruta.esDeliciosa());
    }

    @Test
    public void testFrutaSetEsDelicisa(){
        fruta.setEsDeliciosa(false);
        assertNotNull(fruta.esDeliciosa());
        assertFalse(fruta.esDeliciosa());
        assertEquals(false, fruta.esDeliciosa());
        assertNotEquals(true, fruta.esDeliciosa());
    }

}
