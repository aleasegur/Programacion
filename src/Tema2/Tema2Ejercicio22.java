package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que lea por consola un número entero e indique
cuántas cifras tiene. Pista: usa varias divisiones entre 10.*/
public class Tema2Ejercicio22 {
    public static void main(String[] args) {
        int num,digitos=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("INtroduce un numero: ");
        num=sc.nextInt();
        while (num!=0){
            num/=10;
            digitos++;
        }
        System.out.println("La cantidad de cifras es "+digitos);
        sc.close();
    }
}
