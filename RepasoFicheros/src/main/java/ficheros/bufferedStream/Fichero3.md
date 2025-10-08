# Clase BufferedInputStream y BufferedOutputStream en Java

Las clases `BufferedInputStream` y `BufferedOutputStream` son wrappers que mejoran significativamente el rendimiento de las operaciones de E/S al agregar un mecanismo de buffer.

## Concepto de Buffering

### **¿Cómo funciona el buffering?**
- En lugar de leer/escribir byte por byte directamente del disco
- Se leen/escriben bloques de datos en memoria (buffer)
- Las operaciones se realizan sobre el buffer en memoria
- El buffer se vacía al disco cuando está lleno o se fuerza con `flush()`

## Implementación Básica

### **Creación de Buffered Streams**
```java
FileInputStream fOrigen = new FileInputStream(ficheroOrigen);
FileOutputStream fDestino = new FileOutputStream(ficheroDestino);

// Envolver los streams básicos con buffers
BufferedInputStream origen = new BufferedInputStream(fOrigen);
BufferedOutputStream destino = new BufferedOutputStream(fDestino);
```

### **Proceso de Copia con Buffer**
```java
int byteLeido;
while ((byteLeido = origen.read()) != -1) {
    destino.write(byteLeido);
}
// Los buffers se vacían automáticamente al cerrar los streams
origen.close();
destino.close();
```

## Ventajas del Buffering

### **1. Mayor Rendimiento**
```java
// SIN Buffer: Cada read()/write() = 1 acceso al disco
// CON Buffer: Múltiples read()/write() = 1 acceso al disco
```

### **2. Reducción de Operaciones de E/S**
- Menos llamadas al sistema operativo
- Operaciones en bloques en lugar de bytes individuales
- Optimización del uso del disco

## Modo Append con BufferedOutputStream

```java
FileOutputStream fDestino = new FileOutputStream(ficheroDestino, true);
BufferedOutputStream destino = new BufferedOutputStream(fDestino);
// El modo append se mantiene con el buffering
```

## Cierre Correcto de Recursos

### **Opción 1: Cierre Manual (en orden inverso)**
```java
destino.close();    // Primero cerrar el wrapper
fDestino.close();   // Luego cerrar el stream base (aunque close() del buffer ya lo hace)
```

### **Opción 2: Try-with-Resources (Recomendado)**
```java
try (FileInputStream fOrigen = new FileInputStream(ficheroOrigen);
     BufferedInputStream origen = new BufferedInputStream(fOrigen);
     FileOutputStream fDestino = new FileOutputStream(ficheroDestino);
     BufferedOutputStream destino = new BufferedOutputStream(fDestino)) {
    
    int byteLeido;
    while ((byteLeido = origen.read()) != -1) {
        destino.write(byteLeido);
    }
} // Todos los streams se cierran automáticamente
```

## Métodos Adicionales Importantes

### **BufferedInputStream**
```java
origen.read(byte[] buffer);        // Lee bytes en un array
origen.read(byte[] buffer, int off, int len); // Lee en porción del array
origen.available();                // Bytes disponibles sin bloquear
origen.mark(int readlimit);        // Marca posición actual
origen.reset();                    // Vuelve a la marca
```

### **BufferedOutputStream**
```java
destino.write(byte[] buffer);      // Escribe array completo
destino.write(byte[] buffer, int off, int len); // Escribe porción
destino.flush();                   // Fuerza vaciado del buffer
```

## Ejemplo Optimizado con Array de Bytes

```java
public class CopiaEficiente {
    public static void main(String[] args) throws IOException {
        String ficheroOrigen = "origen.txt";
        String ficheroDestino = "destino.txt";
        
        try (BufferedInputStream origen = new BufferedInputStream(
                new FileInputStream(ficheroOrigen));
             BufferedOutputStream destino = new BufferedOutputStream(
                new FileOutputStream(ficheroDestino))) {
            
            byte[] buffer = new byte[8192]; // Buffer de 8KB
            int bytesLeidos;
            
            while ((bytesLeidos = origen.read(buffer)) != -1) {
                destino.write(buffer, 0, bytesLeidos);
            }
        } // Auto-close con try-with-resources
    }
}
```

## Consideraciones de Tamaño de Buffer

### **Tamaños Típicos**
- **Por defecto**: 8KB (8192 bytes)
- **Personalizable**: Puede especificarse en el constructor
```java
BufferedInputStream origen = new BufferedInputStream(fOrigen, 16384); // 16KB
```

### **Factores para Elegir Tamaño**
- Tamaño de archivo
- Memoria disponible
- Patrón de acceso (secuencial vs aleatorio)

## Diferencias de Rendimiento

| Método | Tiempo (archivo 10MB) | Operaciones E/S |
|--------|----------------------|-----------------|
| Sin buffer | ~2-3 segundos | 10,000,000 |
| Con buffer | ~0.1-0.3 segundos | ~1,250 |

Las clases buffered son esenciales para aplicaciones que requieren alto rendimiento en operaciones de E/S y son la opción recomendada para la mayoría de escenarios de trabajo con archivos.