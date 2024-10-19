package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lea 3 números por consola y los muestre
 ordenados de mayor a menor.*/
public class Tema2Ejercicio12 {
    public static void main(String[] args) {
        int num1,num2,num3,ordenar;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        num1=sc.nextInt();
        System.out.println("Introduce el segundo numero: ");
        num2=sc.nextInt();
        System.out.println("Introduce el tercer numero: ");
        num3=sc.nextInt();

        if (num1<num2){
            ordenar=num1;
            num1=num2;
            num2=ordenar;
        }

        if (num1<num3){
            ordenar=num1;
            num1=num3;
            num3=ordenar;
        }

        if (num2<num3){
            ordenar=num2;
            num2=num3;
            num3=ordenar;
        }

        System.out.println("Los numeros ordenados son "+num1+" , "+num2+" , "+num3);

    }
}
