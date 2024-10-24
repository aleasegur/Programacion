package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*Realiza un programa que si lee por consola ‘D’ convierte euros a dolares
la cantidad introducida y si lee por consola ‘E’ convierte dolares a
euros.*/
public class Tema2Ejercicio16 {
    public static void main(String[] args) {
        char letra;
        double num,euros=0.92,dolar=1.09;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la cantidad de dinero: ");
        num= sc.nextDouble();
        System.out.println("---CONVERSOR---"+"\nIntroduce una letra para la conversion: "+"\n-D.Euros a Dolares "+"\n-E.Dolares a euros");
        letra=sc.next().charAt(0);
        switch (letra){
            case 'D':
                num*=dolar;
                System.out.println("Dolares = "+num);
                break;
            case 'E':
                num*=euros;
                System.out.println("Euros = "+num);
                break;
            default:
                System.err.println("ERROR: VALOR ERRONEO");
        }
        sc.close();
    }
}
