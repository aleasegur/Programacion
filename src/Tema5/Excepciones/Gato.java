package Tema5.Excepciones;

public class Gato {
    private String name;
    private int edad;

    public Gato() {
        name="Ben";
        edad=0;
    }

    public Gato(String name, int edad)throws Exception {
        if (name.length()==3 && edad>=0) {
            this.name = name;
            this.edad = edad;
        }else {
            throw new Exception("La edad no debe ser negativo y el nombre debe tener 3 carcteres.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name)throws Exception{
        if (name.length()==3) {
            this.name = name;
        }else {
            throw new Exception("El nombre debe tener 3 caracteres.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad)throws Exception {
        if (edad>=0) {
            this.edad = edad;
        }else{
            throw new Exception("La edad no puede ser negativa");
        }
    }

    public void imprimir(){
        System.out.println("------------------------------");
        System.out.println("Nombre: "+name+"\nEdad: "+edad);
    }

}
