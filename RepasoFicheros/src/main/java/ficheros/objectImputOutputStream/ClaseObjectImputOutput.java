package ficheros.objectImputOutputStream;

import java.io.*;

public class ClaseObjectImputOutput {
    public static void main(String[] args) {
        //Podemos usar un try-with-resources
        Producto p = new Producto("platano");
        //Esto se usaria para escribir el producto en un fichero binario
        try(ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("serial.dat"))){ //Usamos un FileOutPutStream
            escritor.writeObject(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Para leer el producto tenemos que usar el metodo readOpbject
        try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream("serial.dat"))) {
            Producto productoLeido = (Producto) lector.readObject(); // obligatorio el casteo a producto
        } catch (IOException e) {
            System.out.println("Error al leer el producto: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //En el caso que una propiedad del producto fuera transient, no sería modificada
    }
}
