import java.io.File;

public class ejer2 {

    public static long tamanyoDirectorio(File[] f) {
        long l = 0;

        if (f.length == 0) {
            return 0;
        } else {
            for (File file : f) {
                try {
                    if (file.isDirectory()) {
                        l += tamanyoDirectorio(file.listFiles());
                    }

                    if (file.isFile()) {
                        l += file.length();
                    }

                } catch (Exception e) {

                    System.out.println("Error al obtener el tamaño de: " + file.getAbsolutePath());
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            File file = new File(args[0]);

            try {

                if (file.exists()) {
                    long tamanyo = 0;
                    if (file.isDirectory()) {
                        System.out.println("Tipo: Directorio");
                        tamanyo = tamanyoDirectorio(file.listFiles());
                    }

                    if (file.isFile()) {
                        System.out.println("Tipo: Fichero");
                        tamanyo = file.length();
                    }

                    System.out.println("Tamaño: " + tamanyo + " Bytes");
                    System.out.println("Permisos: " + (file.canRead() ? "lectura, " : "") +
                            (file.canWrite() ? "escritura, " : "") +
                            (file.canExecute() ? "ejecución" : ""));

                } else {
                    System.out.println("El fichero no existe");
                }
            } catch (SecurityException e) {
                System.out.println("No tienes permisos");
            }catch(NullPointerException e){
                // Esta excepción ocurre cuando en la funcion tamanyoDirectorio le pones un fichero sin permisos :)
                System.out.println("No tienes permiso en la carpeta");
            }

        } else {
            System.out.println("Inserta un fichero: java ejer2 <Fichero>");
        }

    }
}
