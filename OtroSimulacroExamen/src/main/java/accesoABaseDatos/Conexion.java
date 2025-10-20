package accesoABaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectarse(){
        String url = "jdbc:postgresql://192.168.121.4:5432/postgres";
        String usuario = "postgres";
        String contrasinal = "admin";
        Connection conect = null;
        try {
            conect = DriverManager.getConnection(url,usuario,contrasinal);
            System.out.println("conexión exitosa a la base de datos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conect;
    }
}
