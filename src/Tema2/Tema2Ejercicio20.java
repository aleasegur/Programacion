package Tema2;

import java.util.Scanner;

/*
* 20. Realiza un programa que lee por consola dos números enteros (A y B).
Si B es mayor que A, muestra todos los números impares entre ellos*/
public class Tema2Ejercicio20 {
    public static void main(String[] args) {
        int a,b;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el valor de A: ");
        a=sc.nextInt();
        System.out.println("Introduce el valor de B: ");
        b=sc.nextInt();
        if (b>a){
            for (int i = a; i<=b; i++) {
                if (i%2!=0){
                    System.out.println("Los numeros impares son "+i);
                }
            }
        }
    }
}
