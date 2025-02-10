package Tema5.Excepciones;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Implementa un programa que cree un vector tipo double de tamaño 5 y
luego, utilizando un bucle, pida cinco valores por teclado y los introduzca en el
vector. Tendrás que manejar la/las posibles excepciones y seguir pidiendo
valores hasta rellenar completamente el vector.*/
public class Ejercicio3 {

    public static double[] rellenarVector(Scanner sc,double[] vector){
        double[] res = new double[vector.length];
        double num;
        try {
            for (int i = 0; i < res.length; i++) {
                System.out.println("Introduce en el modulo "+i+" un numero real: ");
                num=sc.nextDouble();
                res[i]=num;
            }
            //Hago esto para comprobar si salta alguna exception
            System.out.println("Quieres introducir en el modulo 5 un numero?(s/n)");
            char opcion=sc.next().toLowerCase().charAt(0);
            if (opcion=='s') {
                res[5] = sc.nextDouble();
            }
        }catch (ArrayIndexOutOfBoundsException | InputMismatchException e){
            System.err.println("Error: "+e);
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[] vectorReal=new double[5];
        double[] result=rellenarVector(sc,vectorReal);
        System.out.println("Dentro del vector esta: "+ Arrays.toString(result));
    }
}
