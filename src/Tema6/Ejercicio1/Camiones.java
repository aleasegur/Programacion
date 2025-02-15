package Tema6.Ejercicio1;

public class Camiones extends Vehiculo {
    private static final int PESO_MAX=3500;
    private int peso;
    private boolean mercanciaPeligrosa;

    public Camiones() throws Exception {
        super();
        peso=0;
        mercanciaPeligrosa=false;
    }

    public Camiones(String matricula, String combustible, int ruedas, int peso, boolean mercanciaPeligrosa) throws Exception {
        super(matricula, combustible, ruedas);
        if (checkPeso(peso)) {
            this.peso = peso;
        }
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso)throws Exception {
        if (checkPeso(peso)) {
            this.peso = peso;
        }
    }

    public boolean isMercanciaPeligrosa() {
        return mercanciaPeligrosa;
    }

    public void setMercanciaPeligrosa(boolean mercanciaPeligrosa) {
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    public boolean checkPeso(int peso)throws Exception{
        if (peso<=0 || peso>PESO_MAX){
            throw new Exception("El peso no puede ser menor o igual a 0, ni mayor a 3500");
        }
        return true;
    }

}
