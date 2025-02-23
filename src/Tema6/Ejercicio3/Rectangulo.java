package Tema6.Ejercicio3;

public class Rectangulo extends Figura2D{
    private double base,altura;

    public Rectangulo(){
        base=0;
        altura=0;
    }

    public Rectangulo(double base, double altura) throws Exception {
        if (valorNoNegativo(base) && valorNoNegativo(altura)) {
            this.base = base;
            this.altura = altura;
        }
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) throws Exception {
        if (valorNoNegativo(base)) {
            this.base = base;
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) throws Exception {
        if (valorNoNegativo(altura)) {
            this.altura = altura;
        }
    }

    @Override
    public double area() {
        return base*altura;
    }

    @Override
    public double perimetro() {
        return 2*(base+altura);
    }

    @Override
    public String toString() {
        return "Rectangulo{\nBase: "+base+"\nAltura: "+altura+"\n"+super.toString()+" }";
    }
}
