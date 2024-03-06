import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class grepj {
    public static void main(String[] args) {

        if (args.length == 2) {
            File f = new File(args[0]);

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            String linea = "";
            int num = 1;
            linea = br.readLine();
            while (linea != null) {

                if (linea.contains(args[1])) {
                    linea = linea.replaceAll(args[1], "\u001B[32m" + args[1] + "\u001B[0m");
                    
                }
                System.out.println(num + ": " + linea);
                num++;
                linea = br.readLine();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        }else{
            System.out.println("Uso: java grepj <nombre_archivo> <palabra>");
        }

        
    }
}
