package crearxml;

import javax.xml.stream.XMLStreamException;

public class App {
    public static void main(String[] args) {
        try {
            GeneradorXML.escribirCabecera();
            GeneradorXML.escirbirElemento("autores");
            GeneradorXML.escirbirElemento("autor");
            GeneradorXML.atributo("codigo","a1");
            GeneradorXML.escirbirElemento("nome");
            GeneradorXML.contenidoElemento("Alexandre Dumas");
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("titulo");
            GeneradorXML.contenidoElemento("El conde de montecristo");
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("titulo");
            GeneradorXML.contenidoElemento("Los miserables");
            GeneradorXML.finElemento();
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("autor");
            GeneradorXML.atributo("codigo","a2");
            GeneradorXML.escirbirElemento("nome");
            GeneradorXML.contenidoElemento("Fiodor Dostoyevski");
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("titulo");
            GeneradorXML.contenidoElemento("El idiota");
            GeneradorXML.finElemento();
            GeneradorXML.escirbirElemento("titulo");
            GeneradorXML.contenidoElemento("Noches blancas");
            GeneradorXML.finElemento();
            GeneradorXML.finElemento();
            GeneradorXML.finElemento();

        } catch (XMLStreamException e) {
            System.out.println("Error al crear el fichero XML");
        }

    }
}
