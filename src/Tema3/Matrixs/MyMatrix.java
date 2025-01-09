package Tema3.Matrixs;

import java.util.Arrays;

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
    public static void printMatrix(int[][] vector){
        for (int i = 0; i < vector.length; i++) {;
            for (int j = 0; j < vector[i].length; j++) {
                System.out.println(vector[i][j]);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] vector){
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[i].length; j++) {
                System.out.println(vector[i][j]);
            }
        }
    }

    public static void printMatrix(String[][] vector){
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[i].length; j++) {
                System.out.println(vector[i][j]);
            }
        }
    }

    public static void printMatrix(char[][] vector){
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector[i].length; j++) {
                System.out.println(vector[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        //int[][]
    }

}
