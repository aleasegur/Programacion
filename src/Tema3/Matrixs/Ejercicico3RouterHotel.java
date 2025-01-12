package Tema3.Matrixs;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/*  ALEJANDRO ASENCIO GURAU
*  Realiza de nuevo el simulador de la cobertura pero ahora una matriz
 representará el hotel. Cada fila será una planta del hotel y cada celda una
 habitación. Le pediremos al usuario las coordenadas de la habitación donde
 se instalará el router (x,y), siendo “x” (1-12) la planta, siendo “y” la habitación
 (1-5) dentro de dicha planta. También le pediremos la potencia del router. La
 señal se pierde con la distancia y vamos a representarlo en el array. Si
 ponemos un router de potencia 3. Lo vamos a instalar en la planta 2,
 habitación 3 (2,3). El resultado será la siguiente matriz:
 Fíjate que en las habitaciones en diagonal, como están un poco más lejos que
 las habitaciones directamente superior, inferior, izquierda y derecha, llega
 menos cobertura*/
public class Ejercicico3RouterHotel {
    public static void mostrarMatrix(int[][] matriz){
        for (int[] fila : matriz){
            System.out.println(Arrays.toString(fila));
        }
    }

    public static boolean comprobarPlanta(int posicion){
        boolean res=true;
        if (posicion < 0 || posicion >= 12) {
            System.err.println("Selecciona una planta válida entre 1 y 12");
            res=false;
        }
        return res;
    }

    public static boolean comprobarHabitacion(int posicion){
        boolean res=true;
        if (posicion < 0 || posicion >= 5) {
            System.err.println("Selecciona una habitación válida entre 1 y 5");
            res= false;
        }
        return res;
    }

    public static boolean comprobarPotencia(int potencia){
        boolean res=true;
        if (potencia<1 || potencia>6) {
            System.err.println("Selecciona una potencia válida entre 1 y 6.");
            res=false;
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] matrizHotel=new int[12][5];
        int routerX,routerY,potencia,distancia;

        do {
            System.out.println("Selecciona la planta para instalar el router (1-12): ");
            routerX = sc.nextInt() - 1;
        } while (!comprobarPlanta(routerX));

        do {
            System.out.println("Selecciona la habitación para instalar el router (1-5): ");
            routerY = sc.nextInt() - 1;
        } while (!comprobarHabitacion(routerY));

        do {
            System.out.println("Selecciona la potencia del router (1-6): ");
            potencia = sc.nextInt();
        } while (!comprobarPotencia(potencia));

        for (int i = 0; i < matrizHotel.length; i++) {
            for (int j = 0; j < matrizHotel[i].length; j++) {
                distancia = Math.abs(routerX - i) + Math.abs(routerY - j);
                if (distancia<potencia){
                    matrizHotel[i][j]=potencia-distancia;
                }else {
                    matrizHotel[i][j]=0;
                }
            }
        }

        System.out.println("Distribucion de la señal WIFI: ");
        mostrarMatrix(matrizHotel);
        sc.close();
    }

}
