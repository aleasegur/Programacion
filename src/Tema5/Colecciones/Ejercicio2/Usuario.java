package Tema5.Colecciones.Ejercicio2;
/*
* Haz una aplicación que permitirá gestionar los usuarios de un gimnasio.
Necesitarás una clase Usuario con los datos del usuario (nombre y edad). La
información de los usuarios se almacenará en un Mapa donde la clave será el
DNI y el valor un objeto de la clase Usuario. La aplicación debe permitir dar de
alta usuarios, dar de baja usuarios, mostrar los datos de un usuario y
modificar usuarios. Debe mostrar mensajes de error si no existe un usuario o
hay cualquier otro problema.*/
public class Usuario {
    private String nombre;
    private int edad;

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
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
        }else {
            throw new Exception("Edad negativa, no esta permitido");
        }
    }

    public static boolean validarDni(String dni){
        boolean res=true;
        if (dni==null || dni.length()!=9) {
            System.err.println("El DNI debe tener 9 caracteres");
            res = false;
        }else {
            String numero = dni.substring(0, 8);
            char letra = dni.charAt(8);

            if (!numero.matches("\\d{8}")) {
                System.err.println("El DNI debe tener 8 digitosd y una letra");
                res = false;
            }

            if (!Character.isLetter(letra)) {
                System.err.println("El DNI debe tener una letra al final");
                res = false;
            }
        }

        return res;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                "edad=" + edad;
    }
}
