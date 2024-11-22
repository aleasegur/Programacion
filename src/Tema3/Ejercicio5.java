package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que pida un número entero por consola de 1 a 10 y
te muestre su tabla de multiplicar.*/
public class Ejercicio5 {
    public static void tablaMultiplicar(int num){
        int res=0;
        System.out.println("La tabla de mulriplicar de " + num + " :");
        for (int i = 0; i <=10 ; i++) {
            res=i*num;
            System.out.println(num+" * "+i+" = "+res);
        }
    }

    public static boolean comprobarNumeroMultiplicacion(int num){
        boolean res=num>=1 && num<=10;
        return  res;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num;
        char opcion;
        boolean condicion=true;
        while (condicion) {
            do {
                System.out.println("Introduce un numero para mostrar su tabla de multiplicacion: ");
                num = sc.nextInt();
                if (comprobarNumeroMultiplicacion(num)) {
                    tablaMultiplicar(num);
                } else {
                    System.out.println("Error: debe introducir un numero entre 1 y 10");
                }
            }while (!comprobarNumeroMultiplicacion(num));
            do {
                System.out.println("Desea volver a realizar una tabla de multiplicacion(s/n)");
                opcion=sc.next().toLowerCase().charAt(0);
                switch (opcion){
                    case 's':
                        break;
                    case 'n':
                        System.out.println("Saliendo...");
                        condicion=false;
                        break;
                    default:
                        System.out.println("ERROR: CARACTER NO RECONOCIDO.VUELVA A INTRODUCIR");
                }
            }while (opcion!='s' && opcion!='n');

        }
        sc.close();
    }
}
