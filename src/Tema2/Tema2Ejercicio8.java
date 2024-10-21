package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
 * Realiza un conversor de euros a dólares.*/
public class Tema2Ejercicio8 {
    public static void main(String[] args) {
        double euros,dolar = 1.09;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la cantidad de euros que quieres convertir a dolares: ");
        euros=sc.nextDouble();
        dolar*=euros;
        System.out.println("Euros son "+euros+"\n"+"Dolares son "+dolar);
        sc.close();
    }
}
