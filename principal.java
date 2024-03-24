import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class principal {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    
    }

    public static void main(String[] args) {
        Gestor db = new Gestor();
        Scanner sc = new Scanner(System.in);
        boolean salida = true;
        try {
            do {

            System.out.println("1. Alta Vuelo\n2. Alta Pasajero\n3. Reserva Vuelo\n4. Modificar reserva\n5. Baja reserva\n6. Salir");
            System.out.print("---> ");
            String num = sc.nextLine();
            switch (num) {
                case "1": db.altaVuelo();clearScreen();  break;
                case "2":clearScreen();break;
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

}
