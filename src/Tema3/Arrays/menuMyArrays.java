package Tema3.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class menuMyArrays {

    public static void addModArray(String[] vector,String user,Scanner sc){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Introduce en el modulo " + i + " una cadena de carcteres:");
            user = sc.next();
            vector[i] = user;
        }
    }

    public static void addModArray(int[] vector,int user,Scanner sc){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Introduce en el modulo " + i + " un numero entero:");
            user = sc.nextInt();
            vector[i] = user;
        }
    }

    public static void addModArray(double[] vector,double user,Scanner sc){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Introduce en el modulo " + i + " una cadena de carcteres:");
            user = sc.nextDouble();
            vector[i] = user;
        }
    }

    public static void addModArray(char[] vector,char user,Scanner sc){
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Introduce en el modulo " + i + " una cadena de carcteres:");
            user = sc.next().toLowerCase().charAt(0);
            vector[i] = user;
        }
    }

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
                                String userResA="";
                                vectorStrA = new String[longitudA];
                                addModArray(vectorStrA,userResA,sc);
                                MyArrays.printArray(vectorStrA);
                                break;
                            case 'b':
                                int userResB=0;
                                vectorIntA=new int[longitudA];
                                addModArray(vectorIntA,userResB,sc);
                                MyArrays.printArray(vectorIntA);
                                break;
                            case 'c': // Manejar números reales
                                double userResC=0.0;
                                vectorDblA = new double[longitudA];
                                addModArray(vectorDblA,userResC,sc);
                                MyArrays.printArray(vectorDblA);
                                break;
                            case 'd': // Manejar caracteres
                                char userResD=0;
                                vectorCharA = new char[longitudA];
                                addModArray(vectorCharA,userResD,sc);
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
                    int longitudB,resultB,userInputB=0;
                    int[] vectorIntB;
                    longitudB=obtenerLongitudValida(sc);
                    vectorIntB=new int[longitudB];
                    addModArray(vectorIntB,userInputB,sc);
                    resultB=MyArrays.obtenerMax(vectorIntB);
                    System.out.println("El maximo es "+resultB);
                    break;
                case 'c':
                    int longitudC,resultC,userInputC=0;
                    int[] vectorIntC;
                    longitudC=obtenerLongitudValida(sc);
                    vectorIntC=new int[longitudC];
                    addModArray(vectorIntC,userInputC,sc);
                    resultC=MyArrays.obtenerMin(vectorIntC);
                    System.out.println("El minimo es "+resultC);
                    break;
                case 'd':
                    int longitudD;
                    double resultD,userInputD=0;
                    double[] vectorDblD;
                    longitudD=obtenerLongitudValida(sc);
                    vectorDblD=new double[longitudD];
                    addModArray(vectorDblD,userInputD,sc);
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
                        System.out.println("c.Salir");
                        opcionE=sc.next().toLowerCase().charAt(0);
                        if (opcionE=='a'){
                            longitudE=obtenerLongitudValida(sc);
                        }
                        switch (opcionE){
                            case 'a':
                                String userResEa="",elementoStrEa;
                                vectorStrE=new String[longitudE];
                                addModArray(vectorStrE,userResEa,sc);
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
                    double userInputF1=0,userInputF2=0;
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
                    addModArray(vectorDblF1,userInputF1,sc);
                    //vectorDblH2
                    System.out.println("Vector2");
                    System.out.println("--------");
                    addModArray(vectorDblF2,userInputF2,sc);
                    resultF=MyArrays.sumaDosVectores(vectorDblF1,vectorDblF2);
                    System.out.println("La suma de los dos vectores es "+Arrays.toString(resultF));
                    break;
                case 'g':
                    int longitudG1,longitudG2;
                    double[] vectorDblG1,vectorDblG2,resultG;
                    double userInputG1=0,userInputG2=0;
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
                    addModArray(vectorDblG1,userInputG1,sc);
                    //vectorDblH2
                    System.out.println("Vector2");
                    System.out.println("--------");
                    addModArray(vectorDblG2,userInputG2,sc);
                    resultG=MyArrays.restarDosVectores(vectorDblG1,vectorDblG2);
                    System.out.println("La resta de los dos vectores es "+Arrays.toString(resultG));
                    break;
                case 'h':
                    int longitudH1,longitudH2;
                    double[] vectorDblH1,vectorDblH2;
                    double resultH;
                    double userInputH1=0,userInputH2=0;
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
                    addModArray(vectorDblH1,userInputH1,sc);
                    //vectorDblH2
                    System.out.println("Vector2");
                    System.out.println("--------");
                    addModArray(vectorDblH2,userInputH2,sc);
                    resultH=MyArrays.productoEscalar(vectorDblH1,vectorDblH2);
                    System.out.println("El producto a escalar es "+resultH);
                    break;
                case 'i':
                    int longitudI,userInputI=0;
                    int[] vectorIntI,resultI;
                    longitudI=obtenerLongitudValida(sc);
                    vectorIntI=new int[longitudI];
                    addModArray(vectorIntI,userInputI,sc);
                    resultI=MyArrays.invertirArray(vectorIntI);
                    System.out.println("Orden sin invertir "+Arrays.toString(vectorIntI));
                    System.out.println("Orden invertido "+Arrays.toString(resultI));
                    break;
                case 'j':
                    int longitudJ,userInputJ=0;
                    int[] vectorIntJ;
                    longitudJ=obtenerLongitudValida(sc);
                    vectorIntJ=new int[longitudJ];
                    addModArray(vectorIntJ,userInputJ,sc);
                    System.out.println("Orden sin invertor "+Arrays.toString(vectorIntJ));
                    MyArrays.invertirUnArray(vectorIntJ);
                    System.out.println("Orden invertido "+Arrays.toString(vectorIntJ));
                    break;
                case 'k':
                    int longitudK,userInputK=0;
                    int[] vectorIntK;
                    boolean resultK;
                    longitudK=obtenerLongitudValida(sc);
                    vectorIntK=new int[longitudK];
                    addModArray(vectorIntK,userInputK,sc);
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
