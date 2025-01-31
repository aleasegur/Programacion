package Tema4.GestionPersonasCuentas;

import java.util.Scanner;

public class Prueba {
    public static String arrayMostrar(Persona[] personas) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                sb.append(".");//Posicion vacia
            } else {
                sb.append("X");//Posicion ocupada
            }
            if (i < personas.length - 1) {
                sb.append(", ");//en cada espacio de la posicion pogo coma(,)
            }
        }
        sb.append("]");
        return sb.toString();
    }


        public static void instanciarPersina(Scanner sc, Persona[] personas, int numPersonas) {
        String dni;
        do {
            dni = Persona.introducirDni(sc);
        } while (Persona.comprobarDniRepetido(dni, personas));
        if (numPersonas < personas.length) {
            personas[numPersonas] = new Persona(dni);
        }
            System.out.println(arrayMostrar(personas));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[10];
        int numPersonas = 0;
        int opcion;
        boolean condiconBucle = true;
        while (condiconBucle) {
            PruebaCuentas.showMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    instanciarPersina(sc, personas, numPersonas);
                    numPersonas++;
                    break;
                case 2:
                    //ES912_(ultimo numero el que quieras del 0-9)
                    //ES91__(ultimos numeros el que quieras del 0-9)
                    //Comprobar al introducir sin repetir mucho numeros
                    PruebaCuentas.instanciarAsociarCuenta(sc, personas);
                    break;
                case 3:
                    PruebaCuentas.mostrarDatosPersona(sc, personas);
                    break;
                case 4:
                    PruebaCuentas.reacibirNomina(personas, sc);
                    break;
                case 5:
                    PruebaCuentas.realizarPago(sc, personas);
                    break;
                case 6:
                    PruebaCuentas.realizarTransferencia(personas, sc);
                    break;
                case 7:
                    PruebaCuentas.imprimirMorosos(personas);
                    break;
                case 8:
                    System.out.println("Saliendo del progrma...");
                    condiconBucle = false;
                    break;
                default:
                    System.err.println("Opcion no valida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
