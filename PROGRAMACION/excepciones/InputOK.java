import java.util.InputMismatchException;
import java.util.Scanner;

public class InputOK {
    private static Scanner sc = new Scanner(System.in);

    public int Leeint() throws InputMismatchException {

        int n = 0;

        try {

            n = sc.nextInt();
            sc.nextLine();
            return n;

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Espabila");

        }

    }

    public int LeeIntPositivo() throws InputMismatchException {

        int n = 0;

        n = Leeint();

        if (n < 0) {
            throw new InputMismatchException("Numero no positivo");
        }

        return n;

    }

    public int LeeIntRango() throws InputMismatchException {
        int n = 0;

        n = Leeint();

        if (n < 10 || n > 80) {
            throw new InputMismatchException("Numero fuera de rango de (10 , 80)");
        }

        return n;
    }

    public double LeeDou() throws NumberFormatException {

        try {

            Double n = verificarDouble();
            return n;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Numero no valido");
        }

    }


    public Double LeeDouRango() throws NumberFormatException {
        Double n = 0.0;

        n = LeeDou();

        if (n < 10.5 || n > 15.5) {
            throw new NumberFormatException("Numero fuera de rango de (10.5 , 15.5)");
        }

        return n;
    }

    private double verificarDouble() { //Para poder insertar un doble con "," y "."
        String n2 = "";
        n2 = sc.nextLine();
        double n = 0.0;

        try {
            n = Double.parseDouble(n2);
            return n;
        } catch (NumberFormatException e) {

            String n3 = n2.replace(',', '.');
            n = Double.parseDouble(n3);
            return n;

        }
    }



}
