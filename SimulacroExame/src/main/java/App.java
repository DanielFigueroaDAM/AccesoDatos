import AccessBD.AccesoABaseDeDatos;
import AccessBD.Conexion;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Connection conn = Conexion.conexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        }


        System.out.println(AccesoABaseDeDatos.setVehiculosTable());
    }





}
