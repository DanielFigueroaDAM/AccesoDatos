package ficheros.bufferedStream;

import java.io.*;

public class ClasseBufferedOutputInput {
    public static void main(String[] args) throws IOException {
        String ficheroOrigen = "RepasoFicheros/src/main/java/ficheros/usandoInputOutputStream/FicheroDestino";
        String ficheroDestino = "RepasoFicheros/src/main/java/ficheros/usandoInputOutputStream/FicheroOrigen";

        FileInputStream fOrigen = new FileInputStream(ficheroOrigen);
        FileOutputStream fDestino = new FileOutputStream(ficheroDestino); // También funcionaría con el append
        BufferedInputStream origen = new BufferedInputStream(fOrigen); //Funciona similar a inputStream, pero internamente, va más rápido
        BufferedOutputStream destino = new BufferedOutputStream(fDestino);
        int byteLeido;
        while ((byteLeido = origen.read()) != -1) {
            destino.write(byteLeido);
        }
        origen.close();
        destino.close();
    }
}
