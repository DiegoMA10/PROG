

import java.io.File;

public class rmj {

    public static void main(String[] args) {
        
        if (args.length>0) {
            File file = new File(args[0]);

            try {
                
                if (file.exists()) {
                    
                    if (!file.isDirectory()) {

                        file.delete();
                        System.out.println("El fichero "+file.getName()+" a sido borrado exitosamente");
                        
                    }else{

                        System.out.println("El archivo es un directorio y no se puede borrar");
                    }

                }else{
                    System.out.println("El fichero no existe");
                }
    
               
            } catch (SecurityException e) {
               System.out.println("No tienes permisos");
            }
    
        }else{
            System.out.println("Inserta un fichero: java rmj <Fichero>");
        }

    }
}
