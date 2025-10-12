package AccessBD;

import Objetos.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoABaseDeDatos {

    public static ArrayList<Vehiculo> getVehiculosTable(){
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculo";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String modelo = rs.getString("Modelo");
                String marca = rs.getString("Marca");
                int ano = rs.getInt("Ano");
                String descripcion = rs.getString("Descripcion");
                listaVehiculos.add(new Vehiculo(id,modelo,marca,ano,descripcion));
            }
            return listaVehiculos;
        } catch (Exception e) {
            System.out.println("Error al leer vehiculos: " + e.getMessage());
            return null;
        }
    }
    public static boolean insertarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (modelo,marca,ano,descripcion) VALUES (?, ?, ?, ?)";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, vehiculo.getModelo());
            ps.setString(2, vehiculo.getMarca());
            ps.setInt(3, vehiculo.getAno());
            ps.setString(4, vehiculo.getDescripcion());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar vehiculo: " + e.getMessage());
            return false;
        }
    }

    public static boolean actualizarVehiculo(Vehiculo vehiculo, int id) {
        String sql = "UPDATE vehiculo SET modelo = ?, marca = ?, ano = ? ,descripcion = ? WHERE id = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, vehiculo.getModelo());
            ps.setString(2, vehiculo.getMarca());
            ps.setInt(3, vehiculo.getAno());
            ps.setString(4, vehiculo.getDescripcion());
            ps.setInt(5, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al actualizar vehiculo: " + e.getMessage());
            return false;
        }
    }
    public static boolean eliminarVehiculo(int id){
        String sql = "DELETE FROM Vehiculo WHERE id = ?";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar vehiculo: " + e.getMessage());
            return false;
        }
    }
    public static boolean insertarInventarioTenda(Vehiculo vehiculo, double prezoMayorista,double precioVenta, int porcentajeOferta) {
        String sql = "INSERT INTO InventarioTenda (IdVehiculo,PrezoMayorista,PrezoVenta,PorcentaxeOferta) VALUES (?, ?, ?, ?)";
        PreparedStatement ps;
        try (Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,vehiculo.getId());
            ps.setDouble(2,prezoMayorista);
            ps.setDouble(3,precioVenta);
            ps.setInt(4,porcentajeOferta);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (Exception e) {
            System.out.println("Error al insertar Inventario: " + e.getMessage());
            return false;
        }
    }
    public static void actualizarPorcentaxeOferta(int aumento){
        String sql = "UPDATE InventarioTenda SET PorcentaxeOferta = PorcentaxeOferta + ?";
        PreparedStatement ps;
        try(Connection conn = Conexion.conexion()) {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,aumento);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








}
