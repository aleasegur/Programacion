package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que determina si el número leído por consola es
positivo, negativo o zero.
*/
public class Tema2Ejercicio6 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un valor: ");
        num = sc.nextInt();
        if (num == 0) {
            System.out.println("El numero es zero");
        } else if (num > 0) {
            System.out.println("El numero es positivo");
        } else {
            System.out.println("El numero es negativo");
        }

    }
}
