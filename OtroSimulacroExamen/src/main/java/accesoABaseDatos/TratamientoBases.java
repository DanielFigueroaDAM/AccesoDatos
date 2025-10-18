package accesoABaseDatos;

import objetos.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TratamientoBases {
    public static void insertarLibro(Libro libro){
        String sql = "insert into Libro (Titulo,Autor,AnoPublicacion,Genero) values (?,?,?,?)";
        PreparedStatement ps;
        try(Connection conn = Conexion.conectarse()) {
            ps = conn.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2,libro.getAutor());
            ps.setInt(3,libro.getAnoPublicacion());
            ps.setString(4,libro.getGenero());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Libro> leerTodosLosLibros(){
        ArrayList<Libro> listaLibros = new ArrayList<>();
        Libro libro;
        String sql = "Select * from libro";
        PreparedStatement ps;
        try(Connection con = Conexion.conectarse()){
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("Id");
                String titulo = rs.getString("Titulo");
                String autor = rs.getString("Autor");
                Integer ano = rs.getInt("AnoPublicacion");
                String genero = rs.getString("Genero");
                libro = new Libro(id,titulo,autor,ano,genero);
                listaLibros.add(libro);
            }
            return listaLibros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertarInventarioBiblioteca(int id, int copiasTotais, int copiasPrestadas){
        String sql = "insert into InventarioBiblioteca (Idlibro,CopiasTotais,CopiasPrestadas) values (?,?,?)";
        PreparedStatement ps;
        try(Connection conn = Conexion.conectarse()) {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setInt(2,copiasTotais);
            ps.setInt(3,copiasPrestadas);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
