package ficheros.usandoInputOutputStream;

import java.io.*;

public class ClaseOutputInputStream {
    public static void main(String[] args) throws IOException {
        String ficheroOrigen = "RepasoFicheros/src/main/java/ficheros/usandoInputOutputStream/FicheroDestino";
        String ficheroDestino = "RepasoFicheros/src/main/java/ficheros/usandoInputOutputStream/FicheroOrigen";

        File fOrigen = new File(ficheroOrigen); //Primero creamos el File pasandole la ruta del fichero de origen
        File fDestino = new File(ficheroDestino); //Primero creamos el File pasandole la ruta del fichero de destino

        FileInputStream origen = new FileInputStream(fOrigen); // A partir de los file creamos el Input y los Output
        FileOutputStream destino = new FileOutputStream(fDestino);

        //Para escribir un fichero en otro tenemos que usar el metodo read y depues el write
        //Terminará la lectura cuando el metodo retorne -1

        int byteLeido;
        while ((byteLeido = origen.read()) != -1) { // Devuelve -1 si la lectura ha terminado
            destino.write(byteLeido);
        }
        origen.close(); //cerramos los streams
        destino.close(); //cerramos los treamos

        //En el codigo anterior el contenido de uno se sobrescribe sobre el otro, en el siguiente con el "append" se añade

        FileInputStream origen2= new FileInputStream(fOrigen);
        FileOutputStream destino2 = new FileOutputStream(fDestino, true); //Aqui colocamos el append

        int byteLeido2;
        while ((byteLeido2 = origen2.read()) != -1) {
            destino2.write(byteLeido);
        }
        origen2.close(); //cerramos los streams
        destino2.close(); //cerramos los treamos
    }

}
