package ActividadAADD;

import java.time.LocalDate;

public class Piloto {
    private String code,nombre,apellido,nacionalidad;
    private LocalDate fecha;
    private int id;

    public Piloto(){
        code="";
        nombre="";
        nacionalidad="";
        apellido="";
        fecha=null;
        id=0;
    }

    public Piloto(String code, String nombre, String nacionalidad, String apellido, LocalDate fecha)throws Exception {
        if (fecha!=null && code!=null && nacionalidad!=null && nombre!=null && apellido!=null) {
            this.code = code;
            this.nombre = nombre;
            this.nacionalidad = nacionalidad;
            this.apellido = apellido;
            this.fecha = fecha;
        }else{
            throw new Exception("Error en el objeto");
        }
        this.id = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code)throws Exception{
        if (code!=null) {
            this.code = code;
        }else{
            throw new Exception("Error en el codigo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)throws Exception{
        if (nombre!=null) {
            this.nacionalidad = nombre;
        }else{
            throw new Exception("Error en el nombre");
        }
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad)throws Exception{
        if (nacionalidad!=null) {
            this.nacionalidad = nacionalidad;
        }else{
            throw new Exception("Error en la nacionalida");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido)throws Exception {
        if (apellido!=null) {
            this.apellido = apellido;
        }else{
            throw new Exception("Error en el apellido");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id)throws Exception {
        if (id>0) {
            this.id = id;
        }else{
            throw new Exception("Error en el id");
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha)throws Exception {
        if (fecha!=null) {
            this.fecha = fecha;
        }else{
            throw new Exception("Error en la fecha");
        }
    }

    @Override
    public String toString() {
        return "code='" + code + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha=" + fecha +
                ", id=" + id;
    }
}
