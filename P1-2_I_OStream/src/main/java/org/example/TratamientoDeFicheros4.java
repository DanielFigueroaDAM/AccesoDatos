package org.example;

import java.io.*;


public class TratamientoDeFicheros4 {
    public static void escribiendoCadenas(String cadena, String archivo){
        DataOutputStream salida = null;
        try {
            salida = new DataOutputStream(new FileOutputStream(archivo, true));
            salida.writeUTF(cadena);
            System.out.println("Escribiendo la cadena: "+cadena);
            System.out.println("Tamaño del fichero: "+salida.size()); // esto no va, preguntar al profesor como funciona¿clase File?
        } catch (IOException e) {
            e.printStackTrace();
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
