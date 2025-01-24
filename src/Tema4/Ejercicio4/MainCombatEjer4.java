package Tema4.Ejercicio4;
import Tema4.Ejercicio3.Hero;
import Tema4.Ejercicio3.Mainejer3;

import java.util.Random;
import java.util.Scanner;

public class MainCombatEjer4 {
    public static boolean enemigosVivos(Hero[] enemigos) {
        for (Hero enemigo : enemigos) {
            if (enemigo.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Hero hero = Mainejer3.crearHeroe(sc);
        int ataque1, ataque2, ronda = 1;
        boolean combateHeroe=true;

        while (combateHeroe) {
            int numEnemigos = rand.nextInt(3) + 1;
            Hero[] enemigos = new Hero[numEnemigos];

            // Crear enemigos
            for (int i = 0; i < numEnemigos; i++) {
                enemigos[i] = new Hero("Bandido " + (i + 1), rand.nextInt(50) + 50 +ronda *10,
                        rand.nextInt(15) + 5 +ronda*2,
                        rand.nextInt(10) + 5+ronda*2);
            }

            System.out.println("Horda " + ronda + " con " + numEnemigos + " enemigos aparece!");

            boolean combateHorda=true;

            // Combate con la horda
            while (combateHorda) {
                System.out.println("---BATTLE---");
                // Ataques del heroe
                for (Hero value : enemigos) {
                    if (value.getHealth() > 0) {
                        ataque1 = hero.attack(value);
                        System.out.println(hero.getName() + " atacó a " + value.getName() + " causando " + ataque1 + " de daño");

                        if (value.getHealth() <= 0) {
                            System.out.println("---DEFEAT---");
                            System.out.println(value.getName() + " ha sido derrotado!");

                            //10% de probabilidad de huir de la pelea.
                        } else if (rand.nextInt(100) < 10) {
                            System.out.println("---COWARD---");
                            System.out.println(value.getName() + " huyó de la pelea!");
                        }
                    }
                }

                // Ataque de los enemigos
                for (Hero enemigo : enemigos) {
                    if (enemigo.getHealth() > 0) {
                        ataque2 = enemigo.attack(hero);
                        System.out.println(enemigo.getName() + " atacó a " + hero.getName() + " causando " + ataque2 + " de daño");

                        if (hero.getHealth() <= Hero.MIN_NUMBER_LIMIT) {
                            System.out.println("---WASTED---");
                            System.out.println(hero.getName() + " ha sido derrotado");
                            combateHeroe=false;
                            combateHorda=false;
                        }
                    }
                }
                if (!enemigosVivos(enemigos)){
                    System.out.println("---WIN---");
                    System.out.println("Los enemigos han sido derrotados!");
                    combateHorda=false;
                }
            }


            System.out.println("-------------------------------");

            if (hero.getHealth() > 0) {
                System.out.println("\n"+hero.getName()+" ha sobrevivido a la horda " + ronda);

                // 0.1% de probabilidad de descansar y recuperar vida
                if (rand.nextInt(1000) < 1) {
                    int descansar = hero.rest();
                    System.out.println("---DEFEAT---");System.out.println("---DEFEAT---");
                    System.out.println(hero.getName() + " ha descansado y recuperado " + descansar + " de vida");
                }

                //10 % de probabilidad de encontrar una poción y recuperar vida.
                if (rand.nextInt(100) < 1) {
                    int pocion = hero.drinkPotion();
                    System.out.println("---DRINK---");
                    System.out.println(hero.getName() + " ha encontrado una poción y recupera " + pocion + " de vida");
                }
                ronda++;
            }
        }

        System.out.println(hero.getName() + " ha sobrevivido este número de rondas: " + ronda);
    }
}
