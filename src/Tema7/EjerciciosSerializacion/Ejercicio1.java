package Tema7.EjerciciosSerializacion;

import Tema7.MyMethodsAtributes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        File file=new File(MyMethodsAtributes.newPath);
        String fileOut,name,edad;
        if (!file.exists()){
            file.mkdir();
        }
        name = MyMethodsAtributes.introducirCadena(sc, "el nombre del  usuario: ");
        edad = MyMethodsAtributes.introducirCadena(sc, "la edad del usuario " + name + ": ");
        fileOut = MyMethodsAtributes.introducirCadena(sc, "el nombre del fichero que alamcena la edad y nombre del usuario: ");
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(MyMethodsAtributes.newPath+fileOut))){
            bw.write("Nombre:"+name);
            bw.newLine();
            bw.write("Edad:"+edad);
            bw.newLine();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }
}
