package Tema7.EjercicioCSV;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Locale;

public class Funko {
    @Serial
    private static final long serialVersionUID=1L;

    private String codigo,nombre,modelo;
    private LocalDate fecha;
    private double precio;

    public Funko(String codigo, String nombre, String modelo, double precio, LocalDate fecha)throws Exception {
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

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
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

    public static Funko fromCSV(String linea) throws Exception {
        String[] datos=linea.split(",");
        return new Funko(datos[0],datos[1],datos[2],Double.parseDouble(datos[3]),LocalDate.parse(datos[4]));
    }

    public String toCSV(){
        return codigo+","+nombre+","+modelo+","+precio+","+fecha;
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
