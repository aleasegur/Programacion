package Tema6.Ejercicio5;

public class PublicacionTexto implements Publicacion{
    private String contenido;

    public PublicacionTexto(){
        contenido="";
    }

    public PublicacionTexto(String contenido){
        this.contenido=contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo texto "+contenido);
    }

    @Override
    public void publicar() {
        System.out.println("Publicando texto "+contenido);
    }

    @Override
    public String toString() {
        return "Publicacion Texto{"+"\nContenido: "+contenido+"}";
    }
}
