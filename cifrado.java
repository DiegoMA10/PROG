import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class cifrado {

   public static void main(String[] args) {
      if (args.length == 2) {

         String archivo = args[0];
         int num = 0;

         try {
            num = Integer.parseInt(args[1]);
            if (num < 1 || num > 9) {
               throw new IllegalArgumentException("El desplazamiento debe estar entre 1 y 9.");
            }
         } catch (NumberFormatException e) {
            System.out.println("El desplazamiento tiene que ser un número entero");
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
         }

         if (archivo.length() < 4 || !archivo.substring(archivo.length() - 4).equals(".txt")) {
            archivo = archivo + ".txt";
         }

             String archivoSalida = archivo.substring(0, archivo.indexOf(".")) + ".cf" + num;
         
        
        
         try (BufferedReader br = new BufferedReader(new FileReader(archivo));
               BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            Codificador codi = new Codificador(num);
            int letra;
        
            while ((letra = br.read()) != -1) {

               bw.write(codi.codificar((char) letra));
               bw.flush();
               

            }
           

            bw.close();
            br.close();

         } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
         }catch (IOException e){
            System.out.println("Error: Entrada/salida");
         }catch (Exception e){
            System.out.println(e);
         }

      } else {
         System.out.println("Uso: java cifrado <nombre_archivo> <numero_desplazamiento>");
      }

   }
}
