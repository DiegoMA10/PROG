import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gestor {

    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    public Gestor() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reserva_vuelos", "root", "123");
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

    public void altaVuelo() throws SQLException {

        Statement st = con.createStatement();
        System.out.print("Introduce un origen: ");
        String origen = sc.nextLine();

        System.out.print("Introduce un destino: ");
        String destino = sc.nextLine();

        LocalDate fecha = nextFecha();

        System.out.print("Introduce una capacidad: ");
        int capacidad = 0;
        try {
            capacidad = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {

        }

        String consulta = "SELECT id_vuelo FROM Vuelos order by length(id_vuelo) ;";
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
        String sql = "INSERT INTO Vuelos (id_vuelo,origen, destino, fecha, capacidad) VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idVuelo);
        ps.setString(2, origen);  
        ps.setString(3, destino);        
        ps.setDate(4, Date.valueOf(fecha));
        ps.setInt(5, capacidad);

        ps.executeUpdate();
        ps.close();

    }
}
