package org.antonio;

import static org.junit.Assert.*;

import java.util.List;

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
        spiderMan = new Heroe("Spider-Man", "Sentido arácnido, trepador, Superfuerza", "Tímido estudiante de secundaria");
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

    @Test
    public void testActualizaHeroeExistente() throws  HeroeNoEncontradoException{
      
        capitanAmerica.setDescripcion("Inserta una descripcion random");
        assertNotNull(gestorHeroes.buscarHeroe(capitanAmerica.getNombre()).getDescripcion());
        assertEquals("Inserta una descripcion random", gestorHeroes.buscarHeroe(capitanAmerica.getNombre()).getDescripcion());
       
    }

    @Test
    public void testEliminarHeroeExistente() throws HeroeNoEncontradoException{
        int cantidadLista = gestorHeroes.getHeroes().size();
        gestorHeroes.eliminarHeroe(ironMan.getNombre());
        assertTrue(gestorHeroes.getHeroes().size()<cantidadLista);
        assertNotEquals(4, gestorHeroes.getHeroes().size());
       
    }

    @Test(expected = HeroeNoEncontradoException.class)
    public void testBuscarHeroeEliminadoNoEncontrado() throws HeroeNoEncontradoException{
        gestorHeroes.eliminarHeroe(ironMan.getNombre());
        gestorHeroes.buscarHeroe(ironMan.getNombre());
    }

    @Test
    public void testAgregarVariosHeroes() throws HeroeNoEncontradoException{
        Heroe retornoSiderman = gestorHeroes.buscarHeroe(spiderMan.getNombre());
        Heroe retornoIronman = gestorHeroes.buscarHeroe(ironMan.getNombre());
        Heroe retornoCapitan = gestorHeroes.buscarHeroe(capitanAmerica.getNombre());

        assertEquals(spiderMan.getBiografia(), retornoSiderman.getBiografia());
        assertSame(retornoIronman, ironMan);
        assertEquals(capitanAmerica.getSuperpoderes(), retornoCapitan.getSuperpoderes());
    }

    @Test
    public void testBuscarHeroePorSuperpoder() throws HeroeNoEncontradoException{
        assertSame(capitanAmerica, gestorHeroes.buscarHeroePorSuperpoder("Superfuerza"));
        assertNull(gestorHeroes.buscarHeroePorSuperpoder("Manolo"));
        assertEquals(ironMan.getBiografia(), gestorHeroes.buscarHeroePorSuperpoder("Traje de alta tecnología").getBiografia());
        assertNotEquals("cualquierNombre", gestorHeroes.buscarHeroePorSuperpoder("trepador").getNombre());
    }

    @Test
    public void testActualizarHeroe() throws HeroeNoEncontradoException{
        Heroe goldman = new Heroe("Iron Man", "dinero", "mucho dinero");
        gestorHeroes.actualizarHeroe(goldman);
        assertNotNull(gestorHeroes.buscarHeroe(ironMan.getNombre()));
        assertEquals("mucho dinero", gestorHeroes.buscarHeroe(ironMan.getNombre()).getBiografia());      
        assertNotSame(ironMan, gestorHeroes.buscarHeroe(ironMan.getNombre()));

    }

    @Test
    public void testLista(){
        assertNotNull(gestorHeroes.listarHeroes());
        assertEquals("Iron Man,Spider-Man,Capitán América", gestorHeroes.listarHeroes());
    }

    @Test
    public void testBuscarHeroesPorSuperpoder() throws HeroeNoEncontradoException{
        GestorHeroes lista = new GestorHeroes(); 
        lista.agregarHeroe(spiderMan);
        lista.agregarHeroe(capitanAmerica);
        assertNull(gestorHeroes.buscarHeroesPorSuperpoder("camina"));
        assertNotNull(gestorHeroes.buscarHeroesPorSuperpoder("Superfuerza"));
        assertEquals(lista.getHeroes(), gestorHeroes.buscarHeroesPorSuperpoder("Superfuerza"));
    }
}
