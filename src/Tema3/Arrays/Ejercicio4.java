package Tema3.Arrays;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Vamos a hacer un programa que permita hacer simulaciones de cobertura
 wifi para hoteles. Le pediremos al usuario que seleccione un número de
 habitación (1-20) donde instalar el router y una potencia de transmisión del
 router (1-6). La señal se pierde en cada paso de habitación y vamos a
 representarlo en el array. Si ponemos un router de potencia 4 en la habitación
 10 el resultado sería el siguiente array:*/
public class Ejercicio4 {
    public static void mostrarVector(int[] vector){
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] vectorHabitaciones=new int[20];
        int routerHabitacion,potencia,distancia;
        do {
            System.out.println("Selecciona la habitacion para instalar el routerHabitacion(1-20): ");
            routerHabitacion=sc.nextInt()-1;
            if (routerHabitacion<1 || routerHabitacion>=20){
                System.err.println("Selecciona una habitacon valida entre 1 y 20");
            }
        }while (routerHabitacion<1 || routerHabitacion>=20);

        do {
            System.out.println("Selecciona la potencia del routerHabitacion(1-6): ");
            potencia=sc.nextInt();
            if (potencia<1 || potencia>=6){
                System.err.println("Selecciona una potencia valida entre 1 y 6");
            }
        }while (potencia<1 || potencia>=6);

        for (int i = 0; i < vectorHabitaciones.length; i++) {
            //Distanci entre la habitacion y el router
            distancia=Math.abs(routerHabitacion-i);
            //Señal que disminuye con la distancia
            if (distancia<potencia){
                vectorHabitaciones[i]=potencia-distancia;
            }else {
                vectorHabitaciones[i]=0;
            }
        }

        System.out.println("Distribucion de la señal WIFI: ");
        mostrarVector(vectorHabitaciones);
        sc.close();
    }
}
