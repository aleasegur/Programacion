package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*  Realiza un programa que indique si los 3 números que pedimos por
 teclado están ordenados de menor a mayor o no*/
public class Tema2Ejercicio10 {
    public static void main(String[] args) {
        int num1,num2,num3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        num1=sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        num2=sc.nextInt();
        System.out.println("Introduce el tercer numero: ");
        num3=sc.nextInt();

        if (num1<=num2 && num2<=num3){
            System.out.println("Los numeros estan ordenados");
        }else {
            System.out.println("Los numeros no estan ordenados");
        }
        sc.close();
    }
}
