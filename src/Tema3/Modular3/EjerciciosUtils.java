package Tema3.Modular3;

import java.util.Scanner;
import Tema3.Modular2.*;
public class EjerciciosUtils {
    public static void showMneuUtils(){
        System.out.println("---MENU INTERACTIVO---");
        System.out.println("Menú de opciones:");
        System.out.println("a) miles2kilometers: Convertir millas a kilómetros.");
        System.out.println("b) getTaxes: Calcular impuestos a partir de un porcentaje y un monto.");
        System.out.println("c) getNetPrice: Calcular el precio neto (cantidad + impuestos).");
        System.out.println("d) getCoins: Descomponer una cantidad en monedas de euro.");
        System.out.println("e) getNIF: Calcular el NIF a partir del número del DNI.");
        System.out.println("f) isValidNIF: Comprobar la validez de un DNI y NIF.");
        System.out.println("g) calculateIRPF: Calcular el IRPF a partir de un salario anual.");
        System.out.println("s) Salir.");
        System.out.println("---------------");
        System.out.println("Elige una opcion: ");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char opcion;
        boolean buclePrincipal=true;
        while (buclePrincipal){
            showMneuUtils();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    double numMillas;
                    do {
                        System.out.println("Introduce el valor de millas para convertirlo a km: ");

                    }while ()
                    break;
                case 'b':
                    break;
                case 'c':
                    break;
                case 'd':
                    break;
                case 'e':
                    break;
                case 'f':
                    break;
                case 'g':
                    break;
                case 's':
                    System.out.println("Saliendo...");
                    buclePrincipal=false;
                    break;
                default:
                    System.err.println("ERROR AL INTODUCIR.VUELVA A INTRODUCIR");
            }
        }

    }
}
