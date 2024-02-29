package ficheros.ejercicios2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejer1 {
    public static void main(String[] args) {

String nose ;  
String fichero;  
        try {

            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Intoduce un nombre para el fichero");
            

            FileWriter in = new FileWriter("hola.txt");
          
           nose =br.readLine();
        
            while (!nose.equals("FIN")) {
               
                nose = br.readLine();
                
            }
            in.close();
           
        } catch (FileNotFoundException e1) {
            System.err.println("Error: No se encuentra el fichero");
        } catch (IOException e2) {
            System.err.println("Error leyendo/escribiendo fichero");
        }

    }
}
