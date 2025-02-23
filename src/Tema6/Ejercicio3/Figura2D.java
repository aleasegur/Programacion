package Tema6.Ejercicio3;

public abstract class Figura2D {

    public static boolean valorNoNegativo(double num)throws Exception{
        if (num>0){
            return true;
        }else {
            throw new Exception("El valor no puede ser negativo");
        }
    }

    public static boolean valorNoNegativo(int num)throws Exception{
        if (num>0){
            return true;
        }else {
            throw new Exception("El valor no puede ser negativo");
        }
    }

    public abstract double area();

    public abstract double perimetro();

    @Override
    public String toString(){
        return "Area: "+area()+"\nPerimetro: "+perimetro();
    }

}
