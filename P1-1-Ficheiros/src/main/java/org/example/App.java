package org.example;

public class App {
    static String ficheroAbsoluto;
    static String arquivosdir = "/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir";
    public static void main(String[] args) {
        ejercicio2();
    }
    public static void ejercicio1(){
        TratamientoDeFicheros.crearDirectorio(arquivosdir);
        System.out.println(TratamientoDeFicheros.eDirectorio(arquivosdir));
    }
    public static void ejercicio2(){
        TratamientoDeFicheros.crearFichero(arquivosdir,"Products1.txt");
        System.out.printf(TratamientoDeFicheros.eFichero("/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir/Products1.txt"));
    }

}
