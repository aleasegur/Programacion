package Tema5.Excepciones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
    public static String arrayMostrar(List<Gato> gatos) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < gatos.size(); i++) {
            if (gatos.get(i) == null) {
                sb.append(".");//Posicion vacia
            } else {
                sb.append("X");//Posicion ocupada
            }
            if (i < gatos.size() - 1) {
                sb.append(", ");//en cada espacio de la posicion pongo coma(,)
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void instanciarGato(Scanner sc,List<Gato> gatos) throws Exception {
        String name;
        int edad;
        System.out.println("Introduce el nombre del gato: ");
        name=sc.next();
        System.out.println("Introduce la edad del gato: ");
        edad= sc.nextInt();
        Gato newGato=new Gato(name,edad);
        gatos.add(newGato);
        System.out.println(arrayMostrar(gatos));
    }

    public static void mostrarGatos(List<Gato> gatos){
        for (Gato gato : gatos){
            if (gato!=null){
                gato.imprimir();
            }
        }
    }

    public static void cambiarValoresGato(List<Gato> gatos,Scanner sc)throws Exception{
        String name;
        int edad,indice;
        System.out.println(arrayMostrar(gatos));
        try {
            System.out.println("Elige que gato quieres cambiar los valores(1-"+gatos.size()+",selecciona las casillas marcadas en X): ");
            indice = sc.nextInt() - 1;
            System.out.println("Introduce el nombre del gato: ");
            name = sc.next();
            System.out.println("Introduce la edad del gato: ");
            edad = sc.nextInt();
            Gato gatoSelec=gatos.get(indice);
            gatoSelec.setName(name);
            gatoSelec.setEdad(edad);
        }catch (InputMismatchException e){
            System.err.println("Error "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void showMenu(){
        System.out.println("a).Instanciar Gatos");
        System.out.println("b).Cambiar valores de un gato");
        System.out.println("c).Mostrar gatos");
        System.out.println("d).Salir");
        System.out.println("Elegir opcion: ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        List<Gato> gatos=new ArrayList<>();
        char opcion;
        boolean bucle=true;
        while (bucle){
            showMenu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    instanciarGato(sc,gatos);
                    break;
                case 'b':
                    cambiarValoresGato(gatos,sc);
                    break;
                case 'c':
                    mostrarGatos(gatos);
                    break;
                case 'd':
                    System.out.println("Saliendo...");
                    bucle=false;
                    break;
                default:
                    System.err.println("Opcion incorrecta, vuelva a introducirlo");
            }
        }
    }
}
