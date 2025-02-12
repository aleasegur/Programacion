package Tema5.Excepciones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {
    public static void crear5Gatos(Scanner sc, ArrayList<Gato> lista)throws Exception{
        String name;
        int edad;
        try {
            for (int i = 0; i < 5; i++) {
                if (lista.size() < 5) {
                    System.out.println("Introduce el nombre del gato" + (i + 1) + ": ");
                    name = sc.next();
                    System.out.println("Introduce la edad del gato" + (i + 1) + ": ");
                    edad = sc.nextInt();
                    Gato nuevoGato = new Gato(name, edad);
                    lista.add(nuevoGato);
                } else {
                    throw new Exception("Solo se puede introdcuir 5 gatos en la lista");
                }
            }
        }catch (InputMismatchException e){
            System.err.println("Error: "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("---LISTA DE GATOS---");
        System.out.println(Ejercicio6.arrayMostrar(lista));
    }

    public static void menu(){
        System.out.println("a).Add 5 gatos en lista");
        System.out.println("b).Mostrar gatos");
        System.out.println("c).Salir");
        System.out.println("Elegir opcion: ");
    }

    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        ArrayList<Gato> gatos=new ArrayList<>();
        boolean entrarBucle=true;
        char opcion;
        while (entrarBucle){
            menu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    crear5Gatos(sc,gatos);
                    break;
                case 'b':
                    Ejercicio6.mostrarGatos(gatos);
                    break;
                case 'c':
                    System.out.println("Saliendo...");
                    entrarBucle=false;
                    break;
                default:
                    System.err.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}
