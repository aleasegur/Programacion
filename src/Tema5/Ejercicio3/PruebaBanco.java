package Tema5.Ejercicio3;

import Tema5.Ejercicio2.PruebaUsuario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PruebaBanco {

    public static void addUsuario(Scanner sc, List<Usuarios> cola) throws Exception {
        String nombre=PruebaUsuario.introducerNombre(sc);
        String dni= PruebaUsuario.introducerDni(sc);
        int edad=PruebaUsuario.introducirEdad(sc);
        Usuarios newUser=new Usuarios(dni,nombre,edad);
        cola.add(newUser);
    }

    public static void atenderUsuario(List<Usuarios> cola){
        if (cola.isEmpty()){
            System.out.println("No hay usuarios a atender");
        }else {
            Usuarios userAtender=cola.removeFirst();
            System.out.println("Usuario atendido y removido de la cola "+userAtender);
        }
    }

    public static void quitarUsuario(Scanner sc,List<Usuarios> cola){
        String dni=PruebaUsuario.introducerDni(sc);
        Iterator<Usuarios> it= cola.iterator();
        boolean encontrar=false;
        while (it.hasNext()){
            Usuarios usuario=it.next();
            if (usuario.getDni().equals(dni)){
                it.remove();
                System.out.println("Usuario: "+usuario+" quitado de la cola");
                encontrar=true;
            }
        }
        if (!encontrar){
            System.err.println("Usuario no encontrado");
        }
    }

    public static void mostrarCola(List<Usuarios> cola){
        if (cola.isEmpty()){
            System.out.println("La cola esta vacia");
        }else{
            System.out.println("---COLA---");
            for (Usuarios usuario : cola){
                System.out.println(usuario);
            }
        }
    }

    public static void showMenu(){
        System.out.println("---Menú de Gestión de Usuarios del Banco---");
        System.out.println("a) Añadir usuario a la lista");
        System.out.println("b) Atender");
        System.out.println("c) Quitar usuario");
        System.out.println("d) Mostrar usuarios en la lista");
        System.out.println("e) Salir");
        System.out.println("Elige una opción: ");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        List<Usuarios>cola=new ArrayList<>();
        boolean atencionCola=true;
        char opcion;
        while (atencionCola){
            showMenu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    addUsuario(sc,cola);
                    break;
                case 'b':
                    atenderUsuario(cola);
                    break;
                case 'c':
                    quitarUsuario(sc,cola);
                    break;
                case 'd':
                    mostrarCola(cola);
                    break;
                case 'e':
                    System.out.println("Saliendo...");
                    atencionCola=false;
                    break;
                default:
                    System.err.println("Opcion introducida no valida");
            }
        }
        sc.close();
    }
}
