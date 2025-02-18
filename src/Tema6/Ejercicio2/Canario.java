package Tema6.Ejercicio2;

public class Canario extends Animal{
    private boolean volar;
    private String color;

    public Canario() {
        volar=true;
        color="";
    }

    public Canario(String name, int edad, double peso, double altura,String color,boolean volar) throws Exception {
        super(name, edad, peso, altura);
        this.volar=volar;
        if (cadenaNoNull(color)) {
            this.color = color;
        }
    }

    public boolean isVolar() {
        return volar;
    }

    public void setVolar(boolean volar) {
        this.volar = volar;
    }

    public String estaVolando(){
        return "El Canario "+getName()+" esta volando";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color)throws Exception {
        if (cadenaNoNull(color)){
            this.color = color;
        }
    }

    public String comer(){
        return "El canario "+getName()+" come ñanmmm";
    }

    public String dormir(){
        return "El canario "+getName()+" duerme zzzzz";
    }

    public String hacerRuido(){
        return "El canario "+getName()+" hace ruido piiipiii";
    }

}
