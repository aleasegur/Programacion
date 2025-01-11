package Tema3.Matrixs;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Realiza de nuevo el juego “Atrapa a la mosca”. Pero ahora el tablero de
 juego es una matriz de 4x4, Por. El jugador selecciona una posición entre (1,1)
 y (4,4) si la mosca se encuentra en dicha posición, el jugador ha ganado. Si la
 mosca se encuentra en una posición adyacente, aleatoriamente cambia de
 posición. Si lo mosca no se encuentra en una posición adyacente, no se
 mueve. Recuerda, en una matriz un elemento puede tener hasta 4 posiciones
 adyacentes.*/
public class Ejercicio2AtrapaLaMoscaMatrix {
    public static void initMatrix(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public static boolean comprobarUserInput(int fila, int columna, int filaMax, int columnaMax) {
        return fila < 0 || fila >= filaMax || columna < 0 || columna >= columnaMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int fila = 4, columna = 4;
        int userInputFila, userInputColumna;
        int[][] matrizMosca = new int[fila][columna];
        int filaMosca = random.nextInt(fila), columnaMosca = random.nextInt(columna);
        boolean buclePrincipal = true;

        while (buclePrincipal) {
            initMatrix(matrizMosca);
            matrizMosca[filaMosca][columnaMosca] = 1;
            //Muestra la posicion de la mosca de forma de depuracion
            /*
            for (int[] filas : matrizMosca){
                System.out.println(Arrays.toString(filas));
            }
             */
            do {
                System.out.println("Selecciona una fila entre 1 y " + fila + " y una columna entre 1 y " + columna + ":");
                System.out.print("Fila: ");
                userInputFila = sc.nextInt() - 1;
                System.out.print("Columna: ");
                userInputColumna = sc.nextInt() - 1;
                if (comprobarUserInput(userInputFila, userInputColumna, fila, columna)) {
                    System.err.println("Selecciona una fila y columna válidas dentro del rango!");
                }
            } while (comprobarUserInput(userInputFila, userInputColumna, fila, columna));

            if (filaMosca == userInputFila && columnaMosca == userInputColumna) {
                System.out.println("Felicidades has atrapado la mosca en las posicion " + (userInputFila + 1) + " , " + (userInputColumna + 1));
                buclePrincipal = false;
            } else if (Math.abs(userInputFila - filaMosca) <= 1 && Math.abs(userInputColumna - columnaMosca) <= 1) {
                System.out.println("La mosca estaba cerca, pero se ha movido a una nueva posición.");
                do {
                    filaMosca = random.nextInt(fila);
                    columnaMosca = random.nextInt(columna);
                } while (Math.abs(filaMosca - userInputFila) <= 1 && Math.abs(columnaMosca - userInputColumna) <= 1);
            } else {
                System.out.println("La mosca no está aquí, sigue intentándolo.");
            }
        }
        sc.close();
    }
}
