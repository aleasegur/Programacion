package Tema6.Ejercicio3;

public class Triangulo extends Figura2D {
    private double lado1,lado2,lado3;

    public Triangulo(){
        lado1=0;
        lado2=0;
        lado3=0;
    }

    public Triangulo(double lado1, double lado2, double lado3) throws Exception {
        if (checkTriangulo(lado1,lado2,lado3) && valorNoNegativo(lado1) && valorNoNegativo(lado2) && valorNoNegativo(lado3)){
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        }
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) throws Exception {
        if (checkTriangulo(lado1,this.lado2,this.lado3) && valorNoNegativo(lado1)) {
            this.lado1 = lado1;
        }
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) throws Exception {
        if (checkTriangulo(this.lado1,lado2,this.lado3) && valorNoNegativo(lado2)) {
            this.lado2 = lado2;
        }
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) throws Exception {
        if (checkTriangulo(this.lado1,this.lado2,lado3) && valorNoNegativo(lado3)) {
            this.lado3 = lado3;
        }
    }

    // ValidO la existencia del triAngulo,cada lado debe ser menor que la suma de los otros dos.
    public static boolean checkTriangulo(double lado1, double lado2,double lado3)throws Exception{
        if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
            throw new Exception("Los lados no pueden formar un triangulo");
        }
        return true;
    }

    @Override
    public double perimetro() {
        return lado1+lado2+lado3;
    }

    //Utilizo la formula de Heron para calcular el area del triangulo,primero necesito calcular el semiperimetro (s) del triangulo
    //que es el perimetro dividido por 2, y despues hago una raiz cuadrada y multiplico s por la resta de s menos cada lado
    //Es util porque no requiere conocer la altura del triangulo
    @Override
    public double area() {
        double s=perimetro()/2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    @Override
    public String toString() {
        return "Triangulo{\nLados: "+lado1+","+lado2+","+lado3+ super.toString()+"}";
    }
}
