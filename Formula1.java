
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Formula1 {
    private List<Piloto> pilotos = new ArrayList<>();
    private List<Circuito> circuitos = new ArrayList<>();
    private List<ResultadoCarrera> resultados = new ArrayList<>();

    public Formula1() {
        leerPilotos();
        leerCircuitos();
    }

    

    public List<Piloto> getPilotos() {
        return pilotos;
    }



    private void leerPilotos() {
        try (BufferedReader br = new BufferedReader(new FileReader("pilotos.txt"))) {
            String linea;
            linea = br.readLine();
            while (linea != null) {

                String[] parte = linea.split(":");
                this.pilotos.add(new Piloto(parte[0], parte[1], parte[2]));

                linea = br.readLine();
            }

        } catch (IOException e) {

            System.out.println("hola");
        }

    }

    private void leerCircuitos() {
        try (BufferedReader br = new BufferedReader(new FileReader("circuitos.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {

                String[] parte = linea.split(":");
                Integer nCircuto = Integer.parseInt(parte[0]);
                Integer m = Integer.parseInt(parte[3]);
                this.circuitos.add(new Circuito(nCircuto, parte[1], parte[2], m));

            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    public int menu() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1. Agregar resultados");
            System.out.println("2. Clasificación");
            System.out.println("3. Salir");

            while (true) {
                System.out.print("--->");
                String a = br.readLine();
                switch (a) {
                    case "1":
                        return 1;
                    case "2":
                        return 2;
                    case "3":
                        return 3;
                    default:
                        System.out.print("\033[1A");
                        System.out.print("\033[2K");
                        break;
                }

            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return 0;

    }

    public void resultadosCarerra() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numero = "";
        boolean salida = false;
        do {
            salida = false;
            try {
                System.out.print("Introduce el número de circuito: ");
                numero = br.readLine();
                Integer n = Integer.parseInt(numero);
                if (n > 24 || n < 1) {
                    System.out.print("\033[1A");
                    System.out.print("\033[2K");
                    salida = true;
                } else {
                    System.out.println(">> Has seleccionado el circuito: " + circuitos.get(n).getNombre());
                    for (Piloto piloto : pilotos) {
                        Boolean salida2 = false;
                        Integer posicion = 0;
                        do {
                            salida2 = false;

                            try {
                                System.out.print("Introce la posicion de " + piloto.getNombre() + ": ");
                                numero = br.readLine();
                                posicion = Integer.parseInt(numero);
                                if (posicion > 24 || posicion < 1) {
                                    System.out.print("\033[1A");
                                    System.out.print("\033[2K");
                                    salida2 = true;
                                }
                            } catch (NumberFormatException e) {
                                System.out.print("\033[1A");
                                System.out.print("\033[2K");
                                salida2 = true;
                            }

                        } while (salida2);
                        resultados.add(new ResultadoCarrera(circuitos.get(n), piloto, posicion));

                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.print("\033[1A");
                System.out.print("\033[2K");
                salida = true;
            }

        } while (salida);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("resultado.txt", true))) {

            for (ResultadoCarrera resultado : resultados) {

                bw.write(resultado.getC().getNcircuito()+":"+resultado.getP().getNombre()+":"+resultado.getPosicion()+"\n");
                        
            }

        } catch (IOException e) {
           
            e.printStackTrace();
        }
        
    }

    public Clasificacion clasificacion(){
        Clasificacion c = new Clasificacion();
            for (Piloto p : this.pilotos) {
                    c.addPuntuacionPiloto(new PuntuacionPiloto(p));
            }
        return c;
    }

   

}

