package Tema2;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURA
* “El número secreto”. Programa un juego en el que se calcula
aleatoriamente un número de 1 a 100. El usuario debe adivinarlo. Cada
vez que el usuario pone un número el programa le indicará si lo ha
acertado, si el número secreto es mayor o si es menor. Termina cuando
el usuario acierta el número.*/
public class Tema2Ejercicio29 {
    public static void main(String[] args) {
        int numMin = 1, numMax = 100, intentos = 0, numUser;
        boolean cond = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Piensa un numero del 1 al 100. A ver si lo adivino?");
        while (cond) {
            int num = (numMin + numMax) / 2;

            System.out.println("Es " + num + " tu numero?");
            System.out.println("1. Mayor");
            System.out.println("2. Menor");
            System.out.println("3. Igual");
            numUser = sc.nextInt();

            switch (numUser) {
                case 1:
                    numMax = num + 1;
                    intentos++;
                    break;
                case 2:
                    numMin = num - 1;
                    intentos++;
                    break;
                case 3:
                    System.out.println("He adivinado tu numero en " + intentos + " intentos");
                    cond = false;
                    break;

            }

        }
        sc.close();
    }
}
