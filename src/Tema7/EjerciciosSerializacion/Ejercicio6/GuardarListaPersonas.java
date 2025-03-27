package Tema7.EjerciciosSerializacion.Ejercicio6;

import Tema7.EjerciciosSerializacion.Persona;
import Tema7.MyMethodsAtributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*Crea	un	programa	que	permita	guardar	varios	objetos	Persona	en	un	ArrayList.	Serializa	la
lista	completa	en	un	fichero	personas.dat.	Luego,	haz	otro	programa	que	lea	el	fichero	y
muestre	los	datos	de	todas	las	personas.*/
public class GuardarListaPersonas {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Persona> list=addPersonas(sc);
        String fileOut="personas.dat";
        String dir=MyMethodsAtributes.newPathData;
        File file=new File(dir);
        if (!file.exists()){
            file.mkdir();
        }

        try(ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(dir+fileOut))) {
            os.writeObject(list);
            System.out.println("Lista de persona serializado y guardado en el directorio: "+dir+fileOut);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        sc.close();
    }

    public static ArrayList<Persona> addPersonas(Scanner sc){
        ArrayList<Persona> list=new ArrayList<>();
        String nombre;
        int edad;
        boolean inPersona=true;
        char opcion;
        while (inPersona) {
            try {
                nombre = MyMethodsAtributes.introducirCadena(sc, "el nombre de la Persona: ");
                edad = MyMethodsAtributes.introducirEntero(sc, "la edad de " + nombre + ": ");
                Persona persona = new Persona(nombre, edad);
                list.add(persona);
                do {
                    System.out.println("Quieres introducir otra persona a la lista?(s/n)");
                    opcion = sc.next().toLowerCase().charAt(0);
                    if (opcion == 'n') {
                        inPersona = false;
                    }
                }while (opcion!='n'&& opcion!='s');
            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

}
