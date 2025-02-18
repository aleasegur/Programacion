package Tema6.Ejercicio2;

public class Cocodrilo extends Animal{
    private int dientes;
    private boolean escamas;

    public Cocodrilo() {
        dientes=68;
        escamas=true;
    }

    public Cocodrilo(String name, int edad, double peso, double altura,int dientes,boolean escamas) throws Exception {
        super(name, edad, peso, altura);
        if (numeroNoNegativo(dientes)) {
            this.dientes = dientes;
        }
        this.escamas=escamas;
    }

    public int getDientes() {
        return dientes;
    }

    public void setDientes(int dientes)throws Exception {
        if (numeroNoNegativo(dientes)) {
            this.dientes = dientes;
        }
    }

    public boolean isEscamas() {
        return escamas;
    }

    public void setEscamas(boolean escamas) {
        this.escamas = escamas;
    }

    public String comer(){
        return "El cocodrilo "+getName()+" come ñanmmm";
    }

    public String dormir(){
        return "El cocodrilo "+getName()+" duerme zzzzz";
    }

    public String hacerRuido(){
        return "El cocodrilo "+getName()+" hace ruido piiipiii";
    }

}
