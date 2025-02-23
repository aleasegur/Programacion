package Tema6.Ejercicio3;

public class Circulo extends Figura2D{
    private double radio;

    public Circulo(){
        radio=0;
    }

    public Circulo(double radio) throws Exception {
        if (valorNoNegativo(radio)) {
            this.radio = radio;
        }
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) throws Exception {
        if (valorNoNegativo(radio)) {
            this.radio = radio;
        }
    }

    @Override
    public double perimetro() {
        return 2*Math.PI *radio;
    }

    @Override
    public double area() {
        return Math.PI*radio*radio;
    }

    @Override
    public String toString() {
        return "Circulo{\nRadio: "+radio+"\nArea: "+area()+"\nPerimetro: "+perimetro()+"}";
    }
}
