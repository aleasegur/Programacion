package Tema6.Ejercicio2;

public class Tiburon extends Animal{
    private int aletas;
    private boolean pielRigida;

    public Tiburon() {
    }

    public Tiburon(String name, int edad, double peso, double altura, int aletas, boolean pielRigida) throws Exception {
        super(name, edad, peso, altura);
        if (numeroNoNegativo(aletas)) {
            this.aletas = aletas;
        }
        this.pielRigida = pielRigida;
    }

    public int getAletas() {
        return aletas;
    }

    public void setAletas(int aletas)throws Exception {
        if (numeroNoNegativo(aletas)) {
            this.aletas = aletas;
        }
    }

    public boolean isPielRigida() {
        return pielRigida;
    }

    public void setPielRigida(boolean pielRigida) {
        this.pielRigida = pielRigida;
    }

    public String nadar(){
        return "El tiburon "+getName()+" esta nadando";
    }

    @Override
    public String comer(){
        return "El tiburon "+getName()+" come ñanmmm";
    }

    @Override
    public String dormir(){
        return "El tiburon "+getName()+" duerme zzzzz";
    }

    @Override
    public String hacerRuido(){
        return "El tiburon "+getName()+" hace ruido piiipiii";
    }

    @Override
    public String toString() {
        return "Tiburon{" +
                "aletas=" + aletas +
                ", pielRigida=" + pielRigida +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
