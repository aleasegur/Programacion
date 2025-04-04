package Tema7.EjercicioCSV;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyMetodosCSV {
    public static final String PATH_CSV ="DirectorioFunkos/";
    public static final String FILE_CSV ="funkos.csv";
    public static final String FILE_DAT="funkos.dat";

    public static String introducirString(Scanner sc, String tipo){
        String res="";
        try{
            System.out.println("Introduce "+tipo);
            res=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static double introducirNumeroReal(Scanner sc,String tipo){
        double res=0;
        try {
            System.out.println("Introduce "+tipo);
            res=sc.nextDouble();
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public static LocalDate introducirFecha(Scanner sc,String tipo){
        LocalDate res = null;
        try {
            System.out.println("Introduce "+tipo);
            res=LocalDate.parse(sc.next());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

}
