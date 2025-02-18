package Tema6.Ejercicio2;

public class Gato extends Animal{
    private String colorPatron,colorOjos;

    public Gato() {
        colorOjos = "";
        colorPatron = "";
    }

    public Gato(String name, int edad, double peso, double altura, String colorOjos, String colorPatron) throws Exception {
        super(name, edad, peso, altura);
        if (cadenaNoNull(colorOjos) &&  cadenaNoNull(colorPatron)) {
            this.colorOjos = colorOjos;
            this.colorPatron = colorPatron;
        }
    }

    public String getColorPatron() {
        return colorPatron;
    }

    public void setColorPatron(String colorPatron) throws Exception {
        if (cadenaNoNull(colorPatron)) {
            this.colorPatron = colorPatron;
        }
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public void setColorOjos(String colorOjos) throws Exception {
        if (cadenaNoNull(colorOjos)) {
            this.colorOjos = colorOjos;
        }
    }

    public String comer(){
        return "El gato "+getName()+" come ñanmmm";
    }

    public String dormir(){
        return "El gato "+getName()+" duerme zzzzz";
    }

    public String hacerRuido(){
        return "El gato "+getName()+" hace ruido piiipiii";
    }
}
