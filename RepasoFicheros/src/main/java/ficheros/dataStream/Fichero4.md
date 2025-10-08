# Clase DataOutputStream en Java

La clase `DataOutputStream` permite escribir datos primitivos de Java (tipos básicos) en un flujo de salida de manera portable, independiente de la plataforma. Es especialmente útil para trabajar con archivos binarios que contienen datos estructurados.

## Características Principales

### **Escritura de Tipos Primitivos**
- Escribe datos en formato binario, no texto
- Preserva el tipo de dato original
- Formato portable entre diferentes plataformas

## Implementación Básica

### **Creación del DataOutputStream**
```java
File archivoF = new File(archivo);
FileOutputStream fichero;
DataOutputStream salida = null;

// Se crea encadenando FileOutputStream con DataOutputStream
salida = new DataOutputStream(fichero = new FileOutputStream(archivoF, true));
```

### **Modos de Apertura**
```java
// Sobrescritura (default)
new FileOutputStream(archivoF);

// Append - añade al final del archivo
new FileOutputStream(archivoF, true);
```

## Método writeUTF()

### **Características de writeUTF()**
```java
String cadena = "escritura de cadena";
salida.writeUTF(cadena);
```

- **Codificación**: UTF-8 modificada
- **Formato**:
    - 2 bytes: longitud de la cadena (en número de bytes UTF-8)
    - n bytes: datos de la cadena en UTF-8
- **Máxima longitud**: 65,535 bytes

### **Ejemplo de Escritura**
```java
// La cadena "escritura de cadena" se escribe como:
// - 2 bytes: longitud (19 en este caso)
// - 19 bytes: los caracteres en UTF-8
```

## Obtención del Tamaño del Archivo

### **Usando FileChannel**
```java
System.out.println("Tamaño del fichero: " + fichero.getChannel().size());
```

- **`getChannel()`**: Retorna el FileChannel asociado al FileOutputStream
- **`size()`**: Retorna el tamaño actual del archivo en bytes

## Otros Métodos Importantes de DataOutputStream

### **Escritura de Tipos Primitivos**
```java
salida.writeBoolean(true);        // 1 byte
salida.writeByte(65);            // 1 byte
salida.writeChar('A');           // 2 bytes
salida.writeShort(1000);         // 2 bytes
salida.writeInt(123456);         // 4 bytes
salida.writeLong(123456789L);    // 8 bytes
salida.writeFloat(3.14f);        // 4 bytes
salida.writeDouble(2.71828);     // 8 bytes
```

### **Métodos Adicionales**
```java
salida.write(byte[] b);          // Escribe array de bytes
salida.write(byte[] b, int off, int len); // Escribe porción
salida.flush();                  // Fuerza el vaciado del buffer
salida.size();                   // Retorna número de bytes escritos
```

## Lectura Correspondiente con DataInputStream

Para leer los datos escritos con DataOutputStream, se usa DataInputStream:

```java
DataInputStream entrada = new DataInputStream(new FileInputStream(archivoF));
String cadenaLeida = entrada.readUTF();
entrada.close();
```

## Ejemplo Completo con Múltiples Tipos

```java
public class EjemploCompletoDataStream {
    public static void main(String[] args) throws IOException {
        File archivo = new File("datos.bin");
        
        try (DataOutputStream salida = new DataOutputStream(
                new FileOutputStream(archivo))) {
            
            // Escribir diferentes tipos de datos
            salida.writeUTF("Hola Mundo");
            salida.writeInt(42);
            salida.writeDouble(3.14159);
            salida.writeBoolean(true);
            
            System.out.println("Tamaño del archivo: " + archivo.length() + " bytes");
        }
        
        // Leer los datos
        try (DataInputStream entrada = new DataInputStream(
                new FileInputStream(archivo))) {
            
            System.out.println("Cadena: " + entrada.readUTF());
            System.out.println("Entero: " + entrada.readInt());
            System.out.println("Double: " + entrada.readDouble());
            System.out.println("Boolean: " + entrada.readBoolean());
        }
    }
}
```

## Consideraciones Importantes

### **Orden de Lectura/Escritura**
- Los datos deben leerse en el mismo orden en que se escribieron
- El orden incorrecto producirá resultados erróneos o excepciones

### **Manejo de Excepciones**
```java
try (DataOutputStream salida = new DataOutputStream(
        new FileOutputStream(archivo))) {
    // operaciones de escritura
} catch (IOException e) {
    e.printStackTrace();
}
```

### **Ventajas**
- Eficiente en espacio (formato binario compacto)
- Preserva tipos de datos exactos
- Rápido en lectura/escritura

### **Desventajas**
- No legible por humanos
- Dependiente de la plataforma Java
- Requiere conocer la estructura exacta para leer

## Uso de FileChannel para Información del Archivo

```java
FileOutputStream fichero = new FileOutputStream(archivoF);
FileChannel canal = fichero.getChannel();

System.out.println("Tamaño: " + canal.size() + " bytes");
System.out.println("Posición actual: " + canal.position());
```

La clase DataOutputStream es fundamental para aplicaciones que necesitan almacenar datos estructurados de manera eficiente, como configuraciones, datos de juego, o cualquier información que requiera tipos de datos específicos.