package Tema3.Arrays;

import java.util.Random;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
*  Realiza el juego “Buscaminas” en un array. Hay un array de 20 elementos
 (no visible por el jugador en un principio) con 6 minas ubicadas
 aleatoriamente. A continuación se rellena el resto de las casillas del array con
 las pistas: 1 si tiene una mina alrededor, 2 si tiene dos y 0 si no tiene ninguna.
 Por ejemplo:
 0 1 * * * 2 * 0 0 0 0 0 1 * 1 0 0 0 1 *
 El jugador selecciona una posición. Si hay una mina, pierde la partida. Si hay
 un número se muestra dicha posición. Si se muestra todo el tablero menos las
 minas el jugador gana la partida*/
public class Ejercicio6 {

    public static void mostrarTableroConMinas(String[] tablero, boolean[] visible) {
        for (int i = 0; i < tablero.length; i++) {
            if (visible[i]) {
                System.out.print("[" + tablero[i] + "] ");
            } else {
                if (tablero[i].equals("*")) { // Muestra las minas aunque no sean visibles
                    System.out.print("[*] ");
                } else {
                    System.out.print("[?] ");
                }
            }
        }
        System.out.println();
    }

    public static boolean validarPosicion(int posicion) {
        boolean res=true;
        if(posicion < 0 || posicion >= 20){
            System.out.println("Posicion fuera de rango. Intentalo de nuevo.");
            res= false;
        }
        return res;
    }

    public static void initTablero(String[] tablero, boolean[] minas) {
        Random random = new Random();
        int minasColocadas = 0;
        int index,minasAlrededor;
        // Coloca las minas aleatoriamente
        while (minasColocadas < 6) {
            index = random.nextInt(20);
            if (!minas[index]) {
                minas[index] = true;
                tablero[index] = "*";
                minasColocadas++;
            }
        }

        // Calculo las pistas en el tablero
        for (int i = 0; i < tablero.length; i++) {
            if (!minas[i]) {
                minasAlrededor = 0;
                // Verifico la casilla izquierda
                if (i - 1 >= 0 && minas[i - 1]) {
                    minasAlrededor++;
                }
                // Verifico casilla derecha
                if (i + 1 < tablero.length && minas[i + 1]) {
                    minasAlrededor++;
                }

                // Asigno el valor correspondiente con String.valueOf,
                // convierto minasAlrededor en una cadena de texto legible para que no me salga [I@15db
                tablero[i] = String.valueOf(minasAlrededor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] tablero=new String[20];
        boolean[] visible=new boolean[20];
        boolean[] minas=new boolean[20];
        int casillaDescubierta=0,posicion;
        boolean bucleJuego=true;

        initTablero(tablero,minas);

        while (bucleJuego){
            //Comprobar en forma de depuracion
            //mostrarTableroConMinas(tablero,visible);
            do {
                System.out.println("Selecciona una poscion entre(1-20): ");
                posicion=sc.nextInt()-1;
            }while (!validarPosicion(posicion));

            if (minas[posicion]){
                System.out.println("¡Has pisado una mina!");
                bucleJuego=false;
            }else {
                visible[posicion]=true;
                casillaDescubierta++;
            }

            if (casillaDescubierta==14){
                System.out.println("¡Felicidades, Has ganado!");
                bucleJuego=false;
            }

        }
        // Muestra el tablero final con todas las minas visibles
        for (int i = 0; i < tablero.length; i++) {
            visible[i] = true;
        }
        Ejercicio5.mostrarTablero(tablero,visible);
        System.out.println("Fin del juego");
        sc.close();
    }
}
