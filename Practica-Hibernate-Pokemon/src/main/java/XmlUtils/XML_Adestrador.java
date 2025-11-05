package XmlUtils;

import model.Adestrador;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XML_Adestrador {
    public static XMLStreamWriter starter() {
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = escritor.createXMLStreamWriter(new FileOutputStream("adestradores.xml"));
            return writer;
        } catch (XMLStreamException e) {
            System.out.println("error de XML Stream Exception");
        } catch (FileNotFoundException e) {
            System.out.println("error de file");
        }
        return null;
    }
    private static XMLStreamWriter w = starter();

    public static void adestradoresToXML(List<Adestrador> adestradores) throws XMLStreamException {
        assert w != null;
        w.writeStartDocument("1.0");
        w.writeStartElement("adestradores");

        for (Adestrador adestrador : adestradores) {
            adestradorToXML(adestrador);
        }

        w.writeEndElement(); // fin adestradores
        w.writeEndDocument();
        w.flush();
        w.close();
    }

    private static void adestradorToXML(Adestrador adestrador) throws XMLStreamException {
        w.writeStartElement("adestrador");
        w.writeAttribute("id", String.valueOf(adestrador.getIdAdestrador()));

        w.writeStartElement("nome");
        w.writeCharacters(adestrador.getNome());
        w.writeEndElement();
        w.writeStartElement("nacemento");
        w.writeCharacters(String.valueOf(adestrador.getNacemento()));

        w.writeEndElement();
        w.writeEndElement();
    }

}
