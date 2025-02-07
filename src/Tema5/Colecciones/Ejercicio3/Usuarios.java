package Tema5.Colecciones.Ejercicio3;

public class Usuarios {
    private String dni,nombre;
    private int edad;

    public Usuarios(){
        dni="";
        nombre="";
        edad=0;
    }

    public Usuarios(String dni, String nombre, int edad)throws Exception {
        if (Tema5.Colecciones.Ejercicio2.Usuario.validarDni(dni)) {
            this.dni = dni;
        }else{
            throw new Exception("Error:El DNI no es correcto");
        }
        this.nombre = nombre;
        if (edad>0) {
            this.edad = edad;
        }else {
            throw new Exception("Error edad no puede ser nagativo");
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni)throws Exception {
        if (Tema5.Colecciones.Ejercicio2.Usuario.validarDni(dni)) {
            this.dni = dni;
        }else{
            throw new Exception("Error:El DNI no es correcto");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad)throws Exception {
        if (edad>0) {
            this.edad = edad;
        }else {
            throw new Exception("Error edad no puede ser nagativo");
        }
    }

    @Override
    public String toString() {
        return "DNI:'" + dni + '\'' +
                ", Nombre:'" + nombre + '\'' +
                ", Edad:" + edad;
    }
}
