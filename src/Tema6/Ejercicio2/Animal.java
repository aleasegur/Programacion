package Tema6.Ejercicio2;

public abstract class Animal {
    protected String name;
    protected int edad;
    protected double peso,altura;

    public Animal(){
        name="";
        edad=0;
        peso=0;
        altura=0;
    }

    public Animal(String name, int edad, double peso, double altura)throws Exception {
        if (numeroNoNegativo(edad) && numeroNoNegativo(peso) && numeroNoNegativo(altura) && cadenaNoNull(name)) {
            this.edad = edad;
            this.peso = peso;
            this.altura = altura;
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name)throws Exception {
        if (cadenaNoNull(name)) {
            this.name = name;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad)throws Exception {
        if (numeroNoNegativo(edad)) {
            this.edad = edad;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso)throws Exception {
        if (numeroNoNegativo(peso)) {
            this.peso = peso;
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura)throws Exception {
        if (numeroNoNegativo(altura)) {
            this.altura = altura;
        }
    }

    public boolean numeroNoNegativo(int num)throws Exception{
        if (num>0) {
            return true;
        }else{
            throw new Exception("El valor no puede ser negativo o nulos");
        }
    }

    public boolean numeroNoNegativo(double num)throws Exception{
        if (num>0) {
            return true;
        }else{
            throw new Exception("El valor no puede ser negativo o nulos");
        }
    }

    public boolean cadenaNoNull(String cadena)throws Exception{
        if (cadena!=null) {
            return true;
        }else{
            throw new Exception("El valor no puede nulo");
        }
    }

    abstract String comer();
    abstract String dormir();
    abstract String hacerRuido();

}
