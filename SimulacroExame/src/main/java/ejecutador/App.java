package ejecutador;

import AccessBD.AccesoABaseDeDatos;
import AccessBD.Conexion;
import Objetos.Vehiculo;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Connection conn = Conexion.conexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        }
        Vehiculo v1 = new Vehiculo(0,"Ford","Mustang", 2021, "Deportivos americanos icónicos.");
        Vehiculo v2 = new Vehiculo(0,"Ford2","Mustang2", 2022, "Deportivos americanos icónicos.2");

        AccesoABaseDeDatos.insertarVehiculo(v1);
        AccesoABaseDeDatos.insertarVehiculo(v2);




    }





}
