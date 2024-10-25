package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Haz un programa que pida un número entero por consola e indica si es
primo o no. Un número primo sólo es divisible por él mismo y por la
unidad.
*/
public class Tema2Ejercicio26 {
    public static void main(String[] args) {
        int num;
        boolean esPrimo=true;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un numero para ver si es primo o no: ");
        num=sc.nextInt();
        if (num<=1){
            esPrimo=false;
        }else {
            for (int i = 2; i <num; i++) {
                if (num%i==0){
                    esPrimo=false;
                }
            }
        }
        if (esPrimo==true){
            System.out.println("El numero "+num+" es primo");
        }else {
            System.out.println("El numero "+num+" no es primo");
        }
        sc.close();
    }
}
