package ficheros.ejercicios2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejer1 {

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        String linea;
        String fichero;

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("Introduce un nombre para el fichero");
                fichero = br.readLine();
                limpiarPantalla();
            } while (fichero.equals(""));

            if (fichero.length()<4 || !fichero.substring(fichero.length() - 4).equals(".txt")) {
                fichero += ".txt";
            }
            

            FileWriter in = new FileWriter(fichero);
            System.out.println("Escribe en el fichero: (fin para acabar)");
            linea = br.readLine();

            while (!linea.equals("fin")) {
                in.write(linea + "\n");
                in.flush();
                linea = br.readLine();

            }
            br.close();
            in.close();

        } catch (

        FileNotFoundException e1) {
            System.err.println("Error: No se encuentra el fichero");
        } catch (IOException e2) {
            System.err.println("Error: leyendo/escribiendo fichero");
        }

    }
}
