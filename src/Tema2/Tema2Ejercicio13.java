package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*Realiza un programa que lea por consola una hora (horas, minutos,
 segundos), y muestra por consola la hora con un segundo más. */
public class Tema2Ejercicio13 {
    public static void main(String[] args) {
        int horas,min,seg;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce las horas: ");
        horas=sc.nextInt();
        System.out.println("Introduce los minutos: ");
        min=sc.nextInt();
        System.out.println("Introduce los segundos: ");
        seg=sc.nextInt();

        //suma segundos
        seg++;

        if (seg>=60){
            seg=0;
            min++;
        }

        if (min>=60){
            min=0;
            horas++;
        }

        if (horas>=24){
            horas=0;
        }

        System.out.println("La hora con un segundo más es "+horas+":"+min+":"+seg);
        sc.close();
    }
}
