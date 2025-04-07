package RankingVideojuegos;

import javax.print.DocFlavor;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosRanking {
    public static final String DIRECTORIO="DirectorioRankingGames/";
    public static final String DIR_FILE_TXT="DirectorioRankingGames/ranking.txt";
    public static final String DIR_FILE_DAT="DirectorioRankingGames/ranking.dat";

    public static String introducirString(Scanner sc,String tipo){
        String res="";
        try {
            System.out.println("Introduce "+tipo);
            res=sc.next().toLowerCase();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static int introdcirNota(Scanner sc, String tipo){
        int res=0;
        do {
            try {
                System.out.println("Introduce " + tipo);
                res = sc.nextInt();

            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (res<0 || res>10);
        return res;
    }

    public static double introdcirTam(Scanner sc, String tipo){
        double res=0;
        do {
            try {
                System.out.println("Introduce " + tipo);
                res = sc.nextDouble();
            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (res<0 || res>10);
        return res;
    }

    public static String introducirEstado(Scanner sc,String tipo){
        String res="";
        boolean bucleEstado=true;
        int opcion;
        while (bucleEstado){
            try {
                System.out.println("---SELECCIONA EL ESTADO DEL VIDEOJUEGO FISICO---");
                System.out.println("1.Nuevo");
                System.out.println("2.Usado");
                System.out.println("Elegir opcion: ");
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        res="nuevo";
                        bucleEstado=false;
                        break;
                    case 2:
                        res="usado";
                        bucleEstado=false;
                        break;
                    default:
                        System.err.println("Opcion elegido incorrecta");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return res;
    }

}
