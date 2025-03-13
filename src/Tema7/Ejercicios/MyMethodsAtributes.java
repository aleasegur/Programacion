package Tema7.Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyMethodsAtributes {

    //Constante statica que tiene el nombre del directorio que contiene los ficheros o carpetas
    public static final String namePath="Documentos/";

    //Metdodo que devuelve una cadena de texto
    public static String introducirCadena(Scanner sc, String tipo){
        String res=null;
        try {
            System.out.println("Introduce "+tipo);
            res=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

    //Metdodo que devuelve un entero
    public static int introducirEntero(Scanner sc, String tipo){
        int res=0;
        try {
            System.out.println("Introduce "+tipo);
            res=sc.nextInt();
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }

}
