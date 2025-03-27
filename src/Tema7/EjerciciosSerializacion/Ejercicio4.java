package Tema7.EjerciciosSerializacion;
import Tema7.MyMethodsAtributes;

import java.io.*;
import java.util.Scanner;

/*Crea	una	clase	Persona	con	nombre	y	edad.	Crea	un	objeto	y	guárdalo	en	un	fichero	binario
llamado	persona.dat	mediante	serialización.*/
public class Ejercicio4 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String fileOut="persona.dat";
        String dir=MyMethodsAtributes.newPathData;
        String nombre= MyMethodsAtributes.introducirCadena(sc,"el nombre de la persona");
        int edad=MyMethodsAtributes.introducirEntero(sc,"introduce la edad de "+nombre+": ");
        Persona persona=new Persona(nombre,edad);
        File file=new File(dir);
        if (!file.exists()){
            file.mkdir();
        }

        try(ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(dir+fileOut))) {
            os.writeObject(persona);
            System.out.println("Objeto persona serializado y guardado en el directorio: "+dir+fileOut);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }
}
