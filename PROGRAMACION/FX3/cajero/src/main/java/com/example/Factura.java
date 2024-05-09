package com.example;

public class Factura {
    private String numFactura;
    private String nif;
    private String numHabitacion;
    private double importe;

    public Factura(String numFactura, String nif, String numHabitacion, double importe) {
        this.numFactura = numFactura;
        this.nif = nif;
        this.numHabitacion = numHabitacion;
        this.importe = importe;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public String getNif() {
        return nif;
    }

    public String getNumHabitacion() {
        return numHabitacion;
    }

    public double getImporte() {
        return importe;
    }
    
    
}
