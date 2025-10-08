package crearxml;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GeneradorXML {
    private static XMLStreamWriter iniciador(){
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = escritor.createXMLStreamWriter(new FileOutputStream("autores.xml"));
            return writer;
        } catch (XMLStreamException e) {
            System.out.println("error de XML Stream Exception");
        } catch (FileNotFoundException e) {
            System.out.println("error de file");
        }
        return null;
    }
    private static XMLStreamWriter w = iniciador();

    public static void escribirCabecera() throws XMLStreamException {
        assert w != null;
        w.writeStartDocument("1.0");
    }

    public static void escirbirElemento(String name) throws XMLStreamException {
        assert w != null;
        w.writeStartElement(name);
    }

    public static void atributo(String atrrNombre, String atrrContenido) throws XMLStreamException {
        assert w != null;
        w.writeAttribute(atrrNombre,atrrContenido);
    }
    public static void contenidoElemento(String contenido) throws XMLStreamException {
        assert w != null;
        w.writeCharacters(contenido);
    }

    public static void finElemento() throws XMLStreamException {
        assert w != null;
        w.writeEndElement();
    }


}
