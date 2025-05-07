package ActividadAADD;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        PilotsCRUD.loadProperties();
        String cons="SELECT name FROM circuits";
        try(Connection con= DriverManager.getConnection(PilotsCRUD.getURL(), PilotsCRUD.getUSER(), PilotsCRUD.getPASSWORD());
            PreparedStatement pst=con.prepareStatement(cons); ResultSet res=pst.executeQuery()) {
            while (res.next()){
                String nombre=res.getString("name");
                System.out.println(nombre);
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
