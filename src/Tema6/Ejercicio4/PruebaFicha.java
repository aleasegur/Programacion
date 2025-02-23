package Tema6.Ejercicio4;

import Tema6.Ejercicio3.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaFicha {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Ficha> lista=new ArrayList<>();
        boolean buclePrincipal=true;
        char opcion;
        while (buclePrincipal){
            try {
                showMe();
                opcion=sc.next().toLowerCase().charAt(0);
                switch (opcion){
                    case 'a':
                        addFichas(sc,lista);
                        break;
                    case 'b':
                        mostrarFichas(sc,lista);
                        break;
                    case 'c':
                        System.out.println("Saliendo...");
                        buclePrincipal=false;
                        break;
                    default:
                        System.err.println("Opcion invalida");
                }
            }catch (Exception e){
                System.err.println("Error "+e.getMessage());
            }
        }
        sc.close();

    }

    public static void mostrarFichas(Scanner sc,ArrayList<Ficha> lista){
        int num;
        try {
            do {
                showSubMenu();
                num = sc.nextInt();
                if (num <= 0 || num > 3) {
                    System.err.println("Valor introducido no correcto");
                }
            } while (num < 0 || num > 3);

            if (lista.isEmpty()) {
                System.out.println("La lista esta vacia");
            } else {
                boolean encontrado=false;
                for (Ficha ficha : lista) {
                    if (num == 1 && ficha instanceof Libros ||
                            num == 2 && ficha instanceof Revista ||
                            num == 3 && ficha instanceof Dvd) {
                        System.out.println(ficha);
                        encontrado=true;
                    }
                }
                if (!encontrado){
                    System.out.println("No hay ficha de ese tipo en la lista");
                }
            }
        } catch (InputMismatchException | ArithmeticException e) {
            System.err.println("Error " + e.getMessage());
            sc.nextLine();
        }
    }

    public static void addFichas(Scanner sc,ArrayList<Ficha> lista){
        int numero=0,opcion;
        String titulo="";
        boolean entrar=true;
        while (entrar){
            try {
                showSubMenu();
                opcion = sc.nextInt();
                if (opcion==1 || opcion==2 || opcion==3) {
                    numero = introducirEntero(sc, " el numero ", " la ficha siguiente");
                    titulo = introducirCadena(sc, "el titulo", "la ficha siguiente");
                }
                switch (opcion){
                    case 1:
                        String editorial=introducirCadena(sc,"editorial","libro");
                        String autor=introducirCadena(sc,"autor","libro");
                        Libros libros=new Libros(numero,titulo,editorial,autor);
                        lista.add(libros);
                        entrar=false;
                        break;
                    case 2:
                        int numPub=introducirEntero(sc,"numero de publicacion","la revista");
                        int yearRevista=introducirEntero(sc,"el año ","la revista");
                        Revista revista=new Revista(numero,titulo,numPub,yearRevista);
                        lista.add(revista);
                        entrar=false;
                        break;
                    case 3:
                        String director=introducirCadena(sc,"director","dvd");
                        int yearDvd=introducirEntero(sc,"año","dvd");
                        Tipo tipo=introducirTipo(sc);
                        Dvd dvd=new Dvd(numero,titulo,director,yearDvd,tipo);
                        lista.add(dvd);
                        entrar=false;
                        break;
                    default:
                        System.err.println("Opcion invalida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
            }
        }
    }

    public static String introducirCadena(Scanner sc,String atributo,String ficha) throws Exception {
        String cadena="";
        try {
            System.out.println("Introduce el " + atributo + " de " + ficha + " :");
            sc.nextLine();
            cadena = sc.nextLine();
        } catch (InputMismatchException e) {
            System.err.println("Error " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        return cadena;
    }

    public static int introducirEntero(Scanner sc,String atributo,String ficha) throws Exception {
        int num=0;
        do{
            try {
                System.out.println("Introduce el " + atributo + " de " + ficha + " :");
                num = sc.nextInt();
            }catch (InputMismatchException e){
                System.err.println("Error "+e.getMessage());
            }catch (Exception e){
                System.err.println("Error "+e.getMessage());
            }
        }while (!Ficha.validateNum(num));
        return num;
    }

    public static Tipo introducirTipo(Scanner sc){
        int opcion;
        boolean bucle=true;
        Tipo tipoGenero=null;
        while (bucle) {
            try {
                showTipos();
                opcion=sc.nextInt();
                switch (opcion){
                    case 1:
                        tipoGenero=Tipo.ANIMACION;
                        bucle=false;
                        break;
                    case 2:
                        tipoGenero=Tipo.ACCION;
                        bucle=false;
                        break;
                    case 3:
                        tipoGenero=Tipo.DOCUMENTAL;
                        bucle=false;
                        break;
                    case 4:
                        tipoGenero=Tipo.CIENCIA_FICCION;
                        bucle=false;
                        break;
                    default:
                        System.err.println("Opcion invalida");
                }

            } catch (InputMismatchException e) {
                System.err.println("Error " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
            }
        }
        return tipoGenero;
    }

    public static void showMe(){
        System.out.println("a).Instanciar ficha");
        System.out.println("b).Mostrar ficha");
        System.out.println("c).Salir");
        System.out.println("Elegir opcion: ");
    }

    public static void showSubMenu(){
        System.out.println("1.Libros");
        System.out.println("2.Revista");
        System.out.println("3.DVD");
        System.out.println("Elegir opcion: ");
    }

    //ANIMACION,
    //ACCION,
    //DOCUMENTAL,
    //CIENCIA_FICCION
    public static void showTipos(){
        System.out.println("--TIPOS DE GENEROS EN DVD--");
        System.out.println("1.Animacion");
        System.out.println("2.Accion");
        System.out.println("3.Documental");
        System.out.println("4.Ciencia Ficcion");
        System.out.println("Elegir opcion: ");
    }
}
