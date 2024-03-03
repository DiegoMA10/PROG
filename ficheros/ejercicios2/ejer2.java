package ficheros.ejercicios2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejer2 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Verificador f = new Verificador("fichero.txt");
       
            String usuario;
            String pass;
            try {
                System.out.println("usuario:");
                usuario = br.readLine();  
                System.out.println(f.VeriUsuario(usuario));
                System.out.println("contraseña:");
                pass = br.readLine();
                System.out.println(f.VeriPass(pass));
        
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          
           
        
       
    }
}
