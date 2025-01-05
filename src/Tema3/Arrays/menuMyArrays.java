package Tema3.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class menuMyArrays {
    public static boolean comprobarDoubleArraysLenght(double[] array1,double[] array2){
        boolean res=array1.length!=array2.length;
        return res;
    }

    public static boolean comprobarIntArraysLenght(int[] array1,int[] array2){
        boolean res=array1.length!=array2.length;
        return res;
    }

    //Metodo que compruebo si el numero para la longitud que introduce el usuario es correcto(Que no sea menor a 0)
    public static int obtenerLongitudValida(Scanner sc) {
        int res;
        do {
            System.out.println("Introduce la longitud del vector: ");
            res = sc.nextInt();
            if (res < 0) {
                System.err.println("La longitud del vector no debe ser menor a 0");
            }
        } while (res < 0);
        return res;
    }

    public static void showMenu() {
        System.out.println("=== Menú ===");
        System.out.println("a. Imprimir el array");
        System.out.println("b. Obtener el máximo del array");
        System.out.println("c. Obtener el mínimo del array");
        System.out.println("d. Obtener la media del array");
        System.out.println("e. Verificar si un elemento existe en el array");
        System.out.println("f. Sumar dos vectores");
        System.out.println("g. Restar dos vectores");
        System.out.println("h. Calcular el producto escalar de dos vectores");
        System.out.println("i. Invertir el orden del array (devuelve nuevo)");
        System.out.println("j. Invertir el orden del array (in-place)");
        System.out.println("k. Verificar si el array es capicúa");
        System.out.println("l. Salir");
        System.out.print("Selecciona una opción:");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condicionBucleMenu = true;
        char opcion;
        while (condicionBucleMenu) {
            showMenu();
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case 'a':
                    boolean bucleCaseA = true;
                    char opcionA;
                    int longitudA = 0;
                    int[] vectorIntA;
                    double[] vectorDblA;
                    char[] vectorCharA;
                    String[] vectorStrA;
                    while (bucleCaseA) {
                        System.out.println("a.Cadena caracteres");
                        System.out.println("b.Numeros Enteros");
                        System.out.println("c.Numeros Reales");
                        System.out.println("d.Caracteres");
                        System.out.println("e.Salir");
                        opcionA = sc.next().toLowerCase().charAt(0);
                        if (opcionA!='e'){
                            longitudA = obtenerLongitudValida(sc);
                        }
                        switch (opcionA) {
                            case 'a':
                                String userResA;
                                vectorStrA = new String[longitudA];
                                for (int i = 0; i < vectorStrA.length; i++) {
                                    System.out.println("Introduce en el modulo " + i + " una cadena de carcteres:");
                                    userResA = sc.next();
                                    vectorStrA[i] = userResA;
                                }
                                MyArrays.printArray(vectorStrA);
                                break;
                            case 'b':
                                int userResB;
                                vectorIntA=new int[longitudA];
                                for (int i = 0; i < vectorIntA.length; i++) {
                                    System.out.println("Introduce en el modulo "+i+" un numero:");
                                    userResB=sc.nextInt();
                                    vectorIntA[i]=userResB;
                                }
                                MyArrays.printArray(vectorIntA);
                                break;
                            case 'c': // Manejar números reales
                                double userResC;
                                vectorDblA = new double[longitudA];
                                for (int i = 0; i < vectorDblA.length; i++) {
                                    System.out.print("Introduce en el modulo " + i + " un número real:");
                                    userResC = sc.nextDouble();
                                    vectorDblA[i] = userResC;
                                }
                                MyArrays.printArray(vectorDblA);
                                break;
                            case 'd': // Manejar caracteres
                                char userResD;
                                vectorCharA = new char[longitudA];
                                for (int i = 0; i < vectorCharA.length; i++) {
                                    System.out.print("Introduce en el modulo " + i + " un carácter:");
                                    userResD = sc.next().charAt(0);
                                    vectorCharA[i] = userResD;
                                }
                                MyArrays.printArray(vectorCharA);
                                break;
                            case 'e':
                                System.out.println("Saliendo del caso A...");
                                bucleCaseA=false;
                                break;
                            default:
                                System.err.println("Opción no válida. Intenta de nuevo.");
                                break;
                        }
                    }
                    break;
                case 'b':
                    int longitudB,resultB,userInputB;
                    int[] vectorIntB;
                    longitudB=obtenerLongitudValida(sc);
                    vectorIntB=new int[longitudB];
                    for (int i = 0; i < vectorIntB.length; i++) {
                        System.out.println("Introduce un numero entero en el modulo "+i+" :");
                        userInputB=sc.nextInt();
                        vectorIntB[i]=userInputB;
                    }
                    resultB=MyArrays.obtenerMax(vectorIntB);
                    System.out.println("El maximo es "+resultB);
                    break;
                case 'c':
                    int longitudC,resultC,userInputC;
                    int[] vectorIntC;
                    longitudC=obtenerLongitudValida(sc);
                    vectorIntC=new int[longitudC];
                    for (int i = 0; i < vectorIntC.length; i++) {
                        System.out.println("Introduce un numero entero en el modulo "+i+" :");
                        userInputC=sc.nextInt();
                        vectorIntC[i]=userInputC;
                    }
                    resultC=MyArrays.obtenerMin(vectorIntC);
                    System.out.println("El minimo es "+resultC);
                    break;
                case 'd':
                    int longitudD;
                    double resultD,userInputD;
                    double[] vectorDblD;
                    longitudD=obtenerLongitudValida(sc);
                    vectorDblD=new double[longitudD];
                    for (int i = 0; i < vectorDblD.length; i++) {
                        System.out.println("Introduce un numero real en el modulo "+i+" :");
                        userInputD=sc.nextInt();
                        vectorDblD[i]=userInputD;
                    }
                    resultD=MyArrays.obtenerMedia(vectorDblD);
                    System.out.println("La media es "+resultD);
                    break;
                case 'e':
                    boolean bucleCaseE=true,resultE;
                    int longitudE = 0;
                    int[] vectorIntE;
                    String[] vectorStrE;
                    char opcionE;
                    while (bucleCaseE){
                        System.out.println("a.Cadena caracteres");
                        System.out.println("b.Numeros Enteros");
                        System.out.println("c.Salir");
                        opcionE=sc.next().toLowerCase().charAt(0);
                        if (opcionE!='c'){
                            longitudE=obtenerLongitudValida(sc);
                        }
                        switch (opcionE){
                            case 'a':
                                String userResEa,elementoStrEa;
                                vectorStrE=new String[longitudE];
                                for (int i = 0; i < vectorStrE.length; i++) {
                                    System.out.println("Introduce en el modulo "+i+" una cadena de carcteres:");
                                    userResEa=sc.next();
                                    vectorStrE[i]=userResEa;
                                }
                                System.out.println("Que elemento quiere comprobar si existe: ");
                                elementoStrEa= sc.next();
                                resultE=MyArrays.existeElemento(vectorStrE,elementoStrEa);
                                if (resultE){
                                    System.out.println("El elemento "+elementoStrEa+" existe en el vector");
                                }else{
                                    System.out.println("El elemento "+elementoStrEa+" no existe en el vector");
                                }
                                break;
                            case 'c':
                                System.out.println("Saliendo del caso E...");
                                bucleCaseE=false;
                                break;
                            default:
                                System.err.println("Opción no válida. Intenta de nuevo.");
                                break;
                        }
                    }
                    break;
                case 'f':
                    break;
                case 'g':
                    break;
                case 'h':
                    break;
                case 'i':
                    break;
                case 'j':
                    break;
                case 'k':
                    break;
                case 'l':
                    System.out.println("Saliendo...");
                    condicionBucleMenu = false;
                    break;
                default:
                    System.err.println("Opción no válida. Intenta de nuevo.");
                    break;

            }
        }
        sc.close();
    }
}
