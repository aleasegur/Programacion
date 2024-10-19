package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un conversor de dólares a euros.*/
public class Tema2Ejercicio9 {
    public static void main(String[] args) {
        double euros=0.94, dolar;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la cantidad de dolares que quieres convertir a euros: ");
        dolar=sc.nextDouble();
        euros*=dolar;
        System.out.println("Euros son "+euros+"\n"+"Dolares son "+dolar);
        sc.close();
    }
}
