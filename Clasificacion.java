import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clasificacion {
    private List<PuntuacionPiloto> lista = new ArrayList<>();





    public void addPuntuacionPiloto(PuntuacionPiloto p){
         lista.add(p);
    }

    private void ordenaClasificacion(){
        Collections.sort(this.lista);
    }
    
    public void imprimirClasificacion(){
        ordenaClasificacion();
        for (PuntuacionPiloto p : lista) {
            System.out.println(p.getNombrePiloto()+" - " +p.getPuntos());
        }
    }
}
