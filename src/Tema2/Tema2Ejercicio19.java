package Tema2;
/*ALEJANDRO ASENCIO GURAU
* 19. Escribe un programa que muestra por consola todos los números pares
entre 1 y 1000.*/
public class Tema2Ejercicio19 {
    public static void main(String[] args) {
        int cant=1000;
        for (int i = 1; i <= cant; i++) {
            if (i%2==0){
                System.out.println("Los pares son "+i);
            }
        }
    }
}
