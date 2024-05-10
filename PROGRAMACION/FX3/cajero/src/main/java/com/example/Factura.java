package com.example;

public class Factura {
    private int numFactura;
    private String nif;
    private int numHabitacion;
    private double importe;

    public Factura(int numFactura, String nif, int numHabitacion, double importe) {
        this.numFactura = numFactura;
        this.nif = nif;
        this.numHabitacion = numHabitacion;
        this.importe = importe;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public String getNif() {
        return nif;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public double getImporte() {
        return importe;
    }
    
    
}
