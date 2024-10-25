package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Haz un programa que encuentre e imprima por consola los 20 primeros
números primos*/
public class Tema2Ejercicio27 {
    public static void main(String[] args) {
        boolean esPrimo;
        int num=2,count=0;
        while (count<20){
            esPrimo=true;
            //Utiliza la raiz cuadrado para verificar los numero primos, seria lo mismo que dividir todos los numeros entre 2 y num - 1
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num%i==0){
                    esPrimo=false;
                }
            }
            if (esPrimo==true){
                System.out.println("El numero primo es "+num);
                count++;
            }
            num++;
        }
    }
}
