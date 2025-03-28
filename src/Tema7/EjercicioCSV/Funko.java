package Tema7.EjercicioCSV;

import java.io.Serial;

public class Funko {
    @Serial
    private static final long serialVersionUID=1L;

    private String codigo,nombre,modelo,fecha;
    private double precio;

    public Funko(String modelo, String nombre, String codigo, String fecha, double precio) throws Exception {
        this.modelo = modelo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.fecha = fecha;
        if (precio>0) {
            this.precio = precio;
        }else{
            throw new Exception("ERROR: el valor ni puede ser negativo");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws Exception {
        if (precio>0) {
            this.precio = precio;
        }else{
            throw new Exception("ERROR: el precio no puede ser negativo");
        }
    }

    @Override
    public String toString() {
        return  "codigo=" + codigo + '\'' +
                ", nombre=" + nombre + '\'' +
                ", modelo=" + modelo + '\'' +
                ", fecha=" + fecha + '\'' +
                ", precio=" + precio;
    }
}
