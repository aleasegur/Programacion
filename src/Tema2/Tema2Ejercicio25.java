package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Haz un programa que pide un número entero por consola y calcula el
factorial. Por ejemplo el factorial de 5 es:
5! = 5 * 4 * 3 * 2 * 1*/
public class Tema2Ejercicio25 {
    public static void main(String[] args) {
        int num,fact=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un numero para calcular su factorial: ");
        num=sc.nextInt();
        for (int i = 1; i <= num; i++) {
            fact*=i;
        }
        System.out.println("El factorial de "+num+" es "+fact);
        sc.close();
    }
}
