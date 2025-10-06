package org.example;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
}
