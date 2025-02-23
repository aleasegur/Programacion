package Tema6.Ejercicio4;

public class Libros extends Ficha{
    private String editorial,autor;

    public Libros(){
        super();
        editorial="";
        autor="";
    }

    public Libros(int numero, String titulo, String editorial, String autor) throws Exception {
        super(numero, titulo);
        if (validateCadena(editorial) && validateCadena(autor)) {
            this.editorial = editorial;
            this.autor = autor;
        }
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) throws Exception {
        if (validateCadena(editorial)) {
            this.editorial = editorial;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {
        if (validateCadena(autor)) {
            this.autor = autor;
        }
    }

    @Override
    public String toString() {
        return "Libros{" +
                "\nEditorial:" + editorial +
                "\nAutor:" + autor +"\n"+super.toString()+"}";
    }
}
