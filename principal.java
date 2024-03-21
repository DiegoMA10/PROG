import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class principal {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        clearScreen();
  
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        try {
            do {

            System.out.println("1. Alta Vuelo\n2. Alta Pasajero\n3. Reserva Vuelo\n4. Modificar reserva\n5. Baja reserva\n6. Salir");
            System.out.print("---> ");
            String num = sc.nextLine();
            switch (num) {
                case "1": altaVuelo(); clearScreen();break;
                case "2": clearScreen(); break;
                case "3":clearScreen();break;
                case "4":clearScreen();break;
                case "5":clearScreen();break;
                case "6":clearScreen(); salida = false;break;
            
                default: clearScreen();break;
            }
          
        } while (salida);
        } catch (Exception e) {
           System.out.println(e);
        }
        

    }

    public static void altaVuelo() throws SQLException {
  
        try {
            Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/reserva_vuelos", "root","dbrootpass");
            Statement st = con.createStatement();
            System.out.print("Introduce un origen: ");
            String origen = sc.nextLine();

            System.out.print("Introduce un destino: ");
            String destino = sc.nextLine();

            System.out.print("Introduce una fecha: ");
            String fecha = sc.nextLine();

            System.out.print("Introduce una capacidad: ");
            int capacidad = sc.nextInt();

            String sql = "INSERT INTO Vuelos (origen, destino, fecha, capacidad) VALUES ('"+origen+"', '"+destino+"', '"+fecha+"', "+capacidad+")";

            st.executeUpdate(sql);
            
        } catch (SQLException e) {
           
           throw new SQLException();
        }

    }
}
