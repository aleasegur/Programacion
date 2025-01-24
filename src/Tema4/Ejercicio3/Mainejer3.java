package Tema4.Ejercicio3;

import java.util.Scanner;

public class Mainejer3 {

    public static boolean comporbarValAtrib(int atributo,int max,int min){
        boolean res=true;
        if (atributo < min || atributo > max) {
            System.err.println("Valor fuera de rango. Intente nuevamente.");
            res=false;
        }
        return res;
    }

    public static int crearAtributo(Scanner sc,String atributo){
        int res=0;
        int minAtr=Hero.MIN_NUMBER_ATRIBUTE_LIMIT;
        int maxAtr=Hero.MAX_ATRIBUTE_LIMIT;
        do {
            System.out.println("Ingrese el valor para " + atributo + " (" + minAtr + "-" + maxAtr + "): ");
            res = sc.nextInt();
        } while (!comporbarValAtrib(res,maxAtr,minAtr));
        return res;
    }

    public static Hero crearHeroe(Scanner sc){
        String name;
        int health,attack,defense;
        System.out.println("Introduce un nombre para tu heroe: ");
        name=sc.next();
        health=crearAtributo(sc,"Health");
        attack=crearAtributo(sc,"Attack");
        defense=crearAtributo(sc,"Defense");
        return new Hero(name,health,attack,defense);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("---Creacion  del primer heroe---");
        Hero heroe1=crearHeroe(sc);
        System.out.println("---Creacion del segundo heroe---");
        Hero heroe2=crearHeroe(sc);

        System.out.println("///HEROES INICIALES\\\\\\");
        System.out.println(heroe1);
        System.out.println(heroe2);

        System.out.println("\n///COMBATE\\\\\\");
        int attack1 = heroe1.attack(heroe2);
        int attack2 = heroe2.attack(heroe1);
        System.out.println(heroe1.getName() + " ataco a " +heroe2.getName() + " causando " + attack1 + " de hit.");
        System.out.println(heroe2.getName() + " ataco a " + heroe1.getName() + " causando " + attack2 + " de hit.");

        System.out.println("\n///POCION\\\\\\");
        int potion1 = heroe1.drinkPotion();
        int potion2 = heroe2.drinkPotion();
        System.out.println(heroe1.getName() + " tomo una pocion. Salud actual: " + potion1);
        System.out.println(heroe2.getName() + " tomo una pocion. Salud actual: " + potion2);

        System.out.println("\n///DESCANSO\\\\\\");
        int rest1 = heroe1.rest();
        int rest2 = heroe2.rest();
        System.out.println(heroe1.getName() + " descanso. Salud actual: " + rest1);
        System.out.println(heroe2.getName() + " descanso. Salud actual: " + rest2);

        System.out.println("\n///ATAQUES REPITIDOS SUBIR DE NIVEL\\\\\\");
        for (int i = 0; i < 5; i++) {
            int multAttack=heroe1.attack(heroe2);
            System.out.println(heroe1.getName() + " ataco a " +heroe2.getName() + " causando " + multAttack + " de hit.");
        }

        System.out.println("\n///INFORMACION FINAL\\\\\\");
        System.out.println(heroe1);
        System.out.println(heroe2);

    }
}
