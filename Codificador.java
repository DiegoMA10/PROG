import java.text.Normalizer;
import java.util.Arrays;
import java.util.HashMap;

public class Codificador {
    final private char[] mayusLetras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    final private char[] minusLetras = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
    private int desplazamiento;
    private HashMap <Character,Character>mapaCodificado = new HashMap<>();
    private HashMap <Character,Character>mapaDescodificado = new HashMap<>();

    public Codificador(int desplazamiento){
        this.desplazamiento=desplazamiento;
        crearMapeo();
    }

    private void crearMapeo(){
        for (int i = 0; i < mayusLetras.length; i++) {
         
           this.mapaCodificado.put(this.mayusLetras[i], mayusLetras[(i + desplazamiento) % mayusLetras.length]);
            this.mapaCodificado.put(this.minusLetras[i], minusLetras[(i + desplazamiento) % minusLetras.length]);
           this.mapaDescodificado.put(this.mayusLetras[i], mayusLetras[(mayusLetras.length+(i - desplazamiento)) % mayusLetras.length]);
           this.mapaDescodificado.put(this.minusLetras[i], minusLetras[(minusLetras.length+(i - desplazamiento)) % minusLetras.length]);
        }
      
      
    }

      public static char quitarAcentos(char caracter) { // patrocinado por el amigo chatgpt :)
        String caracterNormalizado = Normalizer.normalize(String.valueOf(caracter), Normalizer.Form.NFD);
        String caracterSinAcento = caracterNormalizado.replaceAll("\\p{InCombiningDiacriticalMarks}1", "");
        return caracterSinAcento.charAt(0);
    }

    public char codificar(char l) {
        l = quitarAcentos(l);
      if (Character.isLetter(l)) {
       
        return this.mapaCodificado.get(l);
      }
  
       return l;
    
   
    }

    public char descodificar(char l){

        if (Character.isLetter(l)) {
            return this.mapaDescodificado.get(l);
          }

        return l;
    }
}
