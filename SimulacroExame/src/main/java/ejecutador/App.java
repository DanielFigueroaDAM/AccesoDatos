package ejecutador;

import AccessBD.AccesoABaseDeDatos;
import AccessBD.Conexion;
import Objetos.Vehiculo;
import Serializar.SerializarEnFicheros;
import tratamientoXML.GeneradorDeVehiculosXML;

import javax.xml.stream.XMLStreamException;
import java.sql.Connection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Connection conn = Conexion.conexion();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        }
        Vehiculo v1 = new Vehiculo("Ford","Mustang", 2021, "Deportivos americanos icónicos.");
        Vehiculo v2 = new Vehiculo("Ford2","Mustang2", 2022, "Deportivos americanos icónicos.2");
        Vehiculo v3 = new Vehiculo("Model","Tesla",2023,"Sedán eléctrico de luxo con gran autonomía");

        AccesoABaseDeDatos.insertarVehiculo(v1);
        AccesoABaseDeDatos.insertarVehiculo(v2);
        AccesoABaseDeDatos.insertarVehiculo(v3);
        ArrayList<Vehiculo> lv = AccesoABaseDeDatos.getVehiculosTable();
        SerializarEnFicheros.serializarVehiculos(lv);

        try {
            GeneradorDeVehiculosXML.escribirVehiculosXML(SerializarEnFicheros.desserializarVehiculos());
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        AccesoABaseDeDatos.insertarInventarioTenda(lv.get(0),40000.0,50000.00,12);
        AccesoABaseDeDatos.actualizarPorcentaxeOferta(15);
        System.out.println(AccesoABaseDeDatos.getVehiculosTable());
    }





}
