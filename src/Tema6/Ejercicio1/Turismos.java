package Tema6.Ejercicio1;

public class Turismos extends Vehiculo{
    private int numPlazas;
    private TipoUso tipoUso;

    public Turismos(){
        super();
        numPlazas = 0;
        tipoUso = null;
    }

    public Turismos(String matricula, String combustible, int ruedas, int numPlazas, TipoUso tipoUso) throws Exception {
        super(matricula, combustible, ruedas);
        if (checkPlazas(numPlazas)) {
            this.numPlazas = numPlazas;
        }
        this.tipoUso = tipoUso;
    }

    public TipoUso getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(TipoUso tipoUso) {
        this.tipoUso = tipoUso;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas)throws Exception {
        if (checkPlazas(numPlazas)) {
            this.numPlazas = numPlazas;
        }
    }

    public static boolean checkPlazas(int num)throws Exception{
        if (num<=0){
            throw new Exception("El numero de plazas no pude ser menor o igual a 0");
        }
        return true;
    }

    /*
    public boolean checkTipoUso(String uso)throws Exception{
        String[] tiposDeUso=new String[]{"profesional","particular"};
        for (String tipos : tiposDeUso){
            if (tipos.equalsIgnoreCase(uso)){
                return true;
            }
        }
        throw new Exception("El tipo de uso introducido no es correcto");
    }
    */

    @Override
    public String toString() {
        return "Turismos{" +
                "numPlazas=" + numPlazas +
                ", tipoUso=" + tipoUso +
                ", matricula='" + matricula + '\'' +
                ", combustible='" + combustible + '\'' +
                ", ruedas=" + ruedas +
                '}';
    }
}
