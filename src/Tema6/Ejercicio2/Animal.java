package Tema6.Ejercicio2;

public class Animal {
    protected String name;
    protected int edad;
    protected double peso,altura;

    public Animal(){
        name="";
        edad=0;
        peso=0;
        altura=0;
    }

    public Animal(String name, int edad, double peso, double altura) {
        this.name = name;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
