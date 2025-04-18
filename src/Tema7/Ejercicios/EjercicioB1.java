package Tema7.Ejercicios;

import Tema7.MyMethodsAtributes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
/*
* Implementa un programa que muestre por pantalla los valores máximos y mínimos del archivo
‘numeros.txt’.-*/
public class EjercicioB1 {
    public static void main(String[] args) {
        String fileName="numeros.txt";
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;

        try(BufferedReader br=new BufferedReader(new FileReader(MyMethodsAtributes.namePath+fileName))){
            String linea;
            boolean hayNumero=false;
            while ((linea=br.readLine())!=null){
                try {
                    int numeros = Integer.parseInt(linea.trim());
                    if (numeros>max){
                        max=numeros;
                    }

                    if (numeros>min){
                        min=numeros;
                    }
                    hayNumero=true;
                }catch (NumberFormatException | InputMismatchException | ArithmeticException e){
                    e.printStackTrace();
                }
            }
            if (hayNumero){
                System.out.println("Numero Maximo: "+max);
                System.out.println("Numero Minimo: "+min);
            }else{
                System.err.println("El archivo no contiene numeros validos");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
