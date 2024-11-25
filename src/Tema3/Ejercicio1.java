package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* 1) Crea un programa que pida un número por consola y nos indique si es
positivo, negativo o 0. Para ello implementa la función numberSign que
devuelve 0, 1 o -1 dependiendo de si el número que recibe como
parámetro es 0, positivo o negativo.
*/
public class Ejercicio1 {
    public static int numberSign(int num){
        int res=num;
        if (num==0){
            res=0;
            System.out.println("El numero es "+res);
        }else if (num>=1){
            res=1;
            System.out.println("El numero es positivo "+res);
        }else {
            res=-1;
            System.out.println("El numero es negativo "+res);
        }
        return res;
    }

    public static void mostrarPositivo0Negativo(Scanner sc) {
        int num;
        System.out.println("---COMPROBACION DE NUMERO POSITIVO,NEGATIVO O 0---");
        System.out.println("Introduce un numero: ");
        num = sc.nextInt();
        numberSign(num);
        //sc.close();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        mostrarPositivo0Negativo(sc);
        sc.close();
    }
}
