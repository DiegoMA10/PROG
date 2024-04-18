package org.antonio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.antonio.Exception.HeroeNoEncontradoException;
import org.antonio.Model.GestorHeroes;
import org.antonio.Model.Heroe;
import org.junit.Before;
import org.junit.Test;

public class TestGestorHeroes {
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
    public void testAgregarHeroe(){
        Heroe hereo = new Heroe("heroe", "null", "null");
        gestorHeroes.agregarHeroe(hereo);
        assertEquals(4, gestorHeroes.getHeroes().size());
        assertSame(hereo, gestorHeroes.getHeroes().get(gestorHeroes.getHeroes().size()-1));
    }   

    @Test
    public void testBuscarHeroe() throws HeroeNoEncontradoException {
        assertNotNull(gestorHeroes.buscarHeroe("Iron Man"));
        assertEquals(ironMan, gestorHeroes.buscarHeroe("Iron Man"));

    }

    @Test(expected = HeroeNoEncontradoException.class)
    public void testHeroeNoEncontradoException() throws HeroeNoEncontradoException {
        gestorHeroes.buscarHeroe("Manolo");
    }
}
