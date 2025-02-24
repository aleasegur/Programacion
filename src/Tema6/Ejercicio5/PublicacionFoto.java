package Tema6.Ejercicio5;

import Tema6.Ejercicio6.PublicacionConReaccion;

public class PublicacionFoto implements Publicacion,AbrirPublicacion,PublicacionConReaccion{
    private String urlFoto,descripcion;

    public PublicacionFoto(){
        urlFoto="";
        descripcion="";
    }

    public PublicacionFoto(String urlFoto, String descripcion) {
        this.urlFoto = urlFoto;
        this.descripcion = descripcion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void iComentar(String comentario) {
        System.out.println("Comentario: "+comentario);
    }

    @Override
    public void iCompartir() {
        System.out.println("Compartiendo foto "+urlFoto);
    }

    @Override
    public void iPublicar() {
        System.out.println("Publicando foto "+urlFoto+" con descripcion "+descripcion);
    }

    @Override
    public void iAbrirPublicacion() {
        System.out.println("Abriendo publicacion de foto: "+urlFoto);
    }

    @Override
    public String toString() {
        return "PublicacionFoto{" +
                "urlFoto='" + urlFoto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
