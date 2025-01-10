package JuegoSimulacionDeCombate;

import java.util.Random;
import java.util.Scanner;

// ALEJANDRO ASENCIO GURAU
public class Main {

    public static void startCombat(Scanner sc, Random rand, int vida1, int ataque1, int defensa1, int velocidad1, int vida2, int ataque2, int defensa2, int velocidad2) {
        int ronda = 1;
        while (vida1 > 0 && vida2 > 0) {
            System.out.println("\n************************************");
            System.out.println("RONDA " + ronda);
            MethodsCombats.updateLife("Jugador 1", vida1);
            MethodsCombats.updateLife("Jugador 2", vida2);

            if (velocidad1 >= velocidad2) {
                vida2 = MethodsCombats.makeTurn(sc, rand, "Jugador 1", ataque1, defensa2, vida2);
                if (vida2 > 0) {
                    vida1 = MethodsCombats.makeTurn(sc, rand, "Jugador 2", ataque2, defensa1, vida1);
                }
            } else {
                vida1 = MethodsCombats.makeTurn(sc, rand, "Jugador 2", ataque2, defensa1, vida1);
                if (vida1 > 0) {
                    vida2 = MethodsCombats.makeTurn(sc, rand, "Jugador 1", ataque1, defensa2, vida2);
                }
            }

            ronda++;
        }
        if (vida1 > 0) {
            System.out.println("¡Jugador 1 GANA!");
        } else {
            System.out.println("¡Jugador 2 GANA!");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        //Variables final que son el minimo y maximo de estadisticas y tambien su suma
        final int min=1,max=200,sumMaxStats=500;

        // Variables para jugadores
        int vida1=0, ataque1=0, defensa1=0, velocidad1=0;
        int vida2=0, ataque2=0, defensa2=0, velocidad2=0;

        boolean comprobarStats1,comprobarStats2;

        char accionJugador;

        // Configurar personajes
        do {
            System.out.println("¿Desea usar personajes predefinidos? (Y/N):");
            accionJugador = sc.next().toUpperCase().charAt(0);
            if (accionJugador == 'Y') {
                vida1 = 100;
                ataque1 = 100;
                defensa1 = 50;
                velocidad1 = 120;
                vida2 = 100;
                ataque2 = 90;
                defensa2 = 60;
                velocidad2 = 110;
            } else if (accionJugador == 'N') {

                do {
                    System.out.println("Configuración Jugador 1:");
                    vida1 = MethodsCombats.readPlayerStats(sc, "Vida", min, max);
                    ataque1 = MethodsCombats.readPlayerStats(sc, "Ataque", min, max);
                    defensa1 = MethodsCombats.readPlayerStats(sc, "Defensa", min, max);
                    velocidad1 = MethodsCombats.readPlayerStats(sc, "Velocidad", min, max);
                    comprobarStats1 = MethodsCombats.areValidPLayerStats(vida1, ataque1, defensa1, velocidad1, sumMaxStats);
                } while (!comprobarStats1);

                do {
                    System.out.println("Configuración Jugador 2:");
                    vida2 = MethodsCombats.readPlayerStats(sc, "Vida", min, max);
                    ataque2 = MethodsCombats.readPlayerStats(sc, "Ataque", min, max);
                    defensa2 = MethodsCombats.readPlayerStats(sc, "Defensa", min, max);
                    velocidad2 = MethodsCombats.readPlayerStats(sc, "Velocidad", min, max);
                    comprobarStats2 = MethodsCombats.areValidPLayerStats(vida2, ataque2, defensa2, velocidad2, sumMaxStats);
                } while (!comprobarStats2);

            } else {
                System.out.println("Accion no reconozida, Vuelva a introducirlo");
            }
        }while (accionJugador!='Y' && accionJugador!='N');

        // Iniciar combate
        startCombat(sc, rand, vida1, ataque1, defensa1, velocidad1, vida2, ataque2, defensa2, velocidad2);
        sc.close();
    }
}
