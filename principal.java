import java.util.List;

public class principal {
    public static void main(String[] args) {
        Formula1 f = new Formula1();
        boolean salida = false;
        Clasificacion c = new Clasificacion();

        do {
            salida = false;
        
        Integer i = f.menu();
        switch (i) {
            case 1: f.resultadosCarerra();break;

            case 2: f.clasificacion().imprimirClasificacion();
           
            
            break;
            case 3: salida = false ;break;
        
            default: salida = true; break;
        }
    } while (salida);
     
    }
}
