package RankingVideojuegos;

import java.io.Serial;
import java.io.Serializable;

public class VideojuegoDigital extends Videojuegos implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    private String tiendaOnline;
    private double tamGB;

    public VideojuegoDigital() {
        this.tiendaOnline = "";
        this.tamGB = 0;
    }

    public VideojuegoDigital(String titulo, String plataforma, int nota, String tiendaOnline, double tamGB) throws Exception {
        super(titulo, plataforma, nota);
        if (tiendaOnline!=null && tamGB>0) {
            this.tiendaOnline = tiendaOnline;
            this.tamGB = tamGB;
        }else{
            throw new Exception("Error los atributos han de inicializarse");
        }
    }

    public String getTiendaOnline() {
        return tiendaOnline;
    }

    public void setTiendaOnline(String tiendaOnline) throws Exception {
        if (tiendaOnline!=null) {
            this.tiendaOnline = tiendaOnline;
        }else {
            throw new Exception("Error el atributo no esta inicializado");
        }
    }

    public double getTamGB() {
        return tamGB;
    }

    public void setTamGB(double tamGB) throws Exception {
        if (tamGB>0) {
            this.tamGB = tamGB;
        }else{
            throw new Exception("Error el valor no puede ser igual o menor a 0");
        }
    }

    @Override
    public String getTipo() {
        return "Digital";
    }


    @Override
    public String toString() {
        return "tiendaOnline='" + tiendaOnline + '\'' +
                ", tamGB=" + tamGB +
                ", titulo='" + titulo + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", nota=" + nota+ '\'' +
                ", tipo=" +getTipo();
    }

    @Override
    public void iJugarDemo() {
        System.out.println("Jugando a "+titulo);
    }

}
