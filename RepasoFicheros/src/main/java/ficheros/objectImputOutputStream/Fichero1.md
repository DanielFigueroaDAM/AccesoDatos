# Clase ObjectOutputStream y ObjectInputStream

## ¿Qué son?
Clases para **serializar** (convertir objetos a bytes) y **deserializar** (reconstruir objetos desde bytes) en Java.

## Uso Básico

### **Serializar - Guardar objeto**
```java
Producto p = new Producto("platano");
try(ObjectOutputStream escritor = new ObjectOutputStream(
    new FileOutputStream("serial.dat"))){
    escritor.writeObject(p);
}
```

### **Deserializar - Leer objeto**
```java
try(ObjectInputStream lector = new ObjectInputStream(
    new FileInputStream("serial.dat"))) {
    Producto productoLeido = (Producto) lector.readObject(); // Casteo obligatorio
}
```

## Requisitos Importantes

### **1. Implementar Serializable**
```java
public class Producto implements Serializable {
    // ...
}
```

### **2. Control de versiones (recomendado)**
```java
private static final long serialVersionUID = 1L;
```

### **3. Campos transient**
```java
private transient String codigo; // No se guarda en el archivo
```

## Características Clave

- **Try-with-resources**: Cierra streams automáticamente
- **Casting obligatorio**: `readObject()` devuelve Object
- **Campos transient**: Se excluyen de la serialización
- **Excepciones**: Manejar IOException y ClassNotFoundException

## Ejemplo Completo Breve
```java
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private transient String codigoInterno; // No se serializa
    
    public Producto(String nombre) {
        this.nombre = nombre;
    }
}
```

**Ideal para**: Guardar estado de aplicaciones, configuración, o cualquier objeto que necesite persistirse.