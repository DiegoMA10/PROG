package org.antonio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;

public class TestHeroes {
    Heroe ironMan = null;
    Heroe spiderMan=null;
    Heroe capitanAmerica=null;
    GestorHeroes gestorHeroes =null;


    @Before
    public void setUp(){
        ironMan = new Heroe("Iron Man", "Traje de alta tecnología", "Millonario y filántropo");
        spiderMan = new Heroe("Spider-Man", "Sentido arácnido, trepador", "Tímido estudiante de secundaria");
        capitanAmerica = new Heroe("Capitán América", "Superfuerza, agilidad, resistencia", "Soldado de la Segunda Guerra Mundial");
        gestorHeroes = new GestorHeroes();
        gestorHeroes.agregarHeroe(ironMan);
        gestorHeroes.agregarHeroe(spiderMan);
        gestorHeroes.agregarHeroe(capitanAmerica);

    }

    @Test
    public void testGetters(){
      assertEquals("Iron Man", ironMan.getNombre());
      assertNotEquals("Manolo", spiderMan.getNombre());
      assertTrue(capitanAmerica.getSuperpoderes().contains("Superfuerza"));
      assertFalse(ironMan.getSuperpoderes().contains("Superfuerza"));
      assertSame("Tímido estudiante de secundaria",spiderMan.getBiografia());
      assertNotEquals("Soldado de la Tercera Guerra Mundial", capitanAmerica.getBiografia());

    }

 
    @Test
    public void testSetters(){
        Heroe hVacio = new Heroe();
        hVacio.setNombre("manolo");
        hVacio.setSuperpoderes("Pesado, corredor, trepador");
        hVacio.setBiografia("Vida predeterminada de cualquier manolo");
        assertEquals("manolo", hVacio.getNombre());
        assertEquals("Pesado, corredor, trepador", hVacio.getSuperpoderes());
        assertEquals("Vida predeterminada de cualquier manolo", hVacio.getBiografia());

        
    }

    
    
}


