package Tema7.EjerciciosSerializacion;

import Tema7.MyMethodsAtributes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
* Crea	un	programa	que	pida	al	usuario	su	nombre	y	edad	y	los	guarde	en	un	fichero	llamado
usuario.txt,	con	el	siguiente	formato:
Nombre:	Ximo
Edad:	25	*/
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        File file=new File(MyMethodsAtributes.newPath);
        String fileOut,name;
        int edad;
        if (!file.exists()){
            file.mkdir();
        }
        name = MyMethodsAtributes.introducirCadena(sc, "el nombre del  usuario: ");
        edad = MyMethodsAtributes.introducirEntero(sc, "la edad del usuario " + name + ": ");
        fileOut = MyMethodsAtributes.introducirCadena(sc, "el nombre del fichero que almacena la edad y nombre del usuario: ");
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(MyMethodsAtributes.newPath+fileOut))){
            bw.write("Nombre:"+name);
            bw.newLine();
            bw.write("Edad:"+edad);
            bw.newLine();
            System.out.println("El usuario se ha guardado en el directorio: "+MyMethodsAtributes.newPath+fileOut);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }
}
