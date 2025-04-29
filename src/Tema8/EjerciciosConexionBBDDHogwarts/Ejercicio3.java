package Tema8.EjerciciosConexionBBDDHogwarts;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*3. Número de estudiantes por casa
Crea un método que consulte y devuelva el número de estudiantes en cada casa de Hogwarts*/
public class Ejercicio3 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            MyDatos.obtenerNumeroEstudiantesPorCasa(con);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
