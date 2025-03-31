package Tema7.EjercicioCSV;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyMetodos{
    private static final String path="DirectorioFukos/";
    private static final String file="funkos.csv";

    public String introducirString(Scanner sc, String tipo){
        String res="";
        try{
            System.out.println("Introduce "+tipo);
            sc.nextLine();
            res=sc.nextLine();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    public double introducirNumeroReal(Scanner sc,String tipo){
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

}
