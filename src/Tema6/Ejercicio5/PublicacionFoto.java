package Tema6.Ejercicio5;

public class PublicacionFoto implements Publicacion,AbrirPublicacion{
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
    public void compartir() {
        System.out.println("Compartiendo foto "+urlFoto);
    }

    @Override
    public void publicar() {
        System.out.println("Publicando foto "+urlFoto+" con descripcion "+descripcion);
    }

    @Override
    public void abrirPublicacion() {
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
