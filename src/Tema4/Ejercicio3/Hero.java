package Tema4.Ejercicio3;

import java.util.Random;

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
    private int level,health,maxHealth,experience,attack,defense;

    //Atributos statci final para eveitar los magics numbers
    public static final int MAX_ATRIBUTE_LIMIT = 200;
    public static final int MIN_NUMBER_ATRIBUTE_LIMIT = 1;
    public static final int MIN_NUMBER_LIMIT = 0;
    private static final String DEFAULT_NAME = "HERO DOE";
    private static final int DEFAULT_ATTACK = 40;
    private static final int DEFAULT_DEFENSE = 40;
    private static final int DEFAULT_HEALTH = 40;
    private static final int DEFAULT_LEVEL = 1;
    private static final int POTION_HEAL = 10;
    private static final int REST_HEAL = 50;
    private static final int LEVEL_UP_HEALTH = 5;
    private static final int LEVEL_UP_ATTACK = 1;
    private static final int LEVEL_UP_DEFENSE = 1;
    private static final int ATTACK_EXPERIENCE = 10;
    private static final int MAX_EXPERIENCE = 50;
    private static final int MAX_LEVEL=120;
    private static final int MIN_DAMAGE = 10;

    public Hero() {
        this.name = DEFAULT_NAME;
        this.attack=DEFAULT_ATTACK;
        this.level=DEFAULT_LEVEL;
        this.defense=DEFAULT_DEFENSE;
        this.experience = 0;
        this.maxHealth = Math.min(DEFAULT_HEALTH, MAX_ATRIBUTE_LIMIT);
        this.health = this.maxHealth;
    }

    public Hero(String name, int health, int attack, int defense) {
        setName(name);
        setAttack(attack);
        setDefense(defense);
        this.maxHealth = Math.min(health, MAX_ATRIBUTE_LIMIT);
        setHealth(health);
        this.level=DEFAULT_LEVEL;
        this.experience=0;
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
        this.health = Math.max(MIN_NUMBER_LIMIT,Math.min(health,this.maxHealth));
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = Math.max(MIN_NUMBER_LIMIT,Math.min(attack,MAX_ATRIBUTE_LIMIT));
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = Math.max(MIN_NUMBER_LIMIT,Math.min(defense,MAX_ATRIBUTE_LIMIT));
    }

    public int drinkPotion() {
        int res;
        this.health = Math.min(this.health + POTION_HEAL, this.maxHealth);
        res = this.health;
        //System.out.println(this.name + " tomo una pocion. Salud actual: " + this.health);
        return res;
    }

    public int rest() {
        int res;
        this.health = Math.min(this.health + REST_HEAL, this.maxHealth);
        //System.out.println(this.name + " descanso. Salud actual: " + this.health);
        res = this.health;
        return res;
    }

    public int attack(Hero otroHero) {
        Random rand=new Random();

        // Calcular el hit causado al otroHero
        int hit = Math.max(getAttack() - otroHero.getDefense(), MIN_DAMAGE);
        int damage=rand.nextInt(hit)+1;

        otroHero.setHealth(otroHero.getHealth() - damage);

        // Add experiencia al atacante
        this.experience += ATTACK_EXPERIENCE;

        // Subir de nivel si acumula 50 o mas de experiencia
        if (this.experience >= MAX_EXPERIENCE) {
            String level = levelUp();
            System.out.println(level);
        }

        // Imprimir los detalles del ataque
        /*System.out.println(this.name + " ataco a " + otroHero.getName() + " causando " + hit + " de hit.");
        System.out.println(otroHero.getName() + " ahora tiene " + otroHero.getHealth() + " de salud.");*/
        return damage;

    }

    // Método para subir de nivel
    public String levelUp() {

        if (this.level >= MAX_LEVEL) {
            return this.name + " ya ha alcanzado el nivel maximo "+MAX_LEVEL;
        }

        this.level++;
        this.maxHealth = Math.min(this.maxHealth + LEVEL_UP_HEALTH, MAX_ATRIBUTE_LIMIT);
        this.attack += LEVEL_UP_ATTACK;
        this.defense += LEVEL_UP_DEFENSE;
        this.health = this.maxHealth;
        this.experience = 0;
        return this.name + " subio al nivel " + this.level + "!" + "Nueva salud maxima: " + this.maxHealth + ", Ataque: " + this.attack + ", Defensa: " + this.defense;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", health=" + health +
                ", maxHealth="+maxHealth+
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}
