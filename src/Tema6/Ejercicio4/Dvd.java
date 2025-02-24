package Tema6.Ejercicio4;

public class Dvd extends Ficha{
    private String director,tipo;
    private int year;

    public Dvd(){
        super();
        director="";
        year=0;
    }

    public Dvd(int numero, String titulo, String director, int year, String tipo) throws Exception {
        super(numero, titulo);
        if (validateCadena(director) && validateNum(year)) {
            this.director = director;
            this.year = year;
        }
        this.tipo = tipo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) throws Exception {
        if (validateCadena(director)) {
            this.director = director;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "DVD{"+"\nDirector: "+director+"\nAño: "+year+"\nTipo: "+tipo+super.toString()+"}";
    }
}
