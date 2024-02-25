public class Pieza {
    private String forma;
    private String color;

    
    
    public Pieza(String forma, String color) {
        this.forma = forma;
        this.color = color;
    }

    public double area(){
        return 0.0;
    }

    public boolean equals(Object o) {
        Pieza p = (Pieza) o;
        return this.color.equals(p.color) &&
        this.forma.equals(p.forma) &&
        this.area() == p.area();
        }
        
}
