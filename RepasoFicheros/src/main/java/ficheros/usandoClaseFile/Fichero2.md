# Clase File en Java

La clase `File` en Java se utiliza para representar archivos y directorios en el sistema de archivos. Permite realizar operaciones como crear, eliminar, verificar propiedades y listar contenido.

## Métodos Principales

### 1. **Verificación de tipo y existencia**

```java
file.isDirectory();    // Devuelve true si es un directorio, false si no
file.isFile();         // Devuelve true si es un archivo, false si no
file.exists();         // Devuelve true si el archivo/directorio existe
```

### 2. **Creación y eliminación**

```java
file.createNewFile();  // Crea un nuevo archivo
file.delete();         // Elimina el archivo o directorio
```

### 3. **Permisos y propiedades**

```java
file.canRead();        // Devuelve true si el archivo se puede leer
file.canWrite();       // Devuelve true si el archivo se puede escribir
file.setWritable(true); // Cambia el permiso de escritura
file.length();         // Devuelve el tamaño en bytes del archivo
```

### 4. **Listado de contenido**

```java
String[] ficheros = file.list();        // Array con nombres del contenido
File[] ficheros = file.listFiles();     // Array de objetos File del contenido
```

## Ejemplo de Recorrido Recursivo

El método `recur()` muestra cómo recorrer recursivamente directorios y subdirectorios:

```java
public static void recur(File file) {
    if (file.isDirectory()) {
        System.out.println("Directorio: " + file.getAbsolutePath());
        File[] ficheros = file.listFiles();
        if (ficheros != null) {
            for (File f : ficheros) {
                System.out.print("   " + f.getName());
                recur(f);  // Llamada recursiva para subdirectorios
            }
            System.out.print("\n");
        }
    }
}
```

## Consideraciones Importantes

- **Manejo de excepciones**: Las operaciones con archivos pueden lanzar `IOException`
- **Verificación de null**: Siempre verificar si `listFiles()` retorna null
- **Permisos del sistema**: Algunas operaciones pueden fallar por falta de permisos

La clase File es fundamental para la manipulación de archivos en aplicaciones Java que necesitan interactuar con el sistema de archivos.