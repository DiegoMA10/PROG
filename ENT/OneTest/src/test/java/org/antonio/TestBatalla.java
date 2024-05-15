package org.antonio;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TestBatalla {

    Luffy luffy = null;
    Zoro zoro = null;

    @Before
    public void setUp() {
        luffy = new Luffy("Monkey D. Luffy", 100);
        zoro = new Zoro("Roronoa Zoro", 80);
    }

    @Test
    public void testAtaqueLuffy(){
        luffy.atacar(zoro);
        assertNotNull(zoro.getPoder());
        assertEquals(-20, zoro.getPoder());
        assertNotEquals(80, zoro.getPoder());
        assertTrue(zoro.getPoder()==-20);

    }

    @Test
    public void testAtaqueZoro(){
        zoro.atacar(luffy);
        assertNotNull(luffy.getPoder());
        assertEquals(20, luffy.getPoder());
        assertNotEquals(80, luffy.getPoder());
        assertTrue(luffy.getPoder()==20);

    }
}
