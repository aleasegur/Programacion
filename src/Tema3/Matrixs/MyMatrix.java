package Tema3.Matrixs;

import java.util.Arrays;
import java.util.Scanner;

/*ALEJANDRO ASENCIO GURAU
* a) Un procedimiento que imprima la matriz.
b) Una función que devuelva el máximo de la matriz.
c) Una función que devuelva el mínimo de la matriz.
d) Una función que devuelva la media de la matriz.
e) Una función que te diga si un elemento existe en la matriz o no.
f) Una función que devuelva cuantas veces se repite un número en
una matriz.
g) Una función que haga la suma de dos matrices.
h) Una función que haga la resta de dos matrices.
i) Una función que compruebe si una matriz es la matriz unidad, es
decir tiene el mismo número de filas y de columnas ytiene en su
diagonal principal 1s y el resto 0s.*/
public class MyMatrix {
    public static void printMatrix(int[][] matriz){
        for (int[] fila : matriz){
            System.out.println(Arrays.toString(fila));
        }
    }

    public static void printMatrix(double[][] matriz){
        for (double[] fila : matriz){
            System.out.println(Arrays.toString(fila));
        }
    }

    public static void printMatrix(String[][] matriz){
        for (String[] fila : matriz){
            System.out.println(Arrays.toString(fila));
        }
    }

    public static void printMatrix(char[][] matriz){
        for (char[] fila : matriz){
            System.out.println(Arrays.toString(fila));
        }
    }

    public static int obtenerMax(int[][] matriz){
        int res=matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j]>res){
                    res=matriz[i][j];
                }
            }
        }
        return res;
    }

    public static int obtenerMin(int[][] matriz){
        int res=matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j]<res){
                    res=matriz[i][j];
                }
            }
        }
        return res;
    }

    public static double obtenertMedia(double[][] matriz){
        double res=0,suma=0,totalElementos=0;
        for (int i = 0; i < matriz.length; i++) {  // Recorre las filas
            for (int j = 0; j < matriz[i].length; j++) {  // Recorre las columnas de cada fila
                suma += matriz[i][j];  // Suma los elementos
                totalElementos++;  // Cuenta los elementos
            }
        }
        res=suma/totalElementos;
        return res;
    }

    public static boolean existeElemento(int[][] matriz, int elemento){
        boolean res=false;
        for (int[] fila : matriz){
            for (int columna : fila){
                if (columna==elemento){
                    res=true;
                }
            }
        }
        return res;
    }

    public static boolean existeElemento(String[][] matriz, String elemento){
        boolean res=false;
        for (String[] fila : matriz){
            for (String columna : fila){
                if (columna.equals(elemento)){
                    res=true;
                }
            }
        }
        return res;
    }

    public static int[][] sumarMatrices(int[][] matriz1,int[][] matriz2){
        int filas=matriz1.length;
        int columnas=matriz1[0].length;
        int[][] res=new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                res[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return res;
    }

    public static int[][] restarMatrices(int[][] matriz1,int[][] matriz2){
        int filas=matriz1.length;
        int columnas=matriz1[0].length;
        int[][] res=new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                res[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
        return res;
    }

    public static boolean esMatrizUnidad(int[][] matriz) {
        boolean res=true;
        int filas = matriz.length;

        // Verificar si la matriz es cuadrada
        for (int i = 0; i < filas; i++) {
            if (matriz[i].length != filas) {
                res=false;
            }
        }

        // Verifico los valores de la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    // Los elementos diagonales principalmente deben ser 1
                    if (matriz[i][j] != 1) {
                        res= false;
                    }
                } else {
                    // Los demas elementos deben ser 0
                    if (matriz[i][j] != 0) {
                        res= false;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] matriz;
        int[][] matriz2;
        int filas,columnas,userInp,userInp2,userElemento;
        System.out.println("Introduce el numero de filas: ");
        filas=sc.nextInt();
        System.out.println("Introduce el numero de columnas: ");
        columnas=sc.nextInt();

        matriz=new int[filas][columnas];
        matriz2=new int[filas][columnas];
        int numFila=0;
        // Usar foreach para recorrer filas y for para modificar elementos
        for (int[] fila : matriz) {
            System.out.println("Introduce los lelemetos para la fila "+numFila+" :");
            for (int i = 0; i < fila.length; i++) {
                System.out.println("Introduce en la columnas un elemto: "+i+" de la fila"+ Arrays.toString(fila));
                userInp=sc.nextInt();
                fila[i] = userInp;
            }
            numFila++;
        }

        boolean esunidad=esMatrizUnidad(matriz);
        if (esunidad){
            System.out.println("Es unidad");
        }else {
            System.out.println("No es unidad");
        }
        printMatrix(matriz);
/*
        System.out.println("Introduce elementos de la matriz");
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Introduce en la filas "+i+", columnas "+j+" un numero entero: ");
                userInp=sc.nextInt();
                matriz[i][j]=userInp;
            }
        }

        for (int i = 0; i <matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
        int maximo=obtenerMax(matriz);
        System.out.println();
        System.out.println("EL VALOR MAXIMO ES "+maximo);
        */

    }
}
