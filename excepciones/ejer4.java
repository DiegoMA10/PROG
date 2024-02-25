

public class ejer4 {
    public static void main(String[] args) {
       ValidaLista lista = new ValidaLista();
        try {
            System.out.println("Introduce un nombre de un compositor");
            int i = lista.ValidarCompositor();
            System.out.println("El compositor se encuentra en la posición: " + i);
        } catch (ElementoNoExistente e) {
            System.out.println(e.getMessage());
        }
       
    }
}
