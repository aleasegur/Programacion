package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lea 3 números por consola y calcule la media
con decimales y sin decimales.*/
public class Tema2Ejercicio5 {
    public static void main(String[] args) {
        double num1,num2,num3,media=0.0;
        int mediaSinDecimales=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el primer valor: ");
        num1= sc.nextDouble();
        System.out.println("Introduce el segundo valor: ");
        num2= sc.nextDouble();
        System.out.println("Introduce el tercer valor: ");
        num3= sc.nextDouble();
        media=(num1+num2+num3)/3;
        mediaSinDecimales=(int)(num1+num2+num3)/3;
        System.out.println("Media con decimales "+media+"\n"+
                "Media sin decimales "+mediaSinDecimales);
        sc.close();
    }
}
