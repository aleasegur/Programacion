package Tema3.Matrixs;

import java.util.Arrays;
import java.util.Scanner;

public class menuMatrixs {
    // Método para solicitar al usuario las dimensiones válidas de una matriz
    public static int obtenerDimensionValida(Scanner sc, String tipoDimension) {
        int dimension;
        do {
            System.out.println("Introduce " + tipoDimension + " (debe ser mayor que 0):");
            dimension = sc.nextInt();
            if (dimension <= 0) {
                System.err.println("La " + tipoDimension + " debe ser mayor que 0.");
            }
        } while (dimension <= 0);
        return dimension;
    }


    // Método para rellenar una matriz de enteros
    public static void rellenarMatriz(int[][] matriz, Scanner sc) {
        int numFila=0;
        // Usar foreach para recorrer filas y for para modificar elementos
        for (int[] fila : matriz) {
            System.out.println("Introduce los elementos para la fila "+numFila+" :");
            for (int i = 0; i < fila.length; i++) {
                System.out.println("Introduce en la columna un elemento en "+i+" de la fila"+ Arrays.toString(fila));
                fila[i] = sc.nextInt();
            }
            numFila++;
        }
    }

    public static void rellenarMatriz(double[][] matriz, Scanner sc) {
        int numFila=0;
        // Usar foreach para recorrer filas y for para modificar elementos
        for (double[] fila : matriz) {
            System.out.println("Introduce los elementos para la fila "+numFila+" :");
            for (int i = 0; i < fila.length; i++) {
                System.out.println("Introduce en la columna un elemento en "+i+" de la fila"+ Arrays.toString(fila));
                fila[i] = sc.nextInt();
            }
            numFila++;
        }
    }

    public static void showMenu() {
        System.out.println("=== Menú ===");
        System.out.println("a. Imprimir la matriz");
        System.out.println("b. Obtener el máximo de la matriz");
        System.out.println("c. Obtener el mínimo de la matriz");
        System.out.println("d. Obtener la media de la matriz");
        System.out.println("e. Verificar si un elemento existe en la matriz");
        System.out.println("f. Sumar dos matrices");
        System.out.println("g. Restar dos matrices");
        System.out.println("h. Verificar si la matriz es una matriz unidad");
        System.out.println("i. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean buclePrincipal = true;
        char opcion;

        while (buclePrincipal) {
            showMenu();
            opcion = sc.next().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    System.out.println("=== Imprimir la matrizB ===");
                    int filasA = obtenerDimensionValida(sc, "el número de filas");
                    int columnasA = obtenerDimensionValida(sc, "el número de columnas");
                    double[][] matrizA = new double[filasA][columnasA];
                    rellenarMatriz(matrizA, sc);
                    System.out.println("La matrizB es:");
                    MyMatrix.printMatrix(matrizA);
                    break;
                case 'b':
                    System.out.println("=== Obtener el máximo de la matrizB ===");
                    int filasB = obtenerDimensionValida(sc, "el número de filas");
                    int columnasB = obtenerDimensionValida(sc, "el número de columnas");
                    int[][] matrizB = new int[filasB][columnasB];
                    rellenarMatriz(matrizB, sc);
                    double maximo = MyMatrix.obtenerMax(matrizB);
                    System.out.println("El valor máximo de la matrizB es: " + maximo);
                    break;
                case 'c':
                    System.out.println("=== Obtener el mínimo de la matrizB ===");
                    int filasC = obtenerDimensionValida(sc, "el número de filas");
                    int columnasC = obtenerDimensionValida(sc, "el número de columnas");
                    int[][] matrizC = new int[filasC][columnasC];
                    rellenarMatriz(matrizC, sc);
                    int minimo = MyMatrix.obtenerMin(matrizC);
                    System.out.println("El valor mínimo de la matrizB es: " + minimo);
                    break;
                case 'd':
                    System.out.println("=== Obtener la media de la matrizB ===");
                    int filasD = obtenerDimensionValida(sc, "el número de filas");
                    int columnasD = obtenerDimensionValida(sc, "el número de columnas");
                    double[][] matrizD = new double[filasD][columnasD];
                    rellenarMatriz(matrizD, sc);
                    double media = MyMatrix.obtenertMedia(matrizD);
                    System.out.println("La media de la matrizB es: " + media);
                    break;
                case 'e':
                    System.out.println("=== Verificar si un elemento existe en la matrizB ===");
                    int filasE = obtenerDimensionValida(sc, "el número de filas");
                    int columnasE = obtenerDimensionValida(sc, "el número de columnas");
                    int[][] matrizE = new int[filasE][columnasE];
                    rellenarMatriz(matrizE, sc);
                    System.out.print("Introduce el elemento a buscar: ");
                    int elemento = sc.nextInt();
                    boolean existe = MyMatrix.existeElemento(matrizE, elemento);
                    if (existe) {
                        System.out.println("El elemento " + elemento + " existe en la matrizB.");
                    } else {
                        System.out.println("El elemento " + elemento + " no existe en la matrizB.");
                    }
                    break;
                case 'f':
                    System.out.println("=== Sumar dos matrices ===");
                    int filasF = obtenerDimensionValida(sc, "el número de filas");
                    int columnasF = obtenerDimensionValida(sc, "el número de columnas");
                    int[][] matrizF1 = new int[filasF][columnasF];
                    int[][] matrizF2 = new int[filasF][columnasF];
                    System.out.println("Rellena la primera matrizB:");
                    rellenarMatriz(matrizF1, sc);
                    System.out.println("Rellena la segunda matrizB:");
                    rellenarMatriz(matrizF2, sc);
                    int[][] suma = MyMatrix.sumarMatrices(matrizF1, matrizF2);
                    System.out.println("La suma de las matrices es:");
                    MyMatrix.printMatrix(suma);
                    break;
                case 'g':
                    System.out.println("=== Restar dos matrices ===");
                    int filasG = obtenerDimensionValida(sc, "el número de filas");
                    int columnasG = obtenerDimensionValida(sc, "el número de columnas");
                    int[][] matrizG1 = new int[filasG][columnasG];
                    int[][] matrizG2 = new int[filasG][columnasG];
                    System.out.println("Rellena la primera matrizB:");
                    rellenarMatriz(matrizG1, sc);
                    System.out.println("Rellena la segunda matrizB:");
                    rellenarMatriz(matrizG2, sc);
                    int[][] resta = MyMatrix.restarMatrices(matrizG1, matrizG2);
                    System.out.println("La resta de las matrices es:");
                    MyMatrix.printMatrix(resta);
                    break;
                case 'h':
                    System.out.println("=== Verificar amtriz unidad ===");
                    int filasH = obtenerDimensionValida(sc, "el número de filas");
                    int columnasH = obtenerDimensionValida(sc, "el número de columnas");
                    int[][] matrizH = new int[filasH][columnasH];
                    rellenarMatriz(matrizH, sc);
                    boolean resultH=MyMatrix.esMatrizUnidad(matrizH);
                    if (resultH) {
                        System.out.println("Es matriz unidad ");
                    }else{
                        System.out.println("No es matriz unidad");
                    }
                    MyMatrix.printMatrix(matrizH);
                    break;
                case 'i':
                    System.out.println("Saliendo...");
                    buclePrincipal = false;
                    break;

                default:
                    System.err.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sc.close();
    }
}
