import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class descifrado {

    public static boolean comprobarNumero(String extension) {

        Pattern p = Pattern.compile("\\.cf[1-9]");
        Matcher m = p.matcher(extension);
        return m.matches();

    }

    public static void main(String[] args) {
        if (args.length == 1) {

            String archivo = args[0];
            try {
               
                if (archivo.length() < 4 || !comprobarNumero(archivo.substring(archivo.length() - 4, archivo.length()))) {
                    throw new IllegalArgumentException("Archivo no termina en .cf[1-9]");
                }

                String archivoSalida = archivo.substring(0, archivo.length() - 4) + "_D.txt";
                
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida));
                Codificador codi = new Codificador(Integer.parseInt(archivo.charAt(archivo.length() - 1) + ""));
                int letra;

                while ((letra = br.read()) != -1) {

                    bw.write(codi.descodificar((char) letra));
                    bw.flush();

                }

                bw.close();
                br.close();

            } catch (FileNotFoundException e) {
                System.out.println("El archivo no existe");
            } catch (IOException e) {
                System.out.println("Error: Entrada/salida");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            System.out.println("Uso: java descifrado <nombre_archivo>");
        }
    }
}
