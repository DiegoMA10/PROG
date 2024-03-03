

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificador {
    private File fichero;
    private FileWriter write;
    private FileReader reader;
    private HashMap<String, String> mapa = new HashMap<>();

    public Verificador(String fichero) throws IOException {

        try {
            this.fichero = new File(fichero);
            this.write = new FileWriter(fichero, true);
            this.reader = new FileReader(fichero);
            asignarMapa();
        } catch (IOException e) {

            throw new IOException("Error: entrada/salida");

        }

    }

    public boolean contieneUsuario(String u) {

        return mapa.containsKey(u);
    }

    public boolean confiPass(String u, String p) {
        return this.mapa.get(u).equals(p);
    }

    private void asignarMapa() throws IOException {
        BufferedReader br = new BufferedReader(reader);

        try {
            String linea;
            linea = br.readLine();
            while (linea != null) {

                String[] parte = linea.split(":");
                this.mapa.put(parte[0], parte[1]);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {

            throw new IOException("Error: entrada/salida");
        }
    }

    public void introDatos(String u, String p) throws IOException {
        try {
            this.write.write(u + ":" + p + "\n");
            write.close();
        } catch (IOException e) {

            throw new IOException("Error: entrada/salida");
        }
    }

    public boolean VeriUsuario(String usuario) {
        String expresionRegular = "^[\\w_-]{2,16}$";
        Pattern p = Pattern.compile(expresionRegular);
        Matcher m = p.matcher(usuario);

        return m.matches();
    }

    public boolean VeriPass(String pass) {
        String expresionRegular = "^[\\w!@#%&?*]+$";
        Pattern p = Pattern.compile(expresionRegular);
        Matcher m = p.matcher(pass);

        return m.matches();
    }

}
