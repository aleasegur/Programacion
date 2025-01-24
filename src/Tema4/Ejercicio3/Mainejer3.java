package Tema4.Ejercicio3;

public class Mainejer3 {



    public static void main(String[] args) {
        Hero heroe1=new Hero("Guerrero",300,300,300);
        Hero heroe2=new Hero("Picaro",300,300,300);

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
