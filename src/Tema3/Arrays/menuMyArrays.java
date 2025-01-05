package Tema3.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class menuMyArrays {
    public static boolean comprobarArraysLenght(double[] array1,double[] array2){
        boolean res=array1.length!=array2.length;
        return res;
    }

    public static boolean comprobarArraysLenght(int[] array1,int[] array2){
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
                    int longitudF1,longitudF2;
                    double[] vectorDblF1,vectorDblF2,resultF;
                    double userInputF1,userInputF2;
                    boolean longitudVectorEq;
                    do {
                        longitudF1 = obtenerLongitudValida(sc);
                        longitudF2 = obtenerLongitudValida(sc);
                        vectorDblF1=new double[longitudF1];
                        vectorDblF2=new double[longitudF2];
                        longitudVectorEq=comprobarArraysLenght(vectorDblF1,vectorDblF2);
                        if (longitudVectorEq){
                            System.err.println("Los vectores han de ser de la misma longitud");
                        }
                    }while (longitudVectorEq);
                    //vectorDblH1, el usuario introduce dentro de cada modulo el numero que desea
                    System.out.println("Vector1");
                    System.out.println("--------");
                    for (int i = 0; i <vectorDblF1.length ; i++) {
                        System.out.print("Introduce en el modulo " + i + " un número real:");
                        userInputF1=sc.nextDouble();
                        vectorDblF1[i]=userInputF1;
                    }
                    //vectorDblH2
                    System.out.println("Vector2");
                    System.out.println("--------");
                    for (int i = 0; i < vectorDblF2.length; i++) {
                        System.out.print("Introduce en el modulo " + i + " un número real:");
                        userInputF2=sc.nextDouble();
                        vectorDblF2[i]=userInputF2;
                    }
                    resultF=MyArrays.sumaDosVectores(vectorDblF1,vectorDblF2);
                    System.out.println("La suma de los dos vectores es "+Arrays.toString(resultF));
                    break;
                case 'g':
                    int longitudG1,longitudG2;
                    double[] vectorDblG1,vectorDblG2,resultG;
                    double userInputG1,userInputG2;
                    boolean longitudVectorEqG;
                    do {
                        longitudG1 = obtenerLongitudValida(sc);
                        longitudG2 = obtenerLongitudValida(sc);
                        vectorDblG1=new double[longitudG1];
                        vectorDblG2=new double[longitudG2];
                        longitudVectorEqG=comprobarArraysLenght(vectorDblG1,vectorDblG2);
                        if (longitudVectorEqG){
                            System.err.println("Los vectores han de ser de la misma longitud");
                        }
                    }while (longitudVectorEqG);
                    //vectorDblH1, el usuario introduce dentro de cada modulo el numero que desea
                    System.out.println("Vector1");
                    System.out.println("--------");
                    for (int i = 0; i <vectorDblG1.length ; i++) {
                        System.out.print("Introduce en el modulo " + i + " un número real:");
                        userInputG1=sc.nextDouble();
                        vectorDblG1[i]=userInputG1;
                    }
                    //vectorDblH2
                    System.out.println("Vector2");
                    System.out.println("--------");
                    for (int i = 0; i < vectorDblG2.length; i++) {
                        System.out.print("Introduce en el modulo " + i + " un número real:");
                        userInputG2=sc.nextDouble();
                        vectorDblG2[i]=userInputG2;
                    }
                    resultG=MyArrays.restarDosVectores(vectorDblG1,vectorDblG2);
                    System.out.println("La resta de los dos vectores es "+Arrays.toString(resultG));
                    break;
                case 'h':
                    int longitudH1,longitudH2;
                    double[] vectorDblH1,vectorDblH2;
                    double resultH;
                    double userInputH1,userInputH2;
                    boolean longitudVectorEqH;
                    do {
                        longitudH1 = obtenerLongitudValida(sc);
                        longitudH2 = obtenerLongitudValida(sc);
                        vectorDblH1=new double[longitudH1];
                        vectorDblH2=new double[longitudH2];
                        longitudVectorEqH=comprobarArraysLenght(vectorDblH1,vectorDblH2);
                        if (longitudVectorEqH){
                            System.err.println("Los vectores han de ser de la misma longitud");
                        }
                    }while (longitudVectorEqH);
                    //vectorDblH1, el usuario introduce dentro de cada modulo el numero que desea
                    System.out.println("Vector1");
                    System.out.println("--------");
                    for (int i = 0; i <vectorDblH1.length ; i++) {
                        System.out.print("Introduce en el modulo " + i + " un número real:");
                        userInputH1=sc.nextDouble();
                        vectorDblH1[i]=userInputH1;
                    }
                    //vectorDblH2
                    System.out.println("Vector2");
                    System.out.println("--------");
                    for (int i = 0; i < vectorDblH2.length; i++) {
                        System.out.print("Introduce en el modulo " + i + " un número real:");
                        userInputH2=sc.nextDouble();
                        vectorDblH2[i]=userInputH2;
                    }
                    resultH=MyArrays.productoEscalar(vectorDblH1,vectorDblH2);
                    System.out.println("El producto a escalar es "+resultH);
                    break;
                case 'i':
                    int longitudI,userInputI;
                    int[] vectorIntI,resultI;
                    longitudI=obtenerLongitudValida(sc);
                    vectorIntI=new int[longitudI];
                    for (int i = 0; i < vectorIntI.length; i++) {
                        System.out.println("Introduce un numero entero en el modulo "+i+" :");
                        userInputI=sc.nextInt();
                        vectorIntI[i]=userInputI;
                    }
                    resultI=MyArrays.invertirArray(vectorIntI);
                    System.out.println("Orden sin invertir "+Arrays.toString(vectorIntI));
                    System.out.println("Orden invertido "+Arrays.toString(resultI));
                    break;
                case 'j':
                    int longitudJ,userInputJ;
                    int[] vectorIntJ;
                    longitudJ=obtenerLongitudValida(sc);
                    vectorIntJ=new int[longitudJ];
                    for (int i = 0; i < vectorIntJ.length; i++) {
                        System.out.println("Introduce un numero entero en el modulo "+i+" :");
                        userInputJ=sc.nextInt();
                        vectorIntJ[i]=userInputJ;
                    }
                    System.out.println("Orden sin invertor "+Arrays.toString(vectorIntJ));
                    MyArrays.invertirUnArray(vectorIntJ);
                    System.out.println("Orden invertido "+Arrays.toString(vectorIntJ));
                    break;
                case 'k':
                    int longitudK,userInputK;
                    int[] vectorIntK;
                    boolean resultK;
                    longitudK=obtenerLongitudValida(sc);
                    vectorIntK=new int[longitudK];
                    for (int i = 0; i < vectorIntK.length; i++) {
                        System.out.println("Introduce un numero entero en el modulo "+i+" :");
                        userInputK=sc.nextInt();
                        vectorIntK[i]=userInputK;
                    }
                    resultK=MyArrays.capicuaArray(vectorIntK);
                    if (resultK){
                        System.out.println("El vector introducido es capicua");
                    }else {
                        System.out.println("El vector introducido no es capicua");
                    }

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
