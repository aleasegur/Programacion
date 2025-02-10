package Tema5.Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Implementa un programa que pida dos valores int num1 y num2 utilizando un
nextInt( ) (de Scanner), calcule num1/num2 y muestre el resultado por pantalla.
Se deberán tratar de forma independiente las dos posibles excepciones,
InputMismatchException y ArithmeticException, mostrando en cada caso un
mensaje de error diferente en cada caso*/
public class Ejercicio2 {

    public static int calculoNUms(Scanner sc){
        int res=0;
        int num1,num2;
        try {
            System.out.println("Introduce el valor del primer numero: ");
            num1 = sc.nextInt();
            System.out.println("Introduce el valor del segundo numero: ");
            num2 = sc.nextInt();
            res= num1 / num2;
        }catch (InputMismatchException | ArithmeticException e){
            System.err.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int resCalculo=calculoNUms(sc);
        System.out.println("Resultado: "+resCalculo);
        sc.close();
    }
}