package ficheros.dataStream;

import java.io.*;

public class ClaseDataStream {
    public static void main(String[] args) throws IOException {
        String cadena = "escritura de cadena";
        String archivo= "RepasoFicheros/src/main/java/ficheros/usandoInputOutputStream/FicheroOrigen";
        DataOutputStream salida = null;
        File archivoF = new File(archivo);
        FileOutputStream fichero;
        //El DataOutput stream y el DataInput stream sirve para escribir y leer ficheros binarios
        salida = new DataOutputStream(fichero = new FileOutputStream(archivoF, true));
        salida.writeUTF(cadena); //Para escribir al cadena en el fichero
        System.out.println("Tamaño del fichero: "+fichero.getChannel().size()); // esto sirve para saber el tamaño del archivo


    }
}
