package Tema5.Ejercicio1;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PruebaProducto {

    public static void addProducto(Scanner sc,Set<Producto> lista){
        String nombre="";
        try {
            do {
                System.out.println("Introduce el nombre del producto: ");
                nombre = sc.next().toLowerCase();
            }while (Producto.comprobarRepeticionProducto(nombre,lista));
        }catch (StringIndexOutOfBoundsException strex){
            System.err.println("Error: "+strex.getMessage());
        }
        Producto nuevoProducto=new Producto(nombre);
        lista.add(nuevoProducto);
        System.out.println("Producto "+nombre+" agregado a la lista");
    }

    public static void mostrarProductos(Set<Producto> lista){
        if (lista.isEmpty()){
            System.out.println("Esta completo la compra");
        }else {
            for (Producto producto : lista) {
                System.out.println(producto.getNombre());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Producto> lista=new HashSet<>();
        char opcion;
        boolean bucle=true;
        while (bucle) {
            System.out.println("a).Añadir productos en la lista.");
            System.out.println("b).Mostrar Lista.");
            System.out.println("c).Salir.");
            System.out.println("Elegir opcion: ");
            opcion=sc.next().charAt(0);
            switch (opcion) {
                case 'a':
                addProducto(sc, lista);
                break;

                case 'b':
                    mostrarProductos(lista);
                    break;

                case 'c':
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
