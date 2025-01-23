package Tema4.Ejercicio3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Crea una clase Hero para representar un personaje de un juego de Rol.
Están prohibidos los “magic numbers”.
El personaje tendrá los siguientes atributos:
- name(String): El nombre del héroe.
- level (int): El nivel del héroe.
- health (int): La cantidad actual de salud del héroe.
- maxHealth (int): La cantidad máxima de salud del héroe.
- experience (int): La cantidad de experiencia acumulada por el héroe.
- attack(int): El valor de ataque del héroe.
- defense (int): El valor de defensa del héroe.
Y los siguientes métodos:
- Constructor o constructores.
- drinkPotion(), le suma 10 puntos a la salud.
- rest(), le suma 50 puntos a la salud.
- toString(), devuelve una cadena con la información del héroe.
- attack(), recibe como parámetro otro héroe y le quitará vida entre 1 y
Max(ataqueDel Atacante - defensaDelAtacado, 10). Cada ataque le suma 10
de experiencia al personaje. Tras acumular 50 de experiencia sube un nivel.
- levelUp(), sube un nivel al personaje: sumándole 5 puntos a la salud, 1 punto
al ataque y un punto a la defensa.
Haz un programa principal dónde se utilice la clase anterior y todos los
métodos.*/
public class Hero {
    private String name;
    private int level,health,experience,attack,defense;
    private final int MAX_HEALTH=200;
    public static final int SUMA_HEALTH=10;
    public static final int SUMA_REAST_HEALTH=10;
    public static final int SUMA_EXPERIENCIA=10;
    public static final String DEFAULT_NAME="HERO DOE";
    public static final int DEFAULT_ATTACK=100;
    public static final int DEFAULT_DEFENSE=100;
    public static final int DEFAULT_HEALTH=100;
    public static final int DEFAULT_LEVEL=1;

    public Hero() {
        this.name = DEFAULT_NAME;
        this.attack=DEFAULT_ATTACK;
        this.level=DEFAULT_LEVEL;
        this.defense=DEFAULT_DEFENSE;
        this.health=DEFAULT_HEALTH;
    }

    public Hero(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int drinHealth(){
        int res;
        res=this.health+SUMA_HEALTH;
        return res;
    }

    public int rest(){
        int res;
        res=this.health+SUMA_REAST_HEALTH;
        return res;
    }

    public int attack(Hero otroHero){
        int hit=1+Math.max(this.attack-otroHero.getDefense(),10);
        return otroHero.getHealth()-hit;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}
