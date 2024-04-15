package ficheros.ejercicios2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ejer2 {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clearLine() {
        System.out.print("\033[1A");
        System.out.print("\033[2K");
    }

    public static void main(String[] args) {
        clearScreen();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String usuario;
        String pass;
        boolean salida = false;

        try {
            Verificador f = new Verificador("fichero.txt");

            do {
                salida = false;
                System.out.print("Usuario: ");
                usuario = br.readLine();
                if (!f.VeriUsuario(usuario)) {
                    salida = true;
                    clearScreen();
                    System.out.println(
                            "El Usuario contiene caracteres inválidos o no cumple con la longitud requerida (entre 2 y 16 caracteres).");

                }
            } while (salida);

            if (f.contieneUsuario(usuario)) {
                System.out.println("El usuario existe escriba su contraseña");
                System.out.print("Contraseña: ");
                pass = br.readLine();
                while (!f.VeriPass(pass)) {
                    clearLine();
                    System.out.println("<Contraseña invalida>");
                    System.out.print("Contraseña: ");
                    pass = br.readLine();
                    clearLine();
                }
                clearScreen();

                System.out.println("La contraseña del Usuario: \"" + usuario + "\""
                        + (f.confiPass(usuario, pass) ? " es correcta" : " es incorrecta"));

            } else {
                System.out.println("Usuario nuevo escriba una contraseña para el usuario");
                System.out.print("Contraseña: ");
                pass = br.readLine();
                while (!f.VeriPass(pass)) {
                    clearLine();
                    System.out.println("<Contraseña invalida>");
                    System.out.print("Contraseña: ");
                    pass = br.readLine();
                    clearLine();
                }
                clearScreen();
                System.out.println("Datos Introducios\nUsuario: " + usuario + "\nContraseña: " + pass);
                f.introDatos(usuario, pass);
            }
            br.close();
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }
}
