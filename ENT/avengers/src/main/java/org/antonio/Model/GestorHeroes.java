package org.antonio.Model;

import org.antonio.Exception.HeroeNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class GestorHeroes {
    private List<Heroe> heroes;

    public GestorHeroes() {
        this.heroes = new ArrayList<>();
    }

    public void agregarHeroe(Heroe heroe) {
        this.heroes.add(heroe);
    }

    public Heroe buscarHeroe(String nombre) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getNombre().equals(nombre)) {
                return heroe;
            }
        }
        throw new HeroeNoEncontradoException(nombre);
    }

    public List<Heroe> getHeroes() {
        return this.heroes;
    }

    public void eliminarHeroe(String nombre) throws HeroeNoEncontradoException {
        Heroe h = buscarHeroe(nombre);
        heroes.remove(h);
    }

    public Heroe buscarHeroePorSuperpoder(String superpoder) throws HeroeNoEncontradoException {
        for (Heroe heroe : this.heroes) {
            if (heroe.getSuperpoderes().contains(superpoder)) {
                return heroe;
            }
        }
        return null;
    }

    public void actualizarHeroe(Heroe heroeActualizado) throws HeroeNoEncontradoException {
        Heroe h = buscarHeroe(heroeActualizado.getNombre());
        heroes.remove(h);
        heroes.add(heroeActualizado);
    }

    public String listarHeroes() {
        List<String> lista = new ArrayList<>();
        for (Heroe heroe : heroes) {
            lista.add(heroe.getNombre());
        }
        String listaHeroes = String.join(",", lista);

        return listaHeroes;

    }

    public List<Heroe> buscarHeroesPorSuperpoder(String superpoder) throws HeroeNoEncontradoException {
        List<Heroe> listaHeroes = new ArrayList<>();
        for (Heroe heroe : this.heroes) {
            if (heroe.getSuperpoderes().contains(superpoder)) {
                listaHeroes.add(heroe);
            }
        }
        if (listaHeroes.isEmpty()) {
            return null;
        }
        return listaHeroes;
    }

}
