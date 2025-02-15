package Tema6.Ejercicio1;

public class Ciclomotor extends Vehiculo {
    private int cilindrana;

    public Ciclomotor() {
        super();
        cilindrana=0;
    }

    public Ciclomotor(String matricula, String combustible, int ruedas, int cilindrana) throws Exception {
        super(matricula, combustible, ruedas);
        if (checkCilindrana(cilindrana)) {
            this.cilindrana = cilindrana;
        }
    }

    public int getCilindrana() {
        return cilindrana;
    }

    public void setCilindrana(int cilindrana)throws Exception {
        if (checkCilindrana(cilindrana)) {
            this.cilindrana = cilindrana;
        }
    }

    public boolean checkCilindrana(int cilin)throws Exception{
        if (cilin<=0){
            throw new Exception("El valor no puede ser menor o igual a 0");
        }
        return true;
    }

    public boolean necesitaCarnet(int cilindrana){
        if (cilindrana>=125){
            System.out.println("Se necesita carnet");
            return true;
        }
        return false;
    }
}
