package Tema1;

import java.util.Scanner;

//ALEJANDRO ASENCIO GURAU
/*Haz un algoritmo que pida un año por consola e indique si
es bisiesto o no. Aquí tienes información de cómo averiguarlo*/
public class Tema1Ejercicio12 {
    public static void main(String[] args) {
        int year;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un año: ");
        year=sc.nextInt();
        if (year%4==0 && year%100==0 && year%400==100){
            System.out.println("El año "+year+" es bisiesto");
        }else {
            System.out.println("El año "+year+" no es bisiesto");
        }
        sc.close();
    }
}
