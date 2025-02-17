package Tema5.Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Implementa un programa que pida al usuario un valor entero num utilizando
un nextInt( ) (de Scanner) y luego muestre por pantalla el mensaje “Valor
introducido: ...”. Se deberá tratar la excepción InputMismatchException que
lanza nextInt( ) cuando no se introduce un entero válido. En tal caso se mostrará
el mensaje “Valor introducido incorrecto”*/
public class Ejercicio1 {

    public static int introducirNumero(Scanner sc){
        int num=0;
        try {
            System.out.println("Introduce un numero entero: ");
            num = sc.nextInt();
        }catch (InputMismatchException iE){
            System.err.println("Valor introducido incorrecto");
            iE.printStackTrace();
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int resultNum=introducirNumero(sc);
        System.out.println("Valor introducido: "+resultNum);
        sc.close();
    }
}
