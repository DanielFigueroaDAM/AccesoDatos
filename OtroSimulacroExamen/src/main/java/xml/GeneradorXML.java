package xml;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GeneradorXML {
    private static XMLStreamWriter iniciador(){
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = escritor.createXMLStreamWriter(new FileOutputStream("autor.xml"));
            return writer;
        }catch (XMLStreamException e){
            System.out.println("error de XML Stream Exception");
        } catch (FileNotFoundException e){
            System.out.println("error de file");
        }
        return null;
    }
    private static XMLStreamWriter w = iniciador();
    public static void escribirCabecera() throws XMLStreamException {
        assert w != null;
        w.writeStartDocument();
    }
    public static void escribirElemento(String name) throws XMLStreamException {
        assert w != null;
        w.writeStartDocument();
    }
    public static void atributo(String atrrNombre, String atrrContenido) throws XMLStreamException{
        assert w != null;
        w.writeAttribute(atrrNombre,atrrContenido);
    }
    public static void contenidoElemento(String contenido) throws XMLStreamException{
        assert w != null;
        w.writeCharacters(contenido);
    }
    public static void cerrarElemento() throws XMLStreamException{
        assert w != null;
        w.writeEndElement();

    }

}
