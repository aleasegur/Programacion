package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que muestre un menú con 9 opciones (si tus
ejercicios son modulares no debería costarte demasiado):
a) Muestra el signo de un número introducido por el usuario.
b) Indica si el usuario es mayor de edad o no.
c) Calcula el área y perímetro de un círculo.
d) Conversor de euros a dólares y de dólares a euros.
e) Mostrar tabla de multiplicar de un número.
f) Mostrar tablas de multiplicar del 1 al 10.
g) Comprobador de números primos.
h) Comprobador de fechas.
i) Dibujar triángulos.
*/
public class Ejercicio10 {

    public static void mostrarMenuAcciones(Scanner sc) {
        char opcion;
        boolean condicionMenu = true;
        while (condicionMenu) {
            System.out.println("---MENU INTERACTIVO---");
            System.out.println("a) Muestra el signo de un número introducido por el usuario.\n" +
                    "b) Indica si el usuario es mayor de edad o no.\n" +
                    "c) Calcula el área y perímetro de un círculo.\n" +
                    "d) Conversor de euros a dólares y de dólares a euros.\n" +
                    "e) Mostrar tabla de multiplicar de un número.\n" +
                    "f) Mostrar tablas de multiplicar del 1 al 10.\n" +
                    "g) Comprobador de números primos.\n" +
                    "h) Comprobador de fechas.\n" +
                    "i) Dibujar triángulos. \n" +
                    "s) Salir. ");
            System.out.println("---------------");
            System.out.println("Elige una opcion: ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a':
                    Ejercicio1.mostrarPositivo0Negativo(sc);
                    break;
                case 'b':
                   Ejercicio2.mostrarEdadMayor(sc);
                    break;
                case 'c':
                    Ejercicio3.mostrarCalculoCirculo(sc);
                    break;
                case 'd':
                    Ejercicio4.showMenu(sc);
                    break;
                case 'e':
                    Ejercicio5.mostrarTablaMultiplicacion(sc);
                    break;
                case 'f':
                    Ejercicio6.mostrarTablasMultiplicarUnoAlDiez();
                    break;
                case 'g':
                    Ejercicio7.mostrarNumPrimos(sc);
                    break;
                case 'h':
                    Ejercicio8.mostrarFechaCorrecta(sc);
                    break;
                case 'i':
                    Ejercicio9.mostrarPirmaide(sc);
                    break;
                case 's':
                    System.out.println("Saliendo...");
                    condicionMenu = false;
                    break;
                default:
                    System.err.println("CARACTER NO RECONOCIDO. VUELVE A INTRODUCIR");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        mostrarMenuAcciones(sc);
        sc.close();
    }
}
