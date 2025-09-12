package org.example;

public class App {
    static String ficheroAbsoluto;
    static String arquivosdir = "/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir";
    public static void main(String[] args) {
        ejercicio1();
    }
    public static void ejercicio1(){
        TratamientoDeFicheros.crearDirectorio(arquivosdir);
        System.out.println(TratamientoDeFicheros.eDirectorio(arquivosdir));
    }

}
