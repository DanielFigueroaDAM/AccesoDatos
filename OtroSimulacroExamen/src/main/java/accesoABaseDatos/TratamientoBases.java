package accesoABaseDatos;

import objetos.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TratamientoBases {
    public static void insertarLibro(Libro libro){
        String sql = "insert into Libro (Titulo,Autor,AnoPublicacion,Genero) value (?,?,?,?)";
        PreparedStatement ps;
        try(Connection conn = )

    }
}
