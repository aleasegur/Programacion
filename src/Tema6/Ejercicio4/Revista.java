package Tema6.Ejercicio4;

public class Revista extends Ficha{
    private int numPubli,year;

    public Revista() {
        super();
        numPubli=0;
        year=0;
    }

    public Revista(int numero, String titulo, int numPubli, int year) throws Exception {
        super(numero, titulo);
        if (validateNum(numPubli) && validateNum(year)) {
            this.numPubli = numPubli;
            this.year = year;
        }
    }

    public int getNumPubli() {
        return numPubli;
    }

    public void setNumPubli(int numPubli) throws Exception {
        if (validateNum(numPubli)) {
            this.numPubli = numPubli;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws Exception {
        if (validateNum(year)) {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return "Revista{"+"\nNumero de publicacion: "+numPubli+"\nAño: "+year+super.toString()+"}";
    }
}
