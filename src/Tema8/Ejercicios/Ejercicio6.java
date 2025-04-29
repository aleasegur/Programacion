package Tema8.Ejercicios;

import Tema8.MyDatos;

import java.sql.*;
/*
* 6. Eliminar duplicados con DISTINCT
Muestra todos los años de curso sin duplicados*/
public class Ejercicio6 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String consulta="SELECT DISTINCT anyo_curso FROM estudiante";
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD()); PreparedStatement stat=con.prepareStatement(consulta);
            ResultSet res=stat.executeQuery()) {

            while (res.next()){
                int anyo=res.getInt("anyo_curso");
                System.out.println(anyo);
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
