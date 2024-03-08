import java.util.ArrayList;
import java.util.List;

public class ResultadoCarrera {
    private Circuito c;
    private Piloto p;
    private Integer posicion;



    public ResultadoCarrera(Circuito c, Piloto p, Integer posicion) {
        this.c = c;
        this.p = p;
        this.posicion = posicion;
    }



    public Circuito getC() {
        return c;
    }



    public Piloto getP() {
        return p;
    }



    public Integer getPosicion() {
        return posicion;
    }

    



}
