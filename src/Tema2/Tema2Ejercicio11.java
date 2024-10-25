package Tema2;

import java.util.Scanner;
/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que indique si los 3 números enteros que pedimos
 por consola son consecutivos o no.*/
public class Tema2Ejercicio11 {
    public static void main(String[] args) {
        int num1,num2,num3;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        num1=sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        num2=sc.nextInt();
        System.out.println("Introduce el tercer numero: ");
        num3=sc.nextInt();

        if ((num1==num2+1 && num2==num3+1)||(num1==num2-1 && num2==num3-1)){
            System.out.println("Los numeros son consecutivos");
        }else {
            System.out.println("Los numeros no son consecutivos");
        }
        sc.close();
    }
}
