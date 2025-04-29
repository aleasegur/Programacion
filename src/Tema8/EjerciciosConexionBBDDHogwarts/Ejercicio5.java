package Tema8.EjerciciosConexionBBDDHogwarts;

import Tema8.MyDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*5. Modificar el aula de una asignatura
Crea un método que permita modificar el aula de una asignatura específica. El método debe
tomar como parámetros el id de la asignatura y la nueva aula. Utiliza la asignatura creada y
ponle el nombre que quieras al aula.*/
public class Ejercicio5 {
    public static void main(String[] args) {
        MyDatos.loadProperties();
        String newAula="Sotano1SMX";
        int idAula=1;
        try(Connection con= DriverManager.getConnection(MyDatos.getURL(),MyDatos.getUSER(),MyDatos.getPASSWORD())){
            MyDatos.modificarAulaAsignatura(con,idAula,newAula);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
