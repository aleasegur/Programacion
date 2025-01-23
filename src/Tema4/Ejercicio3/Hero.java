package Tema4.Ejercicio3;

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
    private static final int MAX_HEALTH_LIMIT = 200;
    public static final String DEFAULT_NAME = "HERO DOE";
    public static final int DEFAULT_ATTACK = 100;
    public static final int DEFAULT_DEFENSE = 100;
    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_LEVEL = 1;
    private static final int POTION_HEAL = 10;
    private static final int REST_HEAL = 50;
    private static final int LEVEL_UP_HEALTH = 5;
    private static final int LEVEL_UP_ATTACK = 1;
    private static final int LEVEL_UP_DEFENSE = 1;
    private static final int ATTACK_EXPERIENCE = 10;
    private static final int MAX_EXPERIENCE = 50;
    private static final int MIN_DAMAGE = 10;

    public Hero() {
        this.name = DEFAULT_NAME;
        this.attack=DEFAULT_ATTACK;
        this.level=DEFAULT_LEVEL;
        this.defense=DEFAULT_DEFENSE;
        this.experience = 0;
        this.maxHealth = Math.min(DEFAULT_HEALTH, MAX_HEALTH_LIMIT);
        this.health = this.maxHealth;
    }

    public Hero(String name, int health, int attack, int defense) {
        setName(name);
        setAttack(attack);
        setDefense(defense);
        this.maxHealth = Math.min(health, MAX_HEALTH_LIMIT);
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
        this.health = Math.max(0,Math.min(health,this.maxHealth));
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

    public void drinkPotion(){
        this.health = Math.min(this.health + POTION_HEAL, this.maxHealth);
        System.out.println(this.name + " tomo una pocion. Salud actual: " + this.health);
    }

    public void rest(){
        this.health = Math.min(this.health + REST_HEAL, this.maxHealth);
        System.out.println(this.name + " descanso. Salud actual: " + this.health);
    }

    public void attack(Hero otroHero) {
        // Calcular el hit causado al otroHero
        int hit = Math.max(getAttack() - otroHero.getDefense(), MIN_DAMAGE);
        otroHero.setHealth(otroHero.getHealth() - hit);

        // Add experiencia al atacante
        this.experience += ATTACK_EXPERIENCE;

        // Subir de nivel si acumula 50 o mas de experiencia
        if (this.experience >= MAX_EXPERIENCE) {
            levelUp();
        }

        // Imprimir los detalles del ataque
        System.out.println(this.name + " ataco a " + otroHero.getName() + " causando " + hit + " de hit.");
        System.out.println(otroHero.getName() + " ahora tiene " + otroHero.getHealth() + " de salud.");
    }

    // Método para subir de nivel
    public void levelUp() {
        this.level++;
        this.maxHealth = Math.min(this.maxHealth + LEVEL_UP_HEALTH, MAX_HEALTH_LIMIT);
        this.attack += LEVEL_UP_ATTACK;
        this.defense += LEVEL_UP_DEFENSE;
        this.health = this.maxHealth;
        this.experience = 0;

        System.out.println(this.name + " subio al nivel " + this.level + "!");
        System.out.println("Nueva salud maxima: " + this.maxHealth + ", Ataque: " + this.attack + ", Defensa: " + this.defense);
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
