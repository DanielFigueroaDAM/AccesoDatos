package serializacion;

import objetos.Libro;

import java.io.*;
import java.util.ArrayList;

public class TratamientoDeFicherosSerial {
    public static void escribirProducto(ArrayList<Libro> libros){
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("serial.dat",true))){
            for (Libro libro : libros){
                escritor.writeObject(libro);
            }
        }catch (IOException e){
            System.out.println("Error al escribir el producto: "+e.getMessage());
        }
    }
    public static ArrayList<Libro> lectorLibros() {
        ArrayList<Libro> libros = new ArrayList<>();
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            while (true) {
                Libro p = (Libro) lector.readObject();
                libros.add(p);
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        return libros;
    }

}
