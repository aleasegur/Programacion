package Tema2;
/*ALEJANDRO ASENCIO GURAU
* 21. Escribe un programa que calcula la suma de todos los números pares
entre 1 y 1000 y la muestra por consola.*/
public class Tema2Ejercicio21 {
    public static void main(String[] args) {
        int suma=0,cant=1000;
        for (int i = 1; i <=cant ; i++) {
            if (i%2==0){
                suma+=i;
            }
        }
        System.out.println("La suma de los numeros pares son "+suma);
    }
}
