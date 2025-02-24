package Tema6.Ejercicio5;

public class PublicacionVideo implements Publicacion,AbrirPublicacion{
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
    public void comentar(String comentario) {
        System.out.println("Comentario: "+comentario);
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo video "+urlVideo);
    }

    @Override
    public void publicar() {
        System.out.println("Publicando video "+urlVideo+" con titulo "+titulo);
    }

    @Override
    public void abrirPublicacion() {
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
