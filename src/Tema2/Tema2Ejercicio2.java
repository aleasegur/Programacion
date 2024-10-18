package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
Realiza un programa que lea por consola la base y la altura de un
rectángulo y mostrará por consola la superficie y el perímetro.*/
public class Tema2Ejercicio2 {
    public static void main(String[] args) {
        double base,alt,per=0.0,sup=0.0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el valor de la base: ");
        base=sc.nextDouble();
        System.out.println("Introduce el valor de la altura: ");
        alt=sc.nextDouble();
        sup=base*alt;
        per=2*(base+alt);
        System.out.println("---RECTANGULO--- "+"\n"+
                "Superficie = "+sup+"\n"+
                "Perimetro = "+per);
        sc.close();
    }
}
