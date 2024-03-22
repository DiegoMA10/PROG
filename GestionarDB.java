import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionarDB {
    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    public GestionarDB() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/reserva_vuelos", "root", "dbrootpass");
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void altaVuelo() throws SQLException {

        Statement st = con.createStatement();
        System.out.print("Introduce un origen: ");
        String origen = sc.nextLine();

        System.out.print("Introduce un destino: ");
        String destino = sc.nextLine();

        System.out.print("Introduce una fecha: ");
        String fecha = sc.nextLine();

        System.out.print("Introduce una capacidad: ");
        int capacidad = sc.nextInt();

        String sql = "INSERT INTO Vuelos (origen, destino, fecha, capacidad) VALUES ('" + origen + "', '" + destino
                + "', '" + fecha + "', " + capacidad + ")";

        st.executeUpdate(sql);

        throw new SQLException();

    }
}
