import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class descifrado {

    public static boolean comprobarNumero(String extension){

        Pattern p = Pattern.compile("\\b[cf(?=cf*1-9)]{3}\\b");
        Matcher m = p.matcher(extension);
        return m.matches();

    }
    public static void main(String[] args) {
        if (args.length == 1) {

         String archivo = args[0];
           try {
            System.out.println(archivo.substring(archivo.length()-3,archivo.length()));
            if (archivo.length()<5 || comprobarNumero(archivo.substring(archivo.length()-3,archivo.length()))) {
                System.out.println("hola");
            }



            
           } catch (Exception e) {
            // TODO: handle exception
           }
         
      } else {
         System.out.println("Uso: java descifrado <nombre_archivo>");
      }
    }
}
