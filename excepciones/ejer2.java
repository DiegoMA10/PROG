import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer2 {

    public static int division(int num, int den) throws ArithmeticException {

        try {
            return num / den;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se puede dividir por 0 crack");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1;
        int n2;
        try {
            System.out.print("nominador: ");
            n1 = sc.nextInt();
            System.out.print("denominador: ");
            n2 = sc.nextInt();
            int resutado = division(n1, n2);
            System.out.println(resutado);

        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException --> valor no numérico");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Problemas con la division");
        }

    }

}
