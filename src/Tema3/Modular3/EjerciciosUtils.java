package Tema3.Modular3;

import Tema3.Modular2.Ejercicio10;

import java.util.Scanner;
public class EjerciciosUtils {
    public static void showMneuUtils(){
        System.out.println("---MENU INTERACTIVO---");
        System.out.println("Menú de opciones:");
        System.out.println("a) miles2kilometers: Convertir millas a kilómetros.");
        System.out.println("b) getTaxes: Calcular impuestos a partir de un porcentaje y una cantidad.");
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
                    boolean condicionCaseA=true;
                    double resultA;
                    while (condicionCaseA) {
                        do {
                            System.out.println("Introduce el valor de millas para convertirlo a km: ");
                            numMillas = sc.nextDouble();
                            if (numMillas < 0) {
                                System.err.println("El valor no puede ser menor a 0");
                            }
                        } while (numMillas < 0);
                        resultA=Utils.miles2kilometers(numMillas);
                        System.out.println("El valor a Km es "+resultA);
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso A...");
                            condicionCaseA=false;
                        }
                    }
                    break;
                case 'b':
                    double precioB,porcentajeB;
                    boolean condicionCaseB=true;
                    double resultB;
                    while (condicionCaseB){
                        do {
                            System.out.println("Introduce el precio: ");
                            precioB=sc.nextDouble();
                            System.out.println("Introduce el porcentajr de impuesto: ");
                            porcentajeB=sc.nextDouble();
                            if (precioB<=0){
                                System.err.println("El precio no debe ser menor o igual a 0");
                            }
                            if (porcentajeB<0){
                                System.out.println("El mporcentaje a aplicar no debe ser menor a 0");
                            }
                        }while (precioB<=0 || porcentajeB<0);
                        resultB=Utils.getTaxes(precioB,porcentajeB);
                        System.out.println("La cantidad introducida: "+precioB+"\nEl porcentaje introdcuido: "+porcentajeB+"\nImpuesto a aplicar: "+resultB);
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso B...");
                            condicionCaseB=false;
                        }
                    }
                    break;
                case 'c':
                    double precioC,porcentajeC;
                    boolean condicionCaseC=true;
                    double resultC;
                    while (condicionCaseC){
                        do {
                            System.out.println("Introduce el precio: ");
                            precioC=sc.nextDouble();
                            System.out.println("Introduce el porcentajr de impuesto: ");
                            porcentajeC=sc.nextDouble();
                            if (precioC<=0){
                                System.err.println("El precio no debe ser menor o igual a 0");
                            }
                            if (porcentajeC<0){
                                System.out.println("El mporcentaje a aplicar no debe ser menor a 0");
                            }
                        }while (precioC<=0 || porcentajeC<0);
                        resultC=Utils.getNetPrice(precioC,porcentajeC);
                        System.out.println("La cantidad introducida: "+precioC+"\nEl porcentaje introdcuido: "+porcentajeC+"\nTotal con el impuesto: "+resultC);
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso C...");
                            condicionCaseC=false;
                        }
                    }
                    break;
                case 'd':
                    double cantidadEuros;
                    int resultD;
                    boolean condicionCaseD=true;
                    while (condicionCaseD){
                        do {
                            System.out.println("Introduce la cantidad deeuros que quieres descomponer: ");
                            cantidadEuros=sc.nextDouble();
                            if (cantidadEuros<=0){
                                System.err.println("La cantidad introducida no debe ser menor o igual a 0");
                            }
                        }while (cantidadEuros<=0);
                        resultD=Utils.getCoins(cantidadEuros);
                        System.out.println("La cantidad a descomponer es "+resultD);
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso D...");
                            condicionCaseD=false;
                        }
                    }
                    break;
                case 'e':
                    String numeroDni;
                    char resultE;
                    boolean condicionCaseE=true;
                    while (condicionCaseE){
                        do {
                            System.out.println("Introduce el numero de un dni: ");
                            numeroDni = sc.next();
                            if (numeroDni.length()!=8){
                                System.err.println("El numero del DNI debr tener una longitud minima de 8 carcteres");
                            }
                        }while (numeroDni.length()!=8);
                        resultE=Utils.getNIF(numeroDni);
                        System.out.println("El numero del dni: "+numeroDni+"\nLetra: "+resultE);
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso E...");
                            condicionCaseE=false;
                        }
                    }
                    break;
                case 'f':
                    String validarDni;
                    boolean resultF;
                    boolean condicionCaseF=true;
                    while (condicionCaseF){
                        do {
                            System.out.println("Introduce tu dni: ");
                            sc.nextLine();
                            validarDni = sc.nextLine().toUpperCase();
                            if (validarDni.length()!=9){
                                System.err.println("El DNI debr tener una longitud minima de 9 carcteres");
                            }
                        }while (validarDni.length()!=9);
                        resultF=Utils.isValidNIF(validarDni);
                        if (resultF){
                            System.out.println("DNI VALIDO");
                        }else {
                            System.out.println("DNI NO VALIDO");
                        }
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso F...");
                            condicionCaseF=false;
                        }
                    }
                    break;
                case 'g':
                    double salario,resultG;
                    boolean condicionCaseG=true;
                    while (condicionCaseG){
                        do {
                            System.out.println("Introduce tu salario: ");
                            salario=sc.nextDouble();
                            if (salario<=0){
                                System.err.println("El salrio no debe ser menor o igual a 0");
                            }
                        }while (salario<=0);
                        resultG=Utils.calculateIRPF(salario);
                        System.out.println("El IROF totoal es "+resultG);
                        if (!Ejercicio10.pedirOtraVez(sc)){
                            System.out.println("Saliendo del caso G...");
                            condicionCaseG=false;
                        }
                    }
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
