package org.antonio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

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
        barco = new Barco("Barco", 10);
    }

    @Test
    public void TestLuffyGetNombre(){
        assertNotNull(luffy.getNombre());
        assertEquals("Luffy", luffy.getNombre());
        assertNotEquals("Manolo", luffy.getNombre());
        assertSame("Luffy", luffy.getNombre());
    }

    @Test 
    public void TestluffySetNombre(){
        luffy.setNombre("Monkey D. Luffy");
        assertNotNull(luffy.getNombre());
        assertEquals("Monkey D. Luffy", luffy.getNombre());
        assertNotEquals("Luffy", luffy.getNombre());
        assertSame("Monkey D. Luffy", luffy.getNombre());
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
}
