package exec;

import accesoABaseDatos.Conexion;
import accesoABaseDatos.TratamientoBases;
import objetos.Libro;

import java.sql.Connection;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Connection conn = Conexion.conectarse();
        if (conn != null) {
            System.out.println("Conexión establecida");
        }

        //TratamientoBases.insertarLibro(new Libro("Cien Años de Soledad","Gabriel García Márquez", 1967,"Mágico"));
//        TratamientoBases.insertarLibro(new Libro("1984","George Orwell", 1943,"Distopía"));
//        TratamientoBases.insertarLibro(new Libro("El Principito","Antoine de Saint-Exupéry", 1967,"Infantil"));
//        TratamientoBases.insertarLibro(new Libro("Don Quijote de la Mancha","Miguel de Cervantes",  1605,"Clásico"));
//        TratamientoBases.insertarLibro(new Libro("Harry Potter y la Piedra Filosofal","J.K. Rowling", 1997,"Fantasía"));


        ArrayList<Libro> recogidos = TratamientoBases.leerTodosLosLibros();
        recogidos.forEach(System.out::println);
        TratamientoBases.insertarInventarioBiblioteca(1,10,2);
        TratamientoBases.insertarInventarioBiblioteca(3,8,3);
        TratamientoBases.insertarInventarioBiblioteca(4,15,5);
        TratamientoBases.insertarInventarioBiblioteca(5,5,1);
        TratamientoBases.insertarInventarioBiblioteca(6,20,12);
    }
}
