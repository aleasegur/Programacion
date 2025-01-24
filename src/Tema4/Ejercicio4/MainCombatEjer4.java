package Tema4.Ejercicio4;
import Tema4.Ejercicio3.Hero;
import Tema4.Ejercicio3.Mainejer3;

import java.util.Random;
import java.util.Scanner;

public class MainCombatEjer4 {
    public static boolean enemigosVivos(Hero[] enemigos) {
        for (Hero enemigo : enemigos) {
            if (enemigo != null && enemigo.getHealth() > 0) {
                return true; // Si encuentra al menos un enemigo vivo, retorna true
            }
        }
        return false; // Si no hay enemigos vivos, retorna false
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int ataque1, ataque2, ronda = 1;
        Hero hero = Mainejer3.crearHeroe(sc);

        while (hero.getHealth() > 0) {
            int numEnemigos = rand.nextInt(3) + 1;
            Hero[] enemigos = new Hero[numEnemigos];

            // Crear enemigos
            for (int i = 0; i < numEnemigos; i++) {
                enemigos[i] = new Hero("Enemigo " + (i + 1), rand.nextInt(50) + 50,
                        rand.nextInt(15) + 5,
                        rand.nextInt(10) + 5);
            }

            System.out.println("Horda " + ronda + " con " + numEnemigos + " enemigos aparece!");

            // Combate con la horda
            while (hero.getHealth() > 0 && enemigosVivos(enemigos)) {
                // Ataques del héroe
                for (int i = 0; i < enemigos.length; i++) {
                    if (enemigos[i] != null && enemigos[i].getHealth() > 0) {
                        ataque1 = hero.attack(enemigos[i]);
                        System.out.println(hero.getName() + " atacó a " + enemigos[i].getName() + " causando " + ataque1 + " de daño");

                        if (enemigos[i].getHealth() <= 0) {
                            System.out.println(enemigos[i].getName() + " ha sido derrotado!");
                            enemigos[i] = null; // El enemigo es eliminado
                        } else if (rand.nextInt(100) < 10) {
                            System.out.println(enemigos[i].getName() + " huyó de la pelea!");
                            enemigos[i] = null; // El enemigo huye
                        }
                    }
                }

                // Ataques de los enemigos
                for (Hero enemigo : enemigos) {
                    if (enemigo != null && enemigo.getHealth() > 0) {
                        ataque2 = enemigo.attack(hero);
                        System.out.println(enemigo.getName() + " atacó a " + hero.getName() + " causando " + ataque2 + " de daño");

                        if (hero.getHealth() <= Hero.MIN_NUMBER_LIMIT) {
                            System.out.println(hero.getName() + " ha sido derrotado");
                            break; // Salir del combate si el héroe muere
                        }
                    }
                }
            }

            // Fin de la horda
            if (hero.getHealth() > 0) {
                ronda++;
                System.out.println("Has sobrevivido a la horda " + ronda);

                // Probabilidad de descansar o encontrar una poción
                if (rand.nextInt(1000) < 1) {
                    int descansar = hero.rest();
                    System.out.println(hero.getName() + " ha descansado y recuperado " + descansar + " de vida");
                }

                if (rand.nextInt(100) < 1) {
                    int pocion = hero.drinkPotion();
                    System.out.println(hero.getName() + " ha encontrado una poción y recupera " + pocion + " de vida");
                }
            }
        }

        System.out.println(hero.getName() + " ha sobrevivido este número de rondas: " + ronda);
    }
}
