//ALEJANDRO ASENCIO GURAU
/*7. Implementa en Java el ejercicio 3. Estará dentro del proyecto
Programacion y deberá llamarse Tema1Ejercicio7:
Se lee una cara de un dado (de 1 a 6), muestra que no es un número
correcto si el número es mayor a 6 o menor que 1 y si el número es
válido escribe por pantalla la cara opuesta del dado*/

import java.util.Scanner;

public class Tema1Ejercicio7 {
    public static void main(String[] args) {
        int caraDado, caraOpuesta = 7;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un numero de un dado de 6 caras");
        caraDado = sc.nextInt();

        if (caraDado >= 1 && caraDado <= 6) {
            caraOpuesta -= caraDado;
        } else {
            System.err.println("Error solo es valido del 1 al 6");
        }

        System.out.println("La cara opuesta de " + caraDado + " es " + caraOpuesta);
        sc.close();
    }
}
