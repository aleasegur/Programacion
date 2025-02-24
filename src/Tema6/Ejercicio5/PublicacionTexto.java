package Tema6.Ejercicio5;

import Tema6.Ejercicio6.PublicacionConReaccion;

public class PublicacionTexto implements Publicacion,PublicacionConReaccion {
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
    public void iComentar(String comentario) {
        System.out.println("Comentario: "+comentario);
    }

    @Override
    public void iCompartir() {
        System.out.println("Compartiendo texto "+contenido);
    }

    @Override
    public void iPublicar() {
        System.out.println("Publicando texto "+contenido);
    }

    @Override
    public String toString() {
        return "Publicacion Texto{"+"\nContenido: "+contenido+"}";
    }
}
