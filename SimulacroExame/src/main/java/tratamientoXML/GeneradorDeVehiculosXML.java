package tratamientoXML;

import Objetos.Vehiculo;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;



public class GeneradorDeVehiculosXML {

    public static void escribirVehiculosXML(ArrayList<Vehiculo> listaVehiculos) throws XMLStreamException {
        GeneradorXML.escribirCabecera();
        GeneradorXML.escirbirElemento("Vehiculos");
        for (Vehiculo v : listaVehiculos){
            try {

                escribirVehiculoXML(v);
            } catch (XMLStreamException e) {
                System.out.println("Problema en la escritura de vehiculos");
            }
        }
        GeneradorXML.finElemento();

    }

    public static void escribirVehiculoXML(Vehiculo vehiculo) throws XMLStreamException {


            GeneradorXML.escirbirElemento("Vehiculo");
            GeneradorXML.escirbirElemento("Id");
            GeneradorXML.contenidoElemento(String.valueOf(vehiculo.getId()));
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("Modelo");
            GeneradorXML.contenidoElemento(vehiculo.getModelo());
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("Marca");
            GeneradorXML.contenidoElemento(vehiculo.getMarca());
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("Ano");
            GeneradorXML.contenidoElemento(String.valueOf(vehiculo.getAno()));
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("Descripcion");
            GeneradorXML.contenidoElemento(vehiculo.getDescripcion());
            GeneradorXML.finElemento();
            GeneradorXML.finElemento();

    }
}
