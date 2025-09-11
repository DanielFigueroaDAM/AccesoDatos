package org.example;

import java.io.File;
import java.util.Arrays;

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
    /**
     * Comprueba los permisos de lectura y escritura de un fichero
     * @author Daniel Figueroa Vidal
     * @param dirName
     * @param fileName
     * @return void
     */
    public static void modoAcceso(String dirName, String fileName){
        File file = new File(dirName, fileName);
        if(file.exists()){
            if (file.canRead())
                System.out.println("lectura si");
            else
                System.out.println("lectura non");
            if (file.canWrite())
                System.out.println("escritura si");
            else
                System.out.println("escritura non");
        }
    }

    /**
     * Dada la ruta absoluta de un archivo, calcula su lonxitude en bytes
     * @author Daniel Figueroa Vidal
     * @param dirName
     * @param fileName
     * @return void
     */
    public static void calculaLonxitude(String dirName, String fileName){
        File file = new File(dirName, fileName);
        if(file.exists()){
            System.out.println(file.length());
        }

    }
    /**
     * Hacer que un fichero sea de solo lectura
     * @author Daniel Figueroa Vidal
     * @param dirName
     * @param fileName
     * @return true si se ha podido cambiar a solo lectura, false en caso contrario
     */
    public static boolean mLectura(String dirName, String fileName){
        File file = new File(dirName, fileName);
        if(file.exists() && file.canRead()){
            return file.setReadOnly();
        }
        return false;
    }
    /**
     * Hacer que un fichero sea de lectura y escritura
     * @author Daniel Figueroa Vidal
     * @param dirName
     * @param fileName
     * @return true si se ha podido cambiar a lectura y escritura, false en caso contrario
     */
    public static boolean mEscritura(String dirName, String fileName){
        File file = new File(dirName, fileName);
        if(file.exists() && file.canWrite()){
            return file.setWritable(true);
        }
        return false;
    }
    /**
     * Borra un fichero si existe
     * @param dirName
     * @param fileName
     */
    public static void borrarFichero(String dirName, String fileName) {
        File file = new File(dirName, fileName);
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("Fichero inexistente");
        }
    }
    /**
     * Borra un directorio si existe
     * @param dirName
     * @author Daniel Figueroa Vidal
     */
    public static void borrarDirectorio(String dirName) {
        File file = new File(dirName);
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("ruta inexistente ou con descencencia");
        }
    }
    /**
     * Lista el contenido de un directorio
     * @param dirName
     * @author Daniel Figueroa Vidal
     */
    public static void mContido(String dirName){
        File file = new File(dirName);
        String [] ficheros = file.list();
        if (ficheros == null)
            System.out.println("No es un directorio o no se puede acceder a el.");
        else
            Arrays.stream(ficheros).forEach(System.out::println); // Usando programación funcional, no lo hice con IA
    }
    /**
     * Mostrar archivos y subdirectorios del directorio.
     * @param file
     * @author Daniel Figueroa Vidal
     */
    public static void recur(File file) {
        if (file.isDirectory()) {
            System.out.println("Directorio: " + file.getAbsolutePath());
            File[] ficheros = file.listFiles();
            if (ficheros != null) {
                for (File f : ficheros) {
                    System.out.print("   " + f.getName());
                    recur(f);
                }
                System.out.print("\n");
            }
        }
    }


}
