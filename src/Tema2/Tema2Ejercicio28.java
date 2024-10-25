package Tema2;

import java.util.Random;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Haz un programa que calcule un número aleatorio de la lotería de
Navidad (de 0 a 99.999) y después pida al usuario por consola hasta 5
números indicando cada vez si ha ganado la lotería o no.*/
public class Tema2Ejercicio28 {
    public static void main(String[] args) {
        int numUser,numWin;
        Scanner sc=new Scanner(System.in);
        Random ran=new Random();
        numWin=ran.nextInt(99999);
            for (int i = 1; i <= 5; i++) {
                System.out.println(numWin);
                System.out.println("Introduce tu numero de la loteria: ");
                numUser = sc.nextInt();
                if (numUser == numWin) {
                    System.out.println("¡FELICIDADES!Has ganado la loteria" );
                } else {
                    System.out.println("No es el numero ganador");
                }
            }
            System.out.println("EL NUMERO GANADOR ERA "+numWin);
            sc.close();
    }
}
