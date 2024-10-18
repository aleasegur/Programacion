package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lea por consola el lado de un cuadrado y
mostrará por consola la superficie y el perímetro.*/
public class Tema2Ejercicio1 {
    public static void main(String[] args) {
        int lado, peri = 0, sup = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el valor del lado: ");
        lado = sc.nextInt();
        sup = lado * lado;
        peri = lado * 4;
        System.out.println("----CUADRADO---- " + "\n" +
                "Superficie = " + sup + "\n" +
                "Perimetro = " + peri);
    }
}
