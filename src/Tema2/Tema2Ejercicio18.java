package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que calcula la raíz cuadrada de un número. Si el
número es negativo debe mostrar un mensaje de error.*/
public class Tema2Ejercicio18 {
    public static void main(String[] args) {
        double num,raiz;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un valor: ");
        num=sc.nextDouble();
        if (num<0){
            System.err.println("ERROR: EL NUMERO ES NEGATIVO");
        }else {
            raiz=Math.sqrt(num);
            System.out.println("La raiz de "+num+" es "+raiz);
        }
        sc.close();
    }
}
