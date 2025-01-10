package JuegoSimulacionDeCombate;

import java.util.Random;
import java.util.Scanner;

// ALEJANDRO ASENCIO GURAU
public class Main {
    //Lee los atributos del jugador
    public static int readPlayerStats(Scanner sc, String atributo, int min, int max) {
        int valor;
        do {
            System.out.print("Ingrese el valor para " + atributo + " (" + min + "-" + max + "): ");
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Valor fuera de rango. Intente nuevamente.");
            }
        } while (valor < min || valor > max);
        return valor;
    }
    //Valida si la suma de los atributos no es mayor a 500
    public static boolean areValidPLayerStats(int vida, int ataque, int defensa, int velocidad,int sumMaxStats) {
        boolean res=true;
        if (vida + ataque + defensa + velocidad > sumMaxStats) {
            System.out.println("La suma de los atributos no puede exceder 500. Reinicie el programa.");
            res=false;
        }
        return res;
    }

    public static int makeTurn(Scanner sc, Random rand, String jugador, int ataque, int defensa, int vidaOponente) {
        System.out.println(jugador + ", elige tu acción: (A) Atacar, (C) Curar");
        char accion = sc.next().toUpperCase().charAt(0);
        switch (accion) {
            case 'A':
                int hit = calculateDamage(rand, ataque, defensa);
                vidaOponente = Math.max(0, vidaOponente - hit);
                System.out.println(jugador + " realiza un ataque causando " + hit + " puntos de hit.");
                break;
            case 'C':
                vidaOponente = Math.min(200, vidaOponente + 20);
                System.out.println(jugador + " usa un estimulante y ahora tiene " + vidaOponente + " puntos de vida.");
                break;
            default:
                System.out.println("Acción no válida. Pierdes tu turno.");
                break;
        }
        return vidaOponente;
    }

    //Calcula el daño que Realiza el Jugador
    public static int calculateDamage(Random rand, int ataque, int defensa) {
        int hit = Math.max(5, ataque - defensa / 2 + rand.nextInt(10));
        //Realiza ataque critico
        if (rand.nextInt(100) < 20) {
            hit *= 2;
            System.out.println("¡Ataque crítico!");
        }
        return hit;
    }

    //MUestra y actualiza la barra de vida
    public static void updateLife(String jugador, int vida) {
        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < vida / 10; i++) {
            barra.append("-");
        }
        System.out.println(jugador + " Vida: " + vida + " " + barra);
    }

    public static void starCombat(Scanner sc, Random rand, int vida1, int ataque1, int defensa1, int velocidad1, int vida2, int ataque2, int defensa2, int velocidad2) {
        int ronda = 1;
        while (vida1 > 0 && vida2 > 0) {
            System.out.println("\n************************************");
            System.out.println("RONDA " + ronda);
            updateLife("Jugador 1", vida1);
            updateLife("Jugador 2", vida2);

            if (velocidad1 >= velocidad2) {
                vida2 = makeTurn(sc, rand, "Jugador 1", ataque1, defensa2, vida2);
                if (vida2 > 0) {
                    vida1 = makeTurn(sc, rand, "Jugador 2", ataque2, defensa1, vida1);
                }
            } else {
                vida1 = makeTurn(sc, rand, "Jugador 2", ataque2, defensa1, vida1);
                if (vida1 > 0) {
                    vida2 = makeTurn(sc, rand, "Jugador 1", ataque1, defensa2, vida2);
                }
            }

            ronda++;
        }
        if (vida1 > 0) {
            System.out.println("\n¡Jugador 1 GANA!");
        } else {
            System.out.println("\n¡Jugador 2 GANA!");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        //Variables final que son el minimo y maximo de estadisticas y tambien su suma
        final int min=1,max=200,sumMaxStats=500;

        // Variables para jugadores
        int vida1, ataque1, defensa1, velocidad1;
        int vida2, ataque2, defensa2, velocidad2;

        boolean comprobarStats1,comprobarStats2;

        // Configurar personajes
        System.out.println("¿Desea usar personajes predefinidos? (Y/N):");
        char usarPredefinidos = sc.next().toUpperCase().charAt(0);
        if (usarPredefinidos == 'Y') {
            vida1 = 100; ataque1 = 100; defensa1 = 50; velocidad1 = 120;
            vida2 = 100; ataque2 = 90; defensa2 = 60; velocidad2 = 110;
        } else {

            do {
                System.out.println("Configuración Jugador 1:");
                vida1 = readPlayerStats(sc, "Vida", min, max);
                ataque1 = readPlayerStats(sc, "Ataque", min, max);
                defensa1 = readPlayerStats(sc, "Defensa", min, max);
                velocidad1 = readPlayerStats(sc, "Velocidad", min, max);
                comprobarStats1 = areValidPLayerStats(vida1, ataque1, defensa1, velocidad1,sumMaxStats);
            }while (!comprobarStats1);

            do {
                System.out.println("Configuración Jugador 2:");
                vida2 = readPlayerStats(sc, "Vida", min, max);
                ataque2 = readPlayerStats(sc, "Ataque", min, max);
                defensa2 = readPlayerStats(sc, "Defensa", min, max);
                velocidad2 = readPlayerStats(sc, "Velocidad", min, max);
                comprobarStats2 = areValidPLayerStats(vida2, ataque2, defensa2, velocidad2,sumMaxStats);
            }while (!comprobarStats2);
        }

        // Iniciar combate
        starCombat(sc, rand, vida1, ataque1, defensa1, velocidad1, vida2, ataque2, defensa2, velocidad2);
        sc.close();
    }
}
