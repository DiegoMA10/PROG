import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1;
        int n2;
        try {
            System.out.print("nominador: ");
            n1 = sc.nextInt();
            System.out.print("denominador: ");
            n2 = sc.nextInt();
            int n3 = n1 / n2;

            System.out.println(n3);
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException --> valor no numérico");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException --> dividir por 0");
        } catch (Exception e) {
            System.out.println("Problemas con la division");
        }

    }

}