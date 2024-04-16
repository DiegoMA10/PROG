import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class Gestor {

    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    public Gestor() {
        try {
           //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/reserva_vuelos", "root", "dbrootpass");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reserva_vuelos", "root", "123");
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    private LocalDate nextFecha() {
        boolean salida = false;
        LocalDate data = null;

        do {
            salida = false;
            try {
                System.out.print("Introduce una fecha(AAAA-MM-DD): ");
                String fecha = sc.nextLine();
                data = LocalDate.parse(fecha);

            } catch (Exception e) {
                salida = true;
                System.out.print("\033[1A");
                System.out.print("\033[K");
            }

        } while (salida);

        return data;

    }

    public void altaVuelo() {

        Statement st;
        try {
            st = con.createStatement();

            System.out.print("Introduce un origen: ");
            String origen = sc.nextLine();

            System.out.print("Introduce un destino: ");
            String destino = sc.nextLine();

            LocalDate fecha = nextFecha();

         
            String capacidadstring = "";
            int capacidad = 0;
            do {   
                System.out.print("Introduce una capacidad: ");
                try {
                    capacidadstring = sc.nextLine();
                    capacidad = Integer.parseInt(capacidadstring);
                } catch (Exception e) {
                    System.out.print("\033[1A");
                    System.out.print("\033[K");
                }
            } while (capacidad <= 0);

            String consulta = "SELECT id_vuelo FROM vuelos order by length(id_vuelo) ;";
            ResultSet resultado = st.executeQuery(consulta);
            String idVuelo = "IV1";
            Boolean salida = false;
            int cont = 1;
            while (resultado.next() && !salida) {
                String id = resultado.getString(1);

                salida = !id.equals(idVuelo);
                if (!salida) {
                    cont++;
                    idVuelo = "IV" + cont;
                }

            }
            String sql = "INSERT INTO vuelos (id_vuelo,origen, destino, fecha, capacidad) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idVuelo);
            ps.setString(2, origen);
            ps.setString(3, destino);
            ps.setDate(4, Date.valueOf(fecha));
            ps.setInt(5, capacidad);
            ps.executeUpdate();
            ps.close();
            System.out.println("Vuelo añadido correctamente.");
            sc.nextLine();
        } catch (SQLException e) {

            e.printStackTrace();
            sc.nextLine();
        }

    }

    public void altaPasajero() {

        try {
            Statement st = con.createStatement();
       
        System.out.print("Introduce el numero de pasaporte: ");
        String pasaporte = sc.nextLine();

        System.out.print("Introduce el nombre de el pasajero: ");
        String nombre = sc.nextLine();

        String sql = "INSERT INTO pasajeros (numero_pasaporte,nombre_pasajero) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, pasaporte);
        ps.setString(2, nombre);
        ps.executeUpdate();
        ps.close();
        System.out.println("Pasajero añadido correctamente.");
        sc.nextLine();
    } catch (SQLException e) {
       System.out.println("El Pasajero ya existe");
       sc.nextLine();
    } 

    }

    
    public void reservaVuelos(){
        HashMap <String,Vuelo> vuelos = new HashMap<>();

        String sql = "SELECT * FROM vuelos " ;
        try {
      
        Statement st = con.createStatement();
        ResultSet rt = st.executeQuery(sql);
     
        while (rt.next()) {
           
            vuelos.put(rt.getString(1), new Vuelo(rt.getString(1), rt.getString(2), rt.getString(3),  rt.getDate(4), rt.getInt(5)));
        } 
        
        for (Vuelo v : vuelos.values()) {
            System.out.println(v);
        }

        System.out.print("Elige un vuelo (IV*): ");
        String id = sc.nextLine();

        if (vuelos.containsKey(id.toUpperCase())) {
            System.out.println("Introduzca tu numero de pasaporte:");
            String pasaporte = sc.nextLine();
            String sql2 = "SELECT numero_pasaporte FROM pasajeros WHERE numero_pasaporte=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setString(1, pasaporte);
            ResultSet rt2 = st2.executeQuery(); 
            if (rt2.next()) {
                System.out.println("hola");
            }else{
                System.out.println("El pasaporte no existe");
            }

            sc.nextLine();
        }else{

            System.out.println("No existe el vuelo");
            sc.nextLine();
        }
       

    
       
        } catch (SQLException e) {
            System.out.println(e);
            sc.nextLine();
        }
    }
}
