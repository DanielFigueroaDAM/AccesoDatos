package org.example;

import java.io.*;

public class TratamientoDeFicheros3 {
    /**
     * Escribe el contenido de un fichero en otro fichero, sustituyendo el contenido del fichero de destino usando
     * buffered.
     * @param ficheroOrigen
     * @param ficheroDestino
     */
    public static void escribirFicheroAFicheroBuffered(String ficheroOrigen, String ficheroDestino){
        try {
            FileInputStream fOrigen = new FileInputStream(ficheroOrigen);
            FileOutputStream fDestino = new FileOutputStream(ficheroDestino);
            BufferedInputStream origen = new BufferedInputStream(fOrigen);
            BufferedOutputStream destino = new BufferedOutputStream(fDestino);
            int byteLeido;
            while ((byteLeido = origen.read()) != -1) {
                destino.write(byteLeido);
            }
            origen.close();
            destino.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void añadirFicheroAFicheroBuffered(String ficheroOrigen, String ficheroDestino){
        try {
            FileInputStream fOrigen = new FileInputStream(ficheroOrigen);
            FileOutputStream fDestino = new FileOutputStream(ficheroDestino, true);
            BufferedInputStream origen = new BufferedInputStream(fOrigen);
            BufferedOutputStream destino = new BufferedOutputStream(fDestino);
            int byteLeido;
            while ((byteLeido = origen.read()) != -1) {
                destino.write(byteLeido);
            }
            origen.close();
            destino.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
