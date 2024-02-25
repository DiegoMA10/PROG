import java.util.Scanner;

public  class ValidaLista {
    private static Scanner sc = new Scanner(System.in);
    public static final String[] COMPOSITORES = {"Bach", "Haydn", "Mozart", "Beethoven",
    "Brahms", "Mahler", "Bartok"};


        
    public int ValidarCompositor() throws ElementoNoExistente{
        
        String n = sc.nextLine();

        for (int i = 0; i < COMPOSITORES.length; i++) {
            if (COMPOSITORES[i].equals(n)) {
                return i;
            }
        }
        throw new ElementoNoExistente("No existe el compositor");
    }



}