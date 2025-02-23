package Tema6.Ejercicio3;

import Tema6.Ejercicio2.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.jar.Manifest;

public class PruebaFiguras2D {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList<Figura2D> lista=new ArrayList<>();
        boolean buclePrincipal=true;
        char opcion;
        while (buclePrincipal){
            try {
                showMenu();
                opcion = sc.next().toLowerCase().charAt(0);
                switch (opcion) {
                    case 'a':
                        addFiguras(sc, lista);
                        break;
                    case 'b':
                        mostrarLista(sc, lista);
                        break;
                    case 'c':
                        System.out.println("Saliendo...");
                        buclePrincipal = false;
                        break;
                    default:
                        System.err.println("Opcion no correcta");
                }
            }catch (Exception e){
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void addFiguras(Scanner sc,ArrayList<Figura2D> lista){
        boolean entrar=true;
        int opcion;
        while (entrar){
            try {
                subMenu();
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        double base=crearDouble(sc,"base","rectangulo");
                        double altura=crearDouble(sc,"altura","ractangulo");
                        Rectangulo rectangulo=new Rectangulo(base,altura);
                        lista.add(rectangulo);
                        entrar=false;
                        break;
                    case 2:
                        double lado=crearDouble(sc,"lado","cuadrado");
                        Cuadrado cuadrado=new Cuadrado(lado);
                        lista.add(cuadrado);
                        entrar=false;
                        break;
                    case 3:
                        double lado1,lado2,lado3;
                        do {
                            lado1 = crearDouble(sc, "lado 1", "triangulo");
                            lado2 = crearDouble(sc, "lado 2", "triangulo");
                            lado3 = crearDouble(sc, "lado 3", "triangulo");
                        }while (!Triangulo.checkTriangulo(lado1,lado2,lado3));
                        Triangulo triangulo=new Triangulo(lado1,lado2,lado3);
                        lista.add(triangulo);
                        entrar=false;
                        break;
                    case 4:
                        double radio=crearDouble(sc,"radio","circulo");
                        Circulo circulo=new Circulo(radio);
                        lista.add(circulo);
                        entrar=false;
                        break;
                    default:
                        System.err.println("Opcion onvalida");
                }
            }catch (InputMismatchException | ArithmeticException e){
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void mostrarLista(Scanner sc,ArrayList<Figura2D> lista){
        int num;
        try {
            do {
                subMenu();
                num = sc.nextInt();
                if (num <= 0 || num > 4) {
                    System.err.println("Valor introducido no correcto");
                }
            } while (num < 0 || num > 4);

            if (lista.isEmpty()) {
                System.out.println("La lista esta vacia");
            } else {
                boolean encontrado=false;
                for (Figura2D figura : lista) {
                    if (num == 1 && figura instanceof Rectangulo ||
                            num == 2 && figura instanceof Cuadrado ||
                            num == 3 && figura instanceof Triangulo ||
                            num == 4 && figura instanceof Circulo) {
                        System.out.println(figura);
                        encontrado=true;
                    }
                }
                if (!encontrado){
                    System.out.println("No hay animal de ese tipo en la lista");
                }
            }
        } catch (InputMismatchException | ArithmeticException e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
            sc.nextLine();
        }
    }

    public static double crearDouble(Scanner sc,String atributo,String figura) throws Exception {
        double num=0;
        do {
            try {
                System.out.println("Introduce el valor de "+atributo+" del "+figura+" :");
                num=sc.nextDouble();
            } catch (InputMismatchException | ArithmeticException e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
                e.printStackTrace();
            }
        }while (!Figura2D.valorNoNegativo(num));
        return num;
    }

    public static void subMenu(){
        System.out.println("1.Rectangulo");
        System.out.println("2.Cuadrado");
        System.out.println("3.Triangulo");
        System.out.println("4.Circulo");
        System.out.println("Elegir opcion: ");
    }

    public static void showMenu(){
        System.out.println("a).Instanciar figuras2D");
        System.out.println("b).Mostrar Figuras2D");
        System.out.println("c).Salir");
        System.out.println("Elegir opcion: ");
    }

}
