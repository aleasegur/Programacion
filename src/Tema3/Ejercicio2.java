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
        if (edad>=18) {
            res = true;
        }
        return res;
    }

    /*
    public static void mostrarEdadMayor(Scanner sc){
        int edad;
        System.out.println("Introduce tu edad: ");
        edad=sc.nextInt();
        if(isAdult(edad)){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor edad");
        }
        System.out.println("Numero asignado es "+Ejercicio1.numberSign(edad));
        //sc.close();
    }*/

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int edad,num;
        System.out.println("Introduce tu edad: ");
        edad=sc.nextInt();
        if(isAdult(edad)){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor edad");
        }

        System.out.println("Introduce un numero: ");
        num = sc.nextInt();
        if (Ejercicio1.numberSign(num)==0){
            System.out.println("El numero es "+Ejercicio1.numberSign(num));
        }else if (Ejercicio1.numberSign(num)>=1){
            System.out.println("El numero es positivo. ");
        }else {
            System.out.println("El numero es negativo.");
        }
        sc.close();
    }
}
