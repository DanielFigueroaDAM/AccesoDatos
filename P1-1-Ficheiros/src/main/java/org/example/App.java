package org.example;

public class App {
    static String products1_txt = "/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir/Products1.txt";
    static String arquivosdir = "/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir";
    static String subdir = "/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir/subdir";
    static String products2_txt = "/home/dam/IdeaProjects/AccesoDatos/P1-1-Ficheiros/src/arquivosdir/subdir/Products2.txt";

    public static void main(String[] args) {
        ejercicio3();
    }
    public static void ejercicio1(){
        TratamientoDeFicheros.crearDirectorio(arquivosdir);
        System.out.println(TratamientoDeFicheros.eDirectorio(arquivosdir));
    }
    public static void ejercicio2(){
        TratamientoDeFicheros.crearFichero(arquivosdir,"Products1.txt");
        System.out.printf(TratamientoDeFicheros.eFichero(products1_txt));
    }
    public static void ejercicio3(){
        System.out.println(TratamientoDeFicheros.crearDirectorio(subdir));
        System.out.println(TratamientoDeFicheros.crearFichero(subdir,"product2_txt"));
    }
    public static void ejercicio4(){

    }

}
