package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
Realiza un programa que lea por consola la base y la altura de un
triángulo y mostrará por consola la superficie.*/
public class Tema2Ejercicio3 {
    public static void main(String[] args) {
        double base,alt,sup=0.0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la base: ");
        base=sc.nextDouble();
        System.out.println("Introduce la altura: ");
        alt=sc.nextDouble();
        sup=base*alt/2;
        System.out.println("---TRIANGULO--- "+"\n"+
                "Superficie = "+sup);
        sc.close();
    }
}
