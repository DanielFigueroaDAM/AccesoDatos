package org.example;
import java.io.*;

public class TratamientoDeFicherosSerial {
    public static boolean escribirProducto(Producto p){
        // Escribimos el producto en serial.dat
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("serial.dat"))) {
            escritor.writeObject(p);
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el producto: " + e.getMessage());
            return false;

        }
    }
    public static Producto leerProducto(Producto pasado){
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            Producto productoLeido = (Producto) lector.readObject();
            pasado.setCantidad(productoLeido.getCantidad());
            pasado.setNombre(productoLeido.getNombre());
            pasado.setPrecio(productoLeido.getPrecio());
            return pasado;
        } catch (IOException e) {
            System.out.println("Error al leer el producto: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
            return null;
        }
    }
    public static boolean escribirProductoT(ProductoTransient p){
        // Escribimos el producto en serial.dat
        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("serial.dat"))) {
            escritor.writeObject(p);
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el producto: " + e.getMessage());
            return false;

        }
    }
    public static ProductoTransient leerProductoT(ProductoTransient pasado){
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            ProductoTransient productoLeido = (ProductoTransient) lector.readObject();
            pasado.setCantidad(productoLeido.getCantidad());
            pasado.setNombre(productoLeido.getNombre());
            pasado.setPrecio(productoLeido.getPrecio());
            return pasado;
        } catch (IOException e) {
            System.out.println("Error al leer el producto: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());
            return null;
        }
    }
}
