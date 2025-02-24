package Tema6.Ejercicio5;

import Tema6.Ejercicio6.PublicacionConReaccion;

public class PublicacionVideo implements Publicacion,AbrirPublicacion, PublicacionConReaccion {
    private String urlVideo,titulo;

    public PublicacionVideo(){
        urlVideo="";
        titulo="";
    }

    public PublicacionVideo(String urlVideo, String titulo) {
        this.urlVideo = urlVideo;
        this.titulo = titulo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void iComentar(String comentario) {
        System.out.println("Comentario: "+comentario);
    }

    @Override
    public void iCompartir() {
        System.out.println("Compartiendo video "+urlVideo);
    }

    @Override
    public void iPublicar() {
        System.out.println("Publicando video "+urlVideo+" con titulo "+titulo);
    }

    @Override
    public void iAbrirPublicacion() {
        System.out.println("Abriendo publicacion de video: "+urlVideo);
    }

    @Override
    public String toString() {
        return "PublicacionVideo{" +
                "urlVideo='" + urlVideo + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
