package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Crea un programa que pida al usuario un radio válido por teclado (>0) y
calcule la superficie y perímetro de un círculo. Necesitarás implementar
y utilizar las siguientes funciones:
boolean validRadius(radius)
double calculateCirclePerimeter(radius)
double calculateCircleArea(radius)
*/
public class Ejercicio3 {
    public static boolean validRadius(double radius){
        boolean res=radius>0;
        return res;
    }

    public static double calculateCirclePerimeter(double radius){
        double res=0;
        res=2*Math.PI*radius;
        return res;
    }

    public static double calculateCircleArea(double radius){
        double res=0;
        res=Math.PI*radius*radius;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double radius;
        double resultArea=0,resultPerim=0;
        System.out.println("Ingrese el radio del circulo: ");
        radius=sc.nextDouble();
        if (validRadius(radius)){
            resultArea=calculateCircleArea(radius);
            resultPerim=calculateCirclePerimeter(radius);
            System.out.println("Perimetro: "+resultPerim);
            System.out.println("Area: "+resultArea);
        }else {
            System.err.println("El radio es negativo.Debe ser positivo");
        }
        sc.close();
    }
}
