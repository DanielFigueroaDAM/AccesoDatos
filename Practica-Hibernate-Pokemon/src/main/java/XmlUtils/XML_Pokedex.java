package XmlUtils;

import model.Pokedex;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class XML_Pokedex {
    public static XMLStreamWriter starter() {
        XMLOutputFactory escritor = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = escritor.createXMLStreamWriter(new FileOutputStream("pokedex.xml"));
            return writer;
        } catch (XMLStreamException e) {
            System.out.println("error de XML Stream Exception");
        } catch (FileNotFoundException e) {
            System.out.println("error de file");
        }
        return null;
    }

    private static XMLStreamWriter w = starter();

    public static void pokedexToXML(List<Pokedex> pokedexes) throws XMLStreamException {
        assert w != null;
        w.writeStartDocument("1.0");
        w.writeStartElement("pokedexes");

        for (Pokedex p : pokedexes) {
            pokedexToXML(p);
        }

        w.writeEndElement(); // fin pokedexes
        w.writeEndDocument();
        w.flush();
        w.close();
    }

    private static void pokedexToXML(Pokedex p) throws XMLStreamException {
        w.writeStartElement("pokedex");
        w.writeAttribute("id", String.valueOf(p.getIdPokedex()));

        w.writeStartElement("nome");
        w.writeCharacters(p.getNome() != null ? p.getNome() : "");
        w.writeEndElement();

        w.writeStartElement("peso");
        w.writeCharacters(String.valueOf(p.getPeso()));
        w.writeEndElement();

        w.writeStartElement("misc");
        w.writeCharacters(p.getMisc() != null ? p.getMisc() : "");
        w.writeEndElement();

        w.writeEndElement();
    }
}
