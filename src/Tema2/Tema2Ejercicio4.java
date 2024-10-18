package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lea 3 números por consola y devuelva el
mayor de ellos.*/
public class Tema2Ejercicio4 {
    public static void main(String[] args) {
        double num1,num2,num3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el primer valor: ");
        num1= sc.nextDouble();
        System.out.println("Introduce el segundo valor: ");
        num2= sc.nextDouble();
        System.out.println("Introduce el tercer valor: ");
        num3= sc.nextDouble();

        if (num1>num2 && num1>num3){
            System.out.println("El mayor es "+num1);
        }else if (num2>num1 && num2>num3){
            System.out.println("El mayor es "+num2);
        }else {
            System.out.println("El mayor es "+num3);
        }
        sc.close();
    }
}
