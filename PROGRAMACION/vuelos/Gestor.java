
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Gestor {

    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    public Gestor() {
        try {
            // con =
            // DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/reserva_vuelos",
            // "root", "dbrootpass");
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

    public void reservaVuelos() {
        HashMap<String, Vuelo> vuelos = new HashMap<>();
        int numeroAsiento = 0;
        boolean salidaAsiento = false;
        String sql = "SELECT * FROM vuelos ";
        try {

            Statement st = con.createStatement();
            ResultSet rt = st.executeQuery(sql);

            while (rt.next()) {

                vuelos.put(rt.getString(1),
                        new Vuelo(rt.getString(1), rt.getString(2), rt.getString(3), rt.getDate(4), rt.getInt(5)));
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
                    List<Integer> asientosDisponibles = vuelos.get(id.toUpperCase()).asientosDisponibles();
                    System.out.println("Asientos disponibles en el vuelo " + id + ": " + asientosDisponibles);
                    System.out.println("Elija un asiento");
                    do {
                        salidaAsiento = false;
                        try {
                            numeroAsiento = sc.nextInt();
                            sc.nextLine();
                            salidaAsiento = !vuelos.get(id.toUpperCase()).comprobarAsiento(numeroAsiento);
                        } catch (Exception e) {
                            salidaAsiento = true;
                            sc.nextLine();
                        }

                    } while (salidaAsiento);

                    String sql3 = "INSERT INTO vuelos_pasajeros (id_vuelo, pasaporte, n_asiento, id_reserva) VALUES (?, ?, ?, ?)";

                    PreparedStatement ps = con.prepareStatement(sql3);
                    ps.setString(1, id.toUpperCase());
                    ps.setString(2, pasaporte);
                    ps.setInt(3, numeroAsiento);
                    String idReserva = generarNuevaIdReserva(id, numeroAsiento);
                    ps.setString(4, idReserva);
                    ps.executeUpdate();
                    System.out.println("Id de reserva: " + idReserva);
                    System.out.println("ID de vuelo: " + id);
                    System.out.println("Número de pasaporte: " + pasaporte);
                    System.out.println("Asiento actual: " + numeroAsiento);
                    System.out.println("Reserva hecha de manera exitosa");
                    sc.nextLine();
                } else {

                    System.out.println("El pasaporte no existe");
                    sc.nextLine();
                }

            } else {

                System.out.println("No existe el vuelo");
                sc.nextLine();
            }

        } catch (SQLException e) {
            System.out.println(e);
            sc.nextLine();
        }

    }

    public void modificarReserva() {
        HashMap<String, Vuelo> vuelos = new HashMap<>();
        try {
            String sql = "SELECT * FROM vuelos ";

            Statement st = con.createStatement();
            ResultSet rt = st.executeQuery(sql);
            while (rt.next()) {

                vuelos.put(rt.getString(1),
                        new Vuelo(rt.getString(1), rt.getString(2), rt.getString(3), rt.getDate(4), rt.getInt(5)));
            }

            System.out.print("Introduce el ID de la reserva que deseas modificar: ");
            String idReserva = sc.nextLine();

            // Verificar si la reserva existe en la base de datos
            String sqlConsulta = "SELECT * FROM vuelos_pasajeros WHERE id_reserva = ?";
            PreparedStatement psConsulta = con.prepareStatement(sqlConsulta);
            psConsulta.setString(1, idReserva);
            ResultSet rsConsulta = psConsulta.executeQuery();

            if (rsConsulta.next()) {

                int nuevoAsiento;

                String idVuelo = rsConsulta.getString("id_vuelo");
                String pasaporte = rsConsulta.getString("pasaporte");
                int asientoActual = rsConsulta.getInt("n_asiento");

                System.out.println("Reserva encontrada:");
                System.out.println("ID de vuelo: " + idVuelo);
                System.out.println("Número de pasaporte: " + pasaporte);
                System.out.println("Asiento: " + asientoActual);
                System.out.println("Asiento disponibles: " + vuelos.get(idVuelo).asientosDisponibles());
                do {
                    System.out.print("Introduce el nuevo número de asiento: ");
                    nuevoAsiento = sc.nextInt();
                    sc.nextLine();
                } while (!vuelos.get(idVuelo).comprobarAsiento(nuevoAsiento));

                String sqlModificacion = "UPDATE vuelos_pasajeros SET n_asiento = ? WHERE id_reserva = ?";
                PreparedStatement psModificacion = con.prepareStatement(sqlModificacion);
                psModificacion.setInt(1, nuevoAsiento);
                psModificacion.setString(2, idReserva);
                int filasActualizadas = psModificacion.executeUpdate();

                if (filasActualizadas > 0) {
                    System.out.println("Reserva modificada exitosamente.");
                    System.out.println("Id de reserva: " + idReserva);
                    System.out.println("ID de vuelo: " + idVuelo);
                    System.out.println("Número de pasaporte: " + pasaporte);
                    System.out.println("Asiento: " + asientoActual);
                    sc.nextLine();
                } else {
                    System.out.println("Error al modificar la reserva.");
                    sc.nextLine();
                }
            } else {
                System.out.println("La reserva con el ID especificado no existe.");
                sc.nextLine();
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar la reserva: " + e.getMessage());
        }

    }

    public void bajaReserva() {
        try {
            System.out.print("Introduce el número de pasaporte del pasajero: ");
            String pasaporte = sc.nextLine();

            String sqlConsulta = "SELECT * FROM vuelos_pasajeros WHERE pasaporte = ?";
            PreparedStatement psConsulta = con.prepareStatement(sqlConsulta);
            psConsulta.setString(1, pasaporte);
            ResultSet rsConsulta = psConsulta.executeQuery();

            List<String> reservasPasajero = new ArrayList<>();

            if (rsConsulta.next()) {

                System.out.println("Reservas del pasajero con número de pasaporte " + pasaporte + ":");
                do {
                    String idReserva = rsConsulta.getString("id_reserva");
                    reservasPasajero.add(idReserva);
                    System.out.println(idReserva);
                } while (rsConsulta.next());

                System.out.print("Introduce el ID de la reserva que deseas eliminar: ");
                String idReservaEliminar = sc.nextLine();

                if (reservasPasajero.contains(idReservaEliminar)) {

                    String sqlBaja = "DELETE FROM vuelos_pasajeros WHERE id_reserva = ?";
                    PreparedStatement psBaja = con.prepareStatement(sqlBaja);
                    psBaja.setString(1, idReservaEliminar);
                    int filasEliminadas = psBaja.executeUpdate();

                    if (filasEliminadas > 0) {
                        System.out.println("Reserva eliminada exitosamente.");
                        sc.nextLine();
                    } else {
                        System.out.println("Error al eliminar la reserva.");
                        sc.nextLine();
                    }
                } else {
                    System.out.println("La reserva seleccionada no pertenece al pasajero.");
                    sc.nextLine();
                }
            } else {
                System.out.println("El pasajero con el número de pasaporte especificado no tiene reservas.");
                sc.nextLine();
            }
        } catch (SQLException e) {
            System.out.println("Error al procesar la baja de reserva: " + e.getMessage());
        }
    }

    private String generarNuevaIdReserva(String idVuelo, int nuevoAsiento) {

        return "R" + idVuelo.toUpperCase() + String.valueOf(System.nanoTime()).substring(0, 6);
    }
}