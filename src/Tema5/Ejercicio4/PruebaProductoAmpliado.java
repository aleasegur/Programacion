package Tema5.Ejercicio4;

import Tema5.Ejercicio1.Producto;
import Tema5.Ejercicio1.PruebaProducto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PruebaProductoAmpliado {

    public static void mostrarProductosCarroYLista(Set<Producto> lista,Set<Producto> carro){
        Set<Producto> productosCarro=new HashSet<>(lista);
        productosCarro.retainAll(carro);

        Set<Producto> productosFalta=new HashSet<>(lista);
        productosFalta.removeAll(carro);
        System.out.println("---PRODUCTOS EN EL CARRO Y LISTA---");
        System.out.println("Productos en el carro: ");
        PruebaProducto.mostrarProductos(productosCarro);
        System.out.println("Productos faltantes: ");
        PruebaProducto.mostrarProductos(productosFalta);
    }

    public static void showMenu(){
        System.out.println("a).Añadir productos en la lista.");
        System.out.println("b).Mostrar Lista.");
        System.out.println("c).Añadir productos en el carro");
        System.out.println("d).Mostrar productos en el carro y si falta añdir segun la lista");
        System.out.println("e).Salir.");
        System.out.println("Elegir opcion: ");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Producto> lista=new HashSet<>();
        Set<Producto> carro=new HashSet<>();
        char opcion;
        boolean bucle=true;
        while (bucle) {
            showMenu();
            opcion=sc.next().charAt(0);
            switch (opcion) {
                case 'a':
                    PruebaProducto.addProducto(sc, lista);
                    break;
                case 'b':
                    PruebaProducto.mostrarProductos(lista);
                    break;
                case 'c':
                    PruebaProducto.addProducto(sc,carro);
                    break;
                case 'd':
                    mostrarProductosCarroYLista(lista,carro);
                    break;
                case 'e':
                    System.out.println("Saliendo...");
                    bucle=false;
                    break;
                default:
                    System.err.println("Opcion introducida no existe.Vuelva a introducir");
            }
        }
        sc.close();
    }
}
