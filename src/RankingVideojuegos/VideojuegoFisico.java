package RankingVideojuegos;

import java.io.Serial;
import java.io.Serializable;

public class VideojuegoFisico extends Videojuegos implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    private String estado,tiendaCompra;

    public VideojuegoFisico(){
        super();
        this.estado = "";
        this.tiendaCompra = "";
    }

    public VideojuegoFisico(String titulo, String plataforma, int nota, String estado, String tiendaCompra) throws Exception {
        super(titulo, plataforma, nota);
        if (estado!=null && tiendaCompra!=null && estado.equals("nuevo") || estado.equals("usado")) {
            this.estado = estado;
            this.tiendaCompra = tiendaCompra;
        }else{
            throw new Exception("Error los atributos deben tener valor");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws Exception {
        if (estado!=null && estado.equals("nuevo") || estado.equals("usado")) {
            this.estado = estado;
        }else{
            throw new Exception("Error estado no es correcto");
        }
    }

    public String getTiendaCompra() {
        return tiendaCompra;
    }

    public void setTiendaCompra(String tiendaCompra) throws Exception {
        if (tiendaCompra!=null) {
            this.tiendaCompra = tiendaCompra;
        }else{
            throw new Exception("Error tiendaCompra no tiene valor");
        }
    }

    @Override
    public String getTipo() {
        return "Fisico";
    }

    @Override
    public String toString() {
        return "estado='" + estado + '\'' +
                ", tiendaCompra='" + tiendaCompra + '\'' +
                ", titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", nota=" + nota+ '\'' +
                ", tipo=" +getTipo();
    }
}
