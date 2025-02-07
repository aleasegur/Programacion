package Tema5.Colecciones.Ejercicio1;

import java.util.Objects;
import java.util.Set;

/*ALEJANDRO ASENCIO GURAU
* Haz una aplicación que permita crear una lista de la compra. Leerá por
consola varios productos y los guardará todos en un set. Si intentas guardar
dos veces el mismo producto te avisará que ya existe el producto.*/
public class Producto {
    private String nombre;

    public Producto(){
        nombre="";
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public static boolean comprobarRepeticionProducto(String nombre, Set<Producto> lista){
        for (Producto producto : lista){
            if (nombre.equals(producto.getNombre())){
                System.err.println("El producto introducido ya existe");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
