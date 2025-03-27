package Tema7.EjerciciosSerializacion;

import Tema7.MyMethodsAtributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*Lee	el	objeto	Persona	del	fichero	persona.dat	y	muestra	sus	datos	en	consola.*/
public class Ejercicio5 {
    public static void main(String[] args) {
        String dir= MyMethodsAtributes.newPathData;
        String fileOut="persona.dat";
        try(ObjectInputStream oi=new ObjectInputStream(new FileInputStream(dir+fileOut))) {
            Persona persona=(Persona) oi.readObject();
            System.out.println("Objeto leido: "+persona);
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}
