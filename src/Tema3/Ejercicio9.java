package Tema3;

import java.util.Scanner;
/*
* Escribe un procedimiento que muestre por pantalla un triángulo como el
que hay a continuación. Recibirá 2 parámetros: el carácter y el número
de líneas del triángulo.*/
public class Ejercicio9 {

    public static void imprimirPiramide(int num, char car) {
        for (int i = 0; i <= num; i++) {
            //Imprime espacios para centrar las lineas
            for (int j = 0; j <= num - i - 1; j++) {
                System.out.print(" ");
            }
            //Imprime el carácter
            for (int k = 0; k < i; k++) {
                System.out.print(car + " ");
            }
            System.out.println();
        }
    }

    public static void mostrarPirmaide(Scanner sc){
        int num;
        char car;
        System.out.println("Introduce las lineas que quieres: ");
        num = sc.nextInt();
        System.out.println("Introduce el caracter que deseas: ");
        car = sc.next().charAt(0);
        imprimirPiramide(num, car);
       // sc.close();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        mostrarPirmaide(sc);
        sc.close();
    }
}
