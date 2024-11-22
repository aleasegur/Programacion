package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*  Utiliza la función anterior y una función nueva que crearás llamada
isAdult para hacer un programa que reciba una edad e indica si se es
mayor de edad o no.
boolean isAdult(age)
*/
public class Ejercicio2 {

    public static boolean isAdult(int edad){
        boolean res=false;
        if (edad>=18){
            System.out.println("Es mayor de edad");
            res=true;
        }else {
            System.out.println("No eres mayor de edad");
        }
        return res;
    }

    public static void mostrarEdadMayor(Scanner sc){
        int edad;
        System.out.println("Introduce tu edad: ");
        edad=sc.nextInt();
        isAdult(edad);
        Ejercicio1.numberSign(edad);
        //sc.close();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        mostrarEdadMayor(sc);
        sc.close();
    }
}
