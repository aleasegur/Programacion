package Tema6.Ejercicio3;

public class Cuadrado extends Rectangulo{

    public Cuadrado() {
        super();
    }

    //Llamo al constructor de Rectangulo,usando el mismo valor de base y altura
    public Cuadrado(double lado) throws Exception {
        super(lado, lado);
    }

    @Override
    public String toString() {
        return "Cuadrado {\nLado: " + getBase() + "\nArea: " + area() + "\nPerimetro: " + perimetro()+"}";
    }
}
