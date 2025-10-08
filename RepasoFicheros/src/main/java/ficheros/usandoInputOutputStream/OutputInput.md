# Clase FileInputStream y FileOutputStream en Java

Las clases `FileInputStream` y `FileOutputStream` se utilizan para leer y escribir datos en archivos a nivel de bytes. Son ideales para trabajar con archivos binarios o cuando se necesita un control preciso sobre la lectura/escritura byte a byte.

## Flujo Básico de Operación

### 1. **Creación de los Streams**

```java
// Crear objetos File para origen y destino
File fOrigen = new File(ficheroOrigen);
File fDestino = new File(ficheroDestino);

// Crear los streams de entrada y salida
FileInputStream origen = new FileInputStream(fOrigen);
FileOutputStream destino = new FileOutputStream(fDestino);
```

### 2. **Lectura y Escritura Byte a Byte**

```java
int byteLeido;
while ((byteLeido = origen.read()) != -1) {
    destino.write(byteLeido);
}
```

- **`read()`**: Lee un byte del stream y lo retorna como `int`
- **Retorna -1** cuando llega al final del archivo (EOF - End Of File)
- **`write(byteLeido)`**: Escribe el byte leído en el stream de salida

## Modos de Apertura de FileOutputStream

### **Sobrescritura (default)**
```java
FileOutputStream destino = new FileOutputStream(fDestino);
// Si el archivo existe, se sobrescribe completamente
// Si no existe, se crea nuevo
```

### **Append (añadir al final)**
```java
FileOutputStream destino = new FileOutputStream(fDestino, true);
// El parámetro 'true' habilita el modo append
// Los nuevos bytes se añaden al final del archivo existente
// Si el archivo no existe, se crea nuevo
```

## Manejo de Recursos y Cierre

### **Cierre Manual de Streams**
```java
origen.close();   // Libera recursos del sistema
destino.close();  // Importante para evitar fugas de memoria
```

### **Try-with-Resources (Recomendado)**
```java
try (FileInputStream origen = new FileInputStream(fOrigen);
     FileOutputStream destino = new FileOutputStream(fDestino)) {
    
    int byteLeido;
    while ((byteLeido = origen.read()) != -1) {
        destino.write(byteLeido);
    }
} // Los streams se cierran automáticamente
```

## Diferencias Clave en el Ejemplo

### **Primera Copia - Sobrescritura**
```java
FileOutputStream destino = new FileOutputStream(fDestino);
// El contenido original de fDestino se pierde
// Se reemplaza por el contenido de fOrigen
```

### **Segunda Copia - Append**
```java
FileOutputStream destino2 = new FileOutputStream(fDestino, true);
// El contenido de fOrigen se añade al final de fDestino
// Se conserva el contenido anterior
```

## Consideraciones de Rendimiento

- **Lectura byte a byte** es ineficiente para archivos grandes
- **Para mejor rendimiento** usar buffers:
```java
BufferedInputStream bis = new BufferedInputStream(origen);
BufferedOutputStream bos = new BufferedOutputStream(destino);
```

## Manejo de Excepciones

- **IOException** debe ser manejada con try-catch o declarada en throws
- **FileNotFoundException** puede ocurrir si el archivo no existe
- **SecurityException** por permisos insuficientes

Estas clases son fundamentales para operaciones de E/S a bajo nivel en Java y forman la base para streams más avanzados como `BufferedInputStream` y `BufferedOutputStream`.