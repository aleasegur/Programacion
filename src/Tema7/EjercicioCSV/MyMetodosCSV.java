package Tema7.EjercicioCSV;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyMetodosCSV {
    public static final String PATH_CSV ="DirectorioFukos/";
    public static final String FILE_CSV ="funkos.csv";

    public static String introducirString(Scanner sc, String tipo){
        String res="";
        try{
            System.out.println("Introduce "+tipo);
            sc.next();
            res=sc.nextLine();
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
            res=LocalDate.parse(sc.nextLine());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

}
