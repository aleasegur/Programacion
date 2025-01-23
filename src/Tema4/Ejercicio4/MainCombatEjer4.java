package Tema4.Ejercicio4;
import Tema4.Ejercicio3.Hero;
public class MainCombatEjer4 {
    public static void main(String[] args) {
        Hero hero=new Hero();
        Hero hero2=new Hero();
        Hero[] enemigos=new Hero[]{hero,hero2};
        for (Hero enemigo : enemigos) {
            System.out.println(enemigo);
        }
    }
}
