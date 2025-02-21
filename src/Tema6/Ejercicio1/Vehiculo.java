package Tema6.Ejercicio1;

public class Vehiculo {
    protected String matricula;
    //Si utiliza gasolina,diesel,electricidad...
    protected String combustible;
    protected int ruedas;

    public Vehiculo(){
        matricula="";
        combustible="";
        ruedas=0;
    }

    public Vehiculo(String matricula, String combustible, int ruedas)throws Exception {
        if (checkMatricula(matricula) && checkCombustibles(combustible) && checkRuedas(ruedas)){
            this.matricula = matricula;
            this.combustible = combustible;
            this.ruedas = ruedas;
        }
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible)throws Exception {
        if (checkCombustibles(combustible)) {
            this.combustible = combustible;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula)throws Exception {
        if (checkMatricula(matricula)) {
            this.matricula = matricula;
        }
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas)throws Exception {
        if (checkRuedas(ruedas)) {
            this.ruedas = ruedas;
        }
    }

    public static boolean checkMatricula(String matricula)throws Exception{
        if (matricula.length()!=7) {
            throw new Exception("Debe tener 7 caracteres la matricula");
        }
        String numero=matricula.substring(0,4);
        if (!numero.matches("\\d{4}")){
            throw new Exception("Los primeros 4 caracteres de la matriicula deben ser numeros");
        }

        String letras=matricula.substring(3).toUpperCase();
        if (letras.matches("[A-Z]{3}")){
            throw new Exception("Los ultimos 3 caracteres de la matricula deben ser letras");
        }
        return true;
    }

    public boolean checkCombustibles(String combustible)throws Exception{
        String[] combustibles=new String[]{"gasolina","diesel","electrico","hidrogeno"};
        for (String tipo : combustibles){
            if (!tipo.equalsIgnoreCase(combustible)){
                return true;
            }
        }
        throw new Exception("El tipo de combustible introducido no existe");
    }

    public static boolean checkRuedas(int ruedas)throws Exception{
        if (ruedas<=0){
            throw new Exception("El numero de ruedas no puede ser menor o igual a 0");
        }
        return true;
    }

}
