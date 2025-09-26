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
                    e.printStackTrace();
                }
            }
        }
    }
    public static void leyendoCadenas(String archivo){
        try {
            DataInputStream l1 = new DataInputStream(new FileInputStream(archivo));
            while (true){
                String s = l1.readUTF();
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
