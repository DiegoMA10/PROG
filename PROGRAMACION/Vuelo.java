import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;



public class Vuelo {
    private String idVuelo;
    private String origen;
    private String destino;
    private Date fecha;
    private int capacidad;
    private boolean[] reserva;

    
    public Vuelo(String idVuelo, String origen, String destino, Date fecha, int capacidad) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.capacidad = capacidad;
        reserva = new boolean[this.capacidad];
    }


    public String getIdVuelo() {
        return idVuelo;
    }


    public String getOrigen() {
        return origen;
    }


    public String getDestino() {
        return destino;
    }


    public Date getFecha() {
        return fecha;
    }


    public int getCapacidad() {
        return capacidad;
    }


    @Override
    public String toString() {
        return   "Vuelo: "+idVuelo + " Origen: " + origen + " Destino: " + destino + " Fecha: " + fecha;
    }

    public Boolean comprobarAsiento(int n){
        return reserva[n-1];
    }

   

    
   



}
