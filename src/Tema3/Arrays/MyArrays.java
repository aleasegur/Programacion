package Tema3.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
/*ALEJANDRO ASENCIO GURAU
*  a) Unprocedimiento que imprima el array.
 b) Una función que devuelva el máximo del array.
 c) Una función que devuelva el mínimo del array.
 d) Una función que devuelva la media.
 e) Una función que te diga si un elemento existe en el array o no.
 f) Una función que haga la suma de dos vectores (arrays).
 g) Una función que haga la resta de dos vectores (arrays).
 h) Una función que haga el producto escalar de dos vectores(arrays).
 i) Haz una función que invierta el orden de un array. Por ejemplo:
 j) Haz un procedimiento que invierta el orden de un array.
 k) Haz una función que nos indique si un array es capicua o no. El
 siguiente array por ejemplo es capicua.
 l) Haz un programa con un menú que te permita introducir uno o
 dos vectores y hacer todas las operaciones anteriores.*/
public class MyArrays {
    public static void printArray(Object[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static int obtenerMax(int[] array){
        int res=0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i]>array[0]){
                res=array[i];
            }
        }
        return res;
    }

    public static int obtenerMin(int[] array){
        int res=0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i]<array[0]){
                res=array[i];
            }
        }
        return res;
    }

    public static double obtenerMedia(double[] array){
        double res=0;
        for (int i = 0; i < array.length; i++) {
            res+=array[i];
        }
        return res;
    }

    public static boolean existeElemento(int[] array,int elemento){
        boolean res=false;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==elemento){
                res=true;
            }
        }
        return res;
    }

    public static double[] sumaDosVectores(double[] array1,double[] array2){
        double[] res=new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i]=array1[i]+array2[i];
        }
        return res;
    }

    public static double[] restarDosVectores(double[] array1,double[] array2){
        double[] res=new double[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i]=array1[i]-array2[i];
        }
        return res;
    }

    public static double productoEscalar(double[] array1,double[] array2){
        double res=0;
        for (int i = 0; i < array1.length; i++) {
            res+=array1[i]*array2[i];
        }
        return res;
    }

    public static int[] invertirArray(int[] array){
        int[] res=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i]= array[array.length-1-i];//valor invertido
        }
        return res;
    }

    public static void invertirUnArray(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            // Uso una variable temporal para evitar sobrescribir el valor original
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static boolean capicuaArray(int[] array){
        boolean res=true;
        for (int i = 0; i < array.length/2; i++) {
            if (array[i]!=array[array.length-1-i]){
                res=false;
            }
        }
        return res;
    }

}
