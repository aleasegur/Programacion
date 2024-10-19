package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lea 2 números por consola y al más grande le
 reste el más pequeño.*/
public class Tema2Ejercicio7 {
    public static void main(String[] args) {
        int num1,num2,may,men,resta;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        num1=sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        num2=sc.nextInt();
        if (num1>num2){
            may=num1;
            men=num2;
        }else {
            may=num2;
            men=num1;
        }
        resta=may-men;
        System.out.println(may+" - "+men+" = "+resta);
        sc.close();
    }
}
