package org.example;

import java.io.*;


public class TratamientoDeFicheros4 {
    public static void escribiendoCadenas(String cadena, String archivo){
        DataOutputStream salida = null;
        try {
            File archivoF = new File(archivo);
            FileOutputStream fichero;
            salida = new DataOutputStream(fichero = new FileOutputStream(archivoF, true));
            salida.writeUTF(cadena);
            System.out.println("Escribiendo la cadena: "+cadena);
            System.out.println("Tamaño del fichero: "+fichero.getChannel().size());
        } catch (IOException e) {
            System.out.println( "Error E/S: " + e.getMessage() );
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    System.out.println( "Error E/S: " + e.getMessage() );
                }
            }
        }
    }
    public static void leyendoCadenas(String archivo){
        try (DataInputStream l1 = new DataInputStream(new FileInputStream(archivo))) {
            while (l1.available() > 0) {
                System.out.println("quedan: " + l1.available() + " bytes por ler");
                String s = l1.readUTF();
                System.out.println("cadea: " + s);
            }
            System.out.println("Xa non queda nada por ler");
        } catch (IOException e) {
            System.out.println( "Error E/S: " + e.getMessage() );
        }
    }
}
