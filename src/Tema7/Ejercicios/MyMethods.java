package Tema7.Ejercicios;

import java.util.Scanner;

public class MyMethods {
    //Metdodo que devuelve una cadena de texto
    public static String introducirCadena(Scanner sc, String tipo){
        String res=null;
        try {
            System.out.println("Introduce el nombre del archivo de "+tipo);
            res=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return res;
    }
}
