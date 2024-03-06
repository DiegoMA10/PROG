import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cifrado {
   public static boolean comprobarNumero(String extension) {

      Pattern p = Pattern.compile("\\.cf[1-9]");
      Matcher m = p.matcher(extension);
      return m.matches();

   }

   public static void main(String[] args) {
      if (args.length == 2) {

         String archivo = args[0];
         int num = 0;

         try {
            num = Integer.parseInt(args[1]); 
          

            if (archivo.length() > 4 && comprobarNumero(archivo.substring(archivo.length() - 4, archivo.length()))) {
               throw new IllegalArgumentException("Un archivo crifrado no se puede cifrar.");
            }

            if (num < 1 || num > 9) {
               throw new IllegalArgumentException("El desplazamiento debe estar entre 1 y 9.");
            }

            if (archivo.length() < 4 || !archivo.substring(archivo.length() - 4).equals(".txt")) {
               archivo = archivo + ".txt";
            }

            String archivoSalida = archivo.substring(0, archivo.indexOf(".")) + ".cf" + num;

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));
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
         } catch (IOException e) {
            System.out.println("Error: Entrada/salida");
         } catch (NumberFormatException e) {
            System.out.println("El desplazamiento tiene que ser un número entero");
         } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
         } catch (Exception e) {
            System.out.println(e);
         }

      } else {
         System.out.println("Uso: java cifrado <nombre_archivo> <numero_desplazamiento>");
      }

   }

}
