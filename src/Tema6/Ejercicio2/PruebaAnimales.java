package Tema6.Ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaAnimales {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Animal> lista=new ArrayList<>();
    }

    public static String introducirNombre(Scanner sc){
        String cadena="";
        try {
            System.out.println("Introduce el nombre: ");
            cadena=sc.next();
        }catch (StringIndexOutOfBoundsException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return cadena;
    }

    public static int introducirEdad(Scanner sc){
        int num=0;
        try {
            do {
                System.out.println("Introduce la edad: ");
                num = sc.nextInt();
            }while (!Animal.numeroNoNegativo(num));
        }catch (InputMismatchException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return num;
    }

    public static double introducirPesoAltura(Scanner sc){
        double num=0;
        try {
            do {
                System.out.println("Introduce la edad: ");
                num = sc.nextDouble();
            }while (!Animal.numeroNoNegativo(num));
        }catch (InputMismatchException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }catch (Exception e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
        return num;
    }

    public static void addAnimales(Scanner sc,ArrayList<Animal> lista){
        String name="";
        int edad=0,opcion=0;
        double peso=0,altura=0;
        boolean bucle=true;
        while (bucle){
            try {
                showSubmenu();
                opcion = sc.nextInt();
            }catch (InputMismatchException e){
                System.err.println("Error "+e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }catch (Exception e){
                System.err.println("Error "+e.getMessage());
                e.printStackTrace();
                sc.nextLine();
            }
        }
    }

    public static void showSubmenu(){
        System.out.println("1).Canario");
        System.out.println("2).Cocodrilo");
        System.out.println("3).Gato");
        System.out.println("4).Perro");
        System.out.println("5).Tiburon");
        System.out.println("Elegir opcion");
    }

}
