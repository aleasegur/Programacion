package Tema5.Ejercicio4;

import Tema5.Ejercicio1.Producto;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PruebaProductoAmpliado {
    public static void addProducto(Scanner sc, Set<Producto> lista){
        String nombre="";
        try {
            do {
                System.out.println("Introduce el nombre del producto: ");
                nombre = sc.next();
            }while (Producto.comprobarRepeticionProducto(nombre,lista));
        }catch (StringIndexOutOfBoundsException strex){
            System.err.println("Error: "+strex.getMessage());
        }
        Producto nuevoProducto=new Producto(nombre);
        lista.add(nuevoProducto);
        System.out.println("Producto "+nombre+" agregado a la lista");
    }

    public static void mostrarProductosCarroYLista(Set<Producto> lista,Set<Producto> carro){
        Set<Producto> productosCarro=new HashSet<>(lista);
        productosCarro.retainAll(carro);

        Set<Producto> productosFalta=new HashSet<>(lista);
        productosFalta.removeAll(carro);
        System.out.println("---PRODUCTOS EN EL CARRO Y LISTA---");
        System.out.println("Productos en el carro: ");
        mostrarProductos(productosCarro);
        System.out.println("Productos faltantes: ");
        mostrarProductos(productosFalta);
    }

    public static void mostrarProductos(Set<Producto> lista){
        if (lista.isEmpty()){
            System.out.println("Esta vacio la compra");
        }else {
            for (Producto producto : lista) {
                System.out.println(producto.getNombre());
            }
        }
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
                    addProducto(sc, lista);
                    break;
                case 'b':
                    mostrarProductos(lista);
                    break;
                case 'c':
                    addProducto(sc,carro);
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
