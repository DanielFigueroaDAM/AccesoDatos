package org.example;
import java.io.*;

public class TratamientoDeFicherosSerial {
    public static boolean escribirProducto(Producto p){
        // Escribimos el producto en serial.dat
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("serial.dat", true))) {
            escritor.writeObject(p);
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el producto: " + e.getMessage());
            return false;

        }
    }
    public static boolean leerProducto(Producto p){
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            Producto productoLeido = (Producto) lector.readObject();
            return true;
        } catch (IOException e) {
            System.out.println("Error al leer el producto: " + e.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
            return false;
        }
    }
}
