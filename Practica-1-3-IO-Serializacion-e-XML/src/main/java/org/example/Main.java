package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TratamientoDeFicherosSerial.escribirProducto(new Producto("Leche", 1.5, 10));
        Producto leido = new Producto("", 0, 0);
        TratamientoDeFicherosSerial.leerProducto(leido);
        System.out.println(leido);
    }
}