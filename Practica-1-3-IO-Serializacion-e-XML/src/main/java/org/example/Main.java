package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TratamientoDeFicherosSerial.escribirProducto(new Producto("Leche", 1.5, 10));
        Producto productoVacio = new Producto("",0,0);
        productoVacio =  TratamientoDeFicherosSerial.leerProducto(productoVacio);
        System.out.println(productoVacio);
        System.out.println("-------------------------------------");
        TratamientoDeFicherosSerial.escribirProductoT(new ProductoTransient("Nata",1.9, 15));
        ProductoTransient productoTransientVacio = new ProductoTransient("",0,0);
        productoTransientVacio = TratamientoDeFicherosSerial.leerProductoT(productoTransientVacio);
        System.out.println(productoTransientVacio);
    }
}