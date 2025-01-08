package Tema3.Arrays;

import java.util.Random;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*  Realiza el juego “Buscar parejas”. Hay un array de 20 elementos (no visible
 por el jugador en un principio) con 10 parejas ubicadas aleatoriamente de
 animales (o lo que prefieras): león, mandril, suricata, facóquero… El jugador
 seleccionará dos posiciones, si son iguales se quedarán visibles para el resto
 del juego, si son diferentes se muestran al jugador y se ocultan (por ejemplo
 imprimiendo muchos saltos de línea). El jugador seguirá seleccionando pares
 de posiciones hasta que todas las parejas estén visibles.
 Pista: necesitarás un array con las parejas y un array con las posiciones
 visibles*/
public class Ejercicio5 {
    //Muestra el tablero por terminal al usuario
    public static void mostrarTablero(String[] tablero, boolean[] visible) {
        for (int i = 0; i < tablero.length; i++) {
            if (visible[i]) {
                System.out.print("[" + tablero[i] + "] ");
            } else {
                System.out.print("[?]");
            }
        }
        System.out.println();
    }

    // Método que valida las posiciones
    public static boolean validarPosiciones(int posicion1, int posicion2, boolean[] visible) {
        boolean res=true;
        if (posicion1 < 0 || posicion1 >= 20 || posicion2 < 0 || posicion2 >= 20) {
            System.out.println("Una o ambas posiciones están fuera de rango. Intenta nuevamente.");
            res= false;
        }
        if (visible[posicion1] || visible[posicion2]) {
            System.out.println("Una o ambas posiciones ya están descubiertas. Intenta nuevamente.");
            res= false;
        }
        if (posicion1 == posicion2) {
            System.out.println("No puedes seleccionar la misma posición dos veces. Intenta de nuevo.");
            res= false;
        }
        return res;
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] animales = {"leon", "mandril", "suricata", "facoquero", "elefante", "jirafa", "cebra", "hipopotamo", "tigre", "oso"};
        String[] tablero = new String[20];
        //Indica si una posicion es visible
        boolean[] visible = new boolean[20];
        int randomInd, posicion1, posicion2, parejasEncontradas = 0;
        String temporal;
        boolean bucleJuego = true;

        //Inicializa el tablero con las parejas duplicadas
        for (int i = 0; i < 10; i++) {
            tablero[i] = animales[i];
            tablero[i + 10] = animales[i];
        }

        //Mezclo el tablero aleatoriamente
        for (int i = 0; i < tablero.length; i++) {
            randomInd = random.nextInt(20);
            //Utilizo la variable temporal para intercambiar dos elemetos del array tablero
            temporal = tablero[i];
            tablero[i] = tablero[randomInd];
            tablero[randomInd] = temporal;
        }

        while (bucleJuego) {
            mostrarTablero(tablero, visible);
            //Validar si las posiciones son iguales
            do {
                System.out.println("Selecciona la primera posición (1-20): ");
                posicion1 = sc.nextInt() - 1;
                System.out.println("Selecciona la segunda posición (1-20): ");
                posicion2 = sc.nextInt() - 1;
            } while (!validarPosiciones(posicion1, posicion2, visible));

            System.out.println("Has seleccionado:");
            System.out.println("Posición " + (posicion1 + 1) + ": " + tablero[posicion1]);
            System.out.println("Posición " + (posicion2 + 1) + ": " + tablero[posicion2]);

            // Verificar si las selecciones forman una pareja
            if (tablero[posicion1].equals(tablero[posicion2])) {
                System.out.println("¡Pareja encontrada!");
                visible[posicion1] = true;
                visible[posicion2] = true;
                parejasEncontradas++;
            } else {
                System.out.println("No es una pareja. Intenta de nuevo.");
            }

            // Verificar si todas las parejas han sido encontradas
            if (parejasEncontradas == 10) {
                bucleJuego = true;
            }
        }
        System.out.println("¡Felicidades! Has encontrado todas las parejas.");
        mostrarTablero(tablero, visible);
        sc.close();
    }
}
