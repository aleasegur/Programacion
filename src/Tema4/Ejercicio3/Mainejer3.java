package Tema4.Ejercicio3;

public class Mainejer3 {



    public static void main(String[] args) {
        Hero heroe1=new Hero("Guerrero",80,100,100);
        Hero heroe2=new Hero("Picaro",60,145,75);

        System.out.println("///HEROES INICIALES\\\\\\");
        System.out.println(heroe1);
        System.out.println(heroe2);

        System.out.println("\n///COMBATE\\\\\\");
        heroe1.attack(heroe2);
        heroe2.attack(heroe1);

        System.out.println("\n///POCION\\\\\\");
        heroe1.drinkPotion();
        heroe2.drinkPotion();

        System.out.println("\n///DESCANSO\\\\\\");
        heroe1.rest();
        heroe2.rest();

        System.out.println("\n///ATAQUES REPITIDOS SUBIR DE NIVEL\\\\\\");
        for (int i = 0; i < 6; i++) {
            heroe1.attack(heroe2);
        }

        System.out.println("\n///INFORMACION FINAL\\\\\\");
        System.out.println(heroe1);
        System.out.println(heroe2);

    }
}
