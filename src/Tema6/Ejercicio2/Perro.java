package Tema6.Ejercicio2;

public class Perro extends Animal{
    private String raza;
    private boolean hocicoCorto;

    public Perro() {
        raza="";
        hocicoCorto=true;
    }

    public Perro(String name, int edad, double peso, double altura, String raza, boolean hocicoCorto) throws Exception {
        super(name, edad, peso, altura);
        this.raza = raza;
        this.hocicoCorto = hocicoCorto;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isHocicoCorto() {
        return hocicoCorto;
    }

    public void setHocicoCorto(boolean hocicoCorto) {
        this.hocicoCorto = hocicoCorto;
    }

    public String rastreando(){
        return "El perro "+getName()+" esta rastreando";
    }

    @Override
    public String comer(){
        return "El perro "+getName()+" come ñanmmm";
    }

    @Override
    public String dormir(){
        return "El perro "+getName()+" duerme zzzzz";
    }

    @Override
    public String hacerRuido(){
        return "El perro "+getName()+" hace ruido piiipiii";
    }

    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                ", hocicoCorto=" + hocicoCorto +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
