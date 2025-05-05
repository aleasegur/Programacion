package Tema8.EjerciciosConexionBBDDHogwarts;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*4. Insertar una nueva asignatura
Crea un método que permita insertar una nueva asignatura en la tabla Asignatura. Debes pro
porcionar los valores necesarios, pudiendo utilizar como ejemplo los datos de este módulo*/
public class Ejercicio4 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String nombre="Programacion2";
        String aula="1smx";
        boolean obliga=true;
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            MyDatos.insertarAsignatura(con,nombre,aula,obliga);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
