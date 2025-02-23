package Tema6.Ejercicio4;

public class Ficha {
    protected int numero;
    protected String titulo;

    public Ficha(){
        numero=0;
        titulo="";
    }

    public Ficha(int numero, String titulo) throws Exception {
        if (validateNum(numero) && validateCadena(titulo)) {
            this.numero = numero;
        }
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if (validateNum(numero)) {
            this.numero = numero;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if (validateCadena(titulo)) {
            this.titulo = titulo;
        }
    }

    public static boolean validateNum(int num)throws Exception{
        if (num>=0){
            return true;
        }else {
            throw new Exception("Error el numero no puede ser negativo");
        }
    }

    public static boolean validateCadena(String cadena)throws Exception{
        if (cadena!=null){
            return true;
        }else {
            throw new Exception("Error no puede ser nulo");
        }
    }

    @Override
    public String toString() {
        return "\nNumero:" + numero + "\nTitulo:" + titulo;
    }
}
