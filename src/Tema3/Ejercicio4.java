package Tema3;

import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* Escribe un programa que permita pasar de euros a dólares y de dólares
a euros. Necesitarás implementar el procedimiento showMenu() y las
funciones euro2dollar y dollar2euro.*/
public class Ejercicio4 {
    public static double euro2dollar(double dinero) {
        double res = 0;
        res = dinero * 1.04;
        return res;
    }

    public static double dollar2euro(double dinero) {
        double res = 0;
        res = dinero * 0.96;
        return res;
    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        double dinero = 0;
        char opcion, opcionConversion;
        boolean condConversion = true, condAccionConversor;
        double dolarAeuro = 0, euroAdolar = 0;
        while (condConversion) {
            System.out.println("---CONVERSOR DE DINERO(€/$)---");
            System.out.println("u.Utilizar");
            System.out.println("s.Salir");
            System.out.println("--------------------------------");
            System.out.println("Elige una opcion: ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'u':
                    do {
                        System.out.println("Introduce la cantidad de dinero que quieres conversar: ");
                        dinero = sc.nextDouble();
                        if (dinero <= 0) {
                            System.out.println("Error el saldo no debe ser negativo o 0");
                        } else {
                            dolarAeuro = dollar2euro(dinero);
                            euroAdolar = euro2dollar(dinero);
                        }
                    } while (dinero <= 0);
                    condAccionConversor=true;
                    while (condAccionConversor) {
                        System.out.println("d.Dolar");
                        System.out.println("e.Euro");
                        System.out.println("--------");
                        System.out.println("Elige una opcion: ");
                        opcionConversion = sc.next().toLowerCase().charAt(0);
                        switch (opcionConversion) {
                            case 'd':
                                System.out.println("Tu dinero en euros: " + dinero + " €" + " a dolares es " + dolarAeuro + " $");
                                condAccionConversor = false;
                                break;
                            case 'e':
                                System.out.println("Tu dinero en dolares: " + dinero + " $" + " a euros es " + euroAdolar + " €");
                                condAccionConversor = false;
                                break;
                            default:
                                System.out.println("ERROR: VUELVA A INTRODUCIR LA ACCION");
                        }
                    }
                    break;
                case 's':
                    System.out.println("Saliendo del programa...");
                    condConversion = false;
                    break;
                default:
                    System.err.println("Eleccion no reconocida.Vuelva a introducir la opcion correcta");
            }

        }

    }

    public static void main(String[] args) {
        showMenu();
    }
}
