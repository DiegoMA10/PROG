
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        this.reserva=new boolean[capacidad];
        cargarReserva();
    }
    public void cargarReserva(){
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reserva_vuelos", "root", "123")) {
            String sql = "SELECT n_asiento FROM vuelos_pasajeros WHERE id_vuelo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idVuelo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reserva[rs.getInt(1)-1]=true;
            }
        } catch (SQLException e) {
         
            e.printStackTrace();
        }
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
        if (reserva.length>n) {
            return reserva[n-1]=true;
        }else{
            return false;
        }
        
    }

    public List<Integer> asientosDisponibles() {
        List<Integer> asientosLibres = new ArrayList<>();
        for (int i = 0; i < reserva.length; i++) {
            if (!reserva[i]) {
                asientosLibres.add(i + 1); 
            }
        }
        return asientosLibres;
    }

   

    
   



}
