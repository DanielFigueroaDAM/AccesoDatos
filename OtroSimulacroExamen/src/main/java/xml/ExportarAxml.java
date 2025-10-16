package xml;

import objetos.Libro;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

public class ExportarAxml {
    public static void exportarLibrosAXML(ArrayList<Libro> libros){
        try {
            GeneradorXML.escribirCabecera();
            GeneradorXML.escribirElemento("libros");
            for (Libro libro : libros){
                escribirLibro(libro);
            }
            GeneradorXML.cerrarElemento();
            GeneradorXML.cerrarElemento();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirLibro(Libro libro) throws XMLStreamException {
        GeneradorXML.escribirElemento("libro");
        GeneradorXML.contenidoElemento(libro.getTitulo());
        GeneradorXML.cerrarElemento();
        GeneradorXML.escribirElemento("autor");
        GeneradorXML.contenidoElemento(libro.getAutor());
        GeneradorXML.cerrarElemento();
        GeneradorXML.contenidoElemento(String.valueOf(libro.getAnoPublicacion()));
        GeneradorXML.cerrarElemento();
        GeneradorXML.escribirElemento("genero");
        GeneradorXML.contenidoElemento(libro.getGenero());
    }


}
