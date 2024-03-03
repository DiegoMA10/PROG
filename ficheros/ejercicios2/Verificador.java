package ficheros.ejercicios2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificador {
    private File fichero;
    private HashMap <String,String> mapa;


    public Verificador(String fichero){

        this.fichero = new File(fichero);

        try (FileWriter in = new FileWriter(this.fichero , true)) {
                        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public boolean VeriUsuario(String usuario){
        String expresionRegular = "^[\\w_-]{2,16}$";
        Pattern p = Pattern.compile(expresionRegular);
        Matcher m = p.matcher(usuario);

        return m.matches();
    }

    public boolean VeriPass(String pass){
        String expresionRegular = "^[\\w!@#%&?*]+$";
        Pattern p = Pattern.compile(expresionRegular);
        Matcher m = p.matcher(pass);

        return m.matches();
    }
}
