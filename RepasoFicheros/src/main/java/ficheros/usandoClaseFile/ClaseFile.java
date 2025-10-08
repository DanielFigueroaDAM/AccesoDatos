package ficheros.usandoClaseFile;

import java.io.File;
import java.io.IOException;

public class ClaseFile {
    public static void main(String[] args) throws IOException {
        //Crear objeto File
        File file = new File("RepasoFicheros/src/main","Fichero1.md");
        // Metodos
        file.isDirectory(); //Devuelve true o false si es directorio o no
        file.isFile(); // Devuelve true o false si es archivo o no
        file.exists(); // Devuelve true o false si existe o no

        File fileParaCrear = new File("Fichero2.md");
        fileParaCrear.createNewFile(); //Crea el fichero

        file.canRead(); //Devuelve true o false si el archivo se puede leer
        file.canWrite(); //Devuelve true o false si el archivo se puede escribir

        file.length(); //Devuelve la longitud en bytes

        file.setWritable(true); //Cambia el estado de escritura del file

        file.delete(); // Borra el directorio o fichero

        String [] ficheros = file.list(); //devuelve un array con el contendido

        recur(file); //Recorrer todos los ficheros y subdirectorios de un directori
    }
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
