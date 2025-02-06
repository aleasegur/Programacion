package Tema5.Ejercicio2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class PruebaUsuario {

    public static String introducerDni(Scanner sc){
        String dni;
        do {
            System.out.println("Introduce el dni: ");
            dni=sc.next().toUpperCase();
        }while (!Usuario.validarDni(dni));
        return dni;
    }

    public static String introducerNombre(Scanner sc){
        String nombre;
        System.out.println("Introduce un nombre: ");
        nombre=sc.next();
        return nombre;
    }

    public static int introducirEdad(Scanner sc){
        int edad=0;
        do {
            try {
                System.out.println("Introduce la edad: ");
                edad = sc.nextInt();
                if (edad < 0) {
                    System.err.println("Edad no puede ser negativo");
                }
            }catch (InputMismatchException e){
                System.err.println("Error: Introduce un numero valido.");
                sc.next();
            }
        }while (edad<0);
        sc.nextLine();
        return edad;
    }

    public static void altaUsuario(Scanner sc,Map<String,Usuario> sistema){
        String nombre,dni;
        int edad;
        dni=introducerDni(sc);
        if (sistema.containsKey(dni)){
            System.out.println("El usuario con este dni existe");
        }else {
            nombre = introducerNombre(sc);
            edad = introducirEdad(sc);
            sistema.put(dni, new Usuario(nombre, edad));
            System.out.println("Usuario registrado");
        }
    }

    public static void mostrarUsuarios(Map<String,Usuario> sistema){
        if (sistema.isEmpty()){
            System.out.println("No hay usuarios registrados");
        }else {
            for (Map.Entry<String, Usuario> entry : sistema.entrySet()) {
                System.out.println("DNI: " + entry.getKey() + "\nUsuario: " + entry.getValue());
            }
        }
    }

    public static void bajaUsuario(Scanner sc,Map<String,Usuario> sistema){
        String dni=introducerDni(sc);
        if (sistema.remove(dni)!=null){
            System.out.println("Usuario se ha dado de baja");
        }else {
            System.out.println("El usuario no existe");
        }
    }

    public static void showMenu(){
        System.out.println("Gestion de Usuarios del Gimnasio");
        System.out.println("a). Alta de usuario");
        System.out.println("b). Mostrar usuarios");
        System.out.println("c). Baja de usuario");
        System.out.println("d). Modificar usuario");
        System.out.println("e). Salir");
        System.out.println("Seleccione una opción: ");
    }

    public static void modificarUsuario(Scanner sc,Map<String,Usuario> sistema) throws Exception {
        String dni=introducerDni(sc);
        Usuario usuario=sistema.get(dni);
        if (usuario==null){
            System.err.println("El usuario no existe");
        }else {
            System.out.println("---NUEVOS DATOS DEL USUARIO---");
            String newName = introducerNombre(sc);
            int edad = introducirEdad(sc);
            usuario.setNombre(newName);
            usuario.setEdad(edad);
            System.out.println("Usuario actualizado");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Map<String,Usuario> sistema=new HashMap<>();
        boolean buclegimnasio=true;
        char opcion;
        while (buclegimnasio){
            showMenu();
            opcion=sc.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':
                    altaUsuario(sc,sistema);
                    break;
                case 'b':
                    mostrarUsuarios(sistema);
                    break;
                case 'c':
                    bajaUsuario(sc,sistema);
                    break;
                case 'd':
                    modificarUsuario(sc,sistema);
                    break;
                case 'e':
                    System.out.println("Saliendo...");
                    buclegimnasio=false;
                    break;
                default:
                    System.err.println("Opcion invalida.Vuelva a introducir");
            }
        }
        sc.close();
    }
}
