package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza un programa que si lee por consola 0, muestra la superficie y el
perímetro de un cuadrado; si lee 1, muestra la superficie y el perímetro
de un rectángulo; y si lee 2, muestra la superficie de un triángulo. Todos
los valores se leen por consola. Si no es una opción válida se indica por
consola que ha habido un error.*/
public class Tema2Ejercicio17 {
    public static void main(String[] args) {
        int opcion;
        double lado,base,alt,sup,perim;
        Scanner sc=new Scanner(System.in);
        System.out.println("---SUPERFICIE&PERIMETRO DE FIGURAS---"+
                "\nIntroduce la figura que quieres utilizar: "+
                "\n0.Cuadrados"+"\n1.Rectangulo"+"\n2.Triangulo");
        opcion=sc.nextInt();
        switch (opcion){
            case 0:
                System.out.println("Introduce el valor del lado: ");
                lado= sc.nextDouble();
                sup=lado*lado;
                perim=lado*4;
                System.out.println("---CUADRADO---"+"\nPerimetro: "+perim+"\nSuperficie: "+sup);
                break;
            case 1:
                System.out.println("Introduce el valor de la base: ");
                base=sc.nextDouble();
                System.out.println("Introduce el valor de la altura: ");
                alt=sc.nextDouble();
                sup=base*alt;
                perim=2*(base*alt);
                System.out.println("---RECTANGULO---"+"\nPerimetro: "+perim+"\nSuperficie: "+sup);
                break;
            case 2:
                System.out.println("Introduce el valor de la base: ");
                base=sc.nextDouble();
                System.out.println("Introduce el valor de la altura: ");
                alt=sc.nextDouble();
                sup=base*alt/2;
                System.out.println("---TRIANGULO---"+"\nSuperficie: "+sup);
                break;
            default:
                System.err.println("ERROR OPCION NO VALIDA");
                break;
        }
        sc.close();
    }
}
