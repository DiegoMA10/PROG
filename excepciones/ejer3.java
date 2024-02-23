public class ejer3 {
    public static void main(String[] args) {
        InputOK sc = new InputOK();

        int n = 0;
        double n2 = 0;
        try{
            System.out.print("numero entero: ");
            n = sc.Leeint();
            System.out.println(n);

            System.out.print("numero entero positivo: ");
            n=sc.LeeIntPositivo();
            System.out.println(n);
            
            System.out.print("numero en el rango de 10-80: ");
            n=sc.LeeIntRango();
            System.out.println(n);

            System.out.print("Numero real: ");
            n2 = sc.LeeDou();
            System.out.println(n2);

            System.out.print("numero real en el rango de 10.5 - 15.5: ");
            n2 = sc.LeeDouRango();
            System.out.println(n2);
            

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }
}
