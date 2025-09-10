package org.example;

import java.io.File;

public class TratamientoDeFicheros {
    /**
     * Comprueba si la ruta es un directorio
     * Devuelve un mensaje indicando si es o no un directorio
     * @param ruta
     * @author Daniel Figueroa Vidal
     * @return mensaje indicando si es o no un directorio
     */
    public static String eDirectorio(String ruta){
        String mensaje="";
        File file = new File(ruta);
        if(file.isDirectory()){
            mensaje = "Es un directorio";
        } else{
            mensaje= "No es un directorio";
        }
        return mensaje;
    }
    /**
     * Comprueba si la ruta es un fichero
     * Devuelve un mensaje indicando si es o no un fichero
     * @author Daniel Figueroa Vidal
     * @param ruta
     * @return mensaje indicando si es o no un fichero
     */
    public static String eFichero(String ruta){
        String mensaje="";
        File file = new File(ruta);
        if(file.isFile()){
            mensaje = "Es un fichero";
        } else{
            mensaje= "No es un fichero";
        }
        return mensaje;
    }
    /**
     * Crea un directorio por la ruta absoluta que se le pasa
     * solo si no existe
     * @author Daniel Figueroa Vidal
     * @param ruta
     * @return true si se ha creado, false si ya existia
     */
    public static boolean crearDirectorio(String ruta){
        File file = new File(ruta);
        if(!file.exists()){
            return file.mkdirs();
        }
        return false;
    }
    /**
     * Crea un fichero por la ruta absoluta que se le pasa
     * solo si no existe el fichero
     * @author Daniel Figueroa Vidal
     * @param ruta
     * @param nombreFichero
     * @return true si se ha creado, false si ya existia
     */
    public static boolean crearFichero(String ruta, String nombreFichero) {
        File file = new File(ruta, nombreFichero);
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
