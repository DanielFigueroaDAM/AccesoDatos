import Objetos.Vehiculo;

import java.io.*;
import java.util.ArrayList;

public class SerializarEnFicheros {
    public static void serializarVehiculos(ArrayList<Vehiculo> vehiculosIngresados){
        try(ObjectOutputStream escritor = new ObjectOutputStream(
                new FileOutputStream("serialVehiculos.dat"))){
            escritor.writeObject(vehiculosIngresados);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Vehiculo> desserializarVehiculos(){
        try(ObjectInputStream lector = new ObjectInputStream(
                new FileInputStream("serial.dat"))) {
            ArrayList<Vehiculo> vehiculos = (ArrayList<Vehiculo>) lector.readObject();
            return vehiculos;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
