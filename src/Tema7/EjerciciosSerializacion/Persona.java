package Tema7.EjerciciosSerializacion;

import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad)throws Exception {
        this.nombre = nombre;
        if (edad>0) {
            this.edad = edad;
        }else{
            throw new Exception("Error la edad no puede ser negativa");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        if (edad>0) {
            this.edad = edad;
        }else{
            throw new Exception("Error la edad no puede ser negativa");
        }
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", edad=" + edad;
    }
}
