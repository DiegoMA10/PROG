import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
         System.out.println((int)'ñ');
         try (BufferedReader br = new BufferedReader(new FileReader(archivo));
               BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
                  int letra;
                  char letraCifrada=0;

                  while ((letra = br.read()) != -1) {

                     if (Character.isLetter(letra)) {

                        if (Character.isUpperCase(letra)) {
                            letraCifrada = (char)((65+((letra+num-65)%26)));
                        }

                        if (Character.isLowerCase(letra)) {
                          letraCifrada = (char)(97+(letra+num-97)%26);
                        }
                        
                        
                        bw.write(letraCifrada);
                        bw.flush();
                     }else{
                        bw.write(letra);
                        bw.flush();
                     }
                  }
                  bw.close();
                  br.close();

         } catch (Exception e) {
            // TODO: handle exception
         }
      } else {
         System.out.println("Uso: java cifrado <nombre_archivo> <numero_desplazamiento>");
      }

   }
}
