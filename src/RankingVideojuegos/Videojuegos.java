package RankingVideojuegos;

import java.io.Serial;
import java.io.Serializable;

public abstract class Videojuegos implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    protected String titulo,plataforma;
    protected int nota;

    public Videojuegos() {
        titulo="";
        plataforma="";
        nota=0;
    }

    public Videojuegos(String titulo, String plataforma, int nota) throws Exception {
        if (nota>0 && nota<=10 && plataforma!=null && titulo!=null) {
            this.titulo = titulo;
            this.plataforma = plataforma;
            this.nota = nota;
        }else{
            throw new Exception("Error atributos no tiene valores correcto");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if (titulo!=null) {
            this.titulo = titulo;
        }else{
            throw new Exception("Error el atributo no puede ser nulo");
        }
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) throws Exception {
        if (plataforma!=null) {
            this.plataforma = plataforma;
        }else{
            throw new Exception("Error el atributo no puede ser nulo");
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) throws Exception {
        if (nota>0 && nota<=10) {
            this.nota = nota;
        }else{
            throw new Exception("Error la nota debe ser entre 1 y 10");
        }
    }

    public abstract String getTipo();

}
