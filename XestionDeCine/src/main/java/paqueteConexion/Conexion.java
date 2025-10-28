package paqueteConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conexion(){
        String url = "jdbc:postgresql://192.168.121.4/xestioncine";
        String usuario = "postgres";
        String contrasinal = "admin";
        Connection conect = null;
        try{
            conect = DriverManager.getConnection(url,usuario,contrasinal);
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conecar: "+e.getMessage());
        }
        return conect;
    }
}
