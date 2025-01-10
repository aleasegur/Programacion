package JuegoSimulacionDeCombate;

import java.util.Random;
import java.util.Scanner;

public class MethodsCombats {
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
    public static boolean areValidPLayerStats(int vida, int ataque, int defensa, int velocidad) {
        boolean res=true;
        if (vida + ataque + defensa + velocidad > 500) {
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
}
