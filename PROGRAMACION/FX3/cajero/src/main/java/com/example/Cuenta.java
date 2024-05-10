package com.example;

public class Cuenta {
    private String numCuenta;
    private String nif;
    private double saldo;


    
    public Cuenta(String numCuenta, String nif, double saldo) {
        this.numCuenta = numCuenta;
        this.nif = nif;
        this.saldo = saldo;
    }
    
    public String getNumCuenta() {
        return numCuenta;
    }
    public String getNif() {
        return nif;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
         this.saldo = saldo;
    }
    

    
}
