import java.io.*;

public class PuntuacionPiloto implements Comparable<PuntuacionPiloto> {
    private Piloto p;
    private Integer puntos = 0;

  

    public PuntuacionPiloto(Piloto p) {
        this.p = p;
        this.puntos = calculaPuntos(p.getNombre());
    }

    

    public Integer getPuntos() {
        return puntos;
    }
    
    public String getNombrePiloto(){
        return p.getNombre();
    }


    private Integer calculaPuntos(String nombrePiloto){

        try (BufferedReader br = new BufferedReader(new FileReader("resultado.txt"))) {
            String linea;
            linea = br.readLine();
            while (linea != null) {

               
                String[] parte = linea.split(":");
              
                if (nombrePiloto.equals(parte[1])) {
                    
                    switch (parte[2]) {
                        case "1": this.puntos+= 25; break;
                        case "2": this.puntos+=18;break;
                        case "3": this.puntos+=15;break;
                        case "4": this.puntos+=12;break;
                        case "5": this.puntos+=10;break;
                        case "6":this.puntos+=8;break;
                        case "7":this.puntos+=6;break;
                        case "8":this.puntos+=4;break;
                        case "9":this.puntos+=2;break;
                        case "10":this.puntos+=1;break;
                    
                        default: break;
                }
             
            }  
            linea = br.readLine();
        }
                return 0; 
           
            
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        return puntos;

    }


    @Override
    public int compareTo(PuntuacionPiloto arg0) {
        return arg0.getPuntos() - this.puntos;
    }
}
