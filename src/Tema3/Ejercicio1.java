package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* 1) Crea un programa que pida un número por consola y nos indique si es
positivo, negativo o 0. Para ello implementa la función numberSign que
devuelve 0, 1 o -1 dependiendo de si el número que recibe como
parámetro es 0, positivo o negativo.
*/
public class Ejercicio1 {
    public static void numberSign(int num){
        if (num==0){
            System.out.println("El numero introducido es "+num);
        }else if (num>=1){
            System.out.println("El numero introducido es positivo");
        }else {
            System.out.println("El numero introducido es negativo");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.println("---COMPROBACION DE NUMERO POSITIVO,NEGATIVO O 0---");
        System.out.println("Introduce un numero: ");
        num=sc.nextInt();
        numberSign(num);
    }
}
