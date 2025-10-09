# Generación de XML con XMLStreamWriter

## Propósito
La clase `GeneradorXML` proporciona métodos para crear archivos XML usando la API StAX (Streaming API for XML).

## Inicialización

### **Crear el Writer**
```java
private static XMLStreamWriter iniciador() {
    XMLOutputFactory escritor = XMLOutputFactory.newInstance();
    XMLStreamWriter writer = escritor.createXMLStreamWriter(
        new FileOutputStream("autores.xml"));
    return writer;
}
```

## Métodos Principales

### **1. Cabecera del Documento**
```java
w.writeStartDocument("1.0");  // Versión XML
```

### **2. Elementos y Atributos**
```java
// Elemento inicial
w.writeStartElement("autor");

// Atributo del elemento
w.writeAttribute("id", "123");

// Contenido del elemento  
w.writeCharacters("Miguel de Cervantes");

// Cerrar elemento
w.writeEndElement();
```

## Flujo Típico de Escritura

```java
escribirCabecera();                    // <?xml version="1.0"?>
escirbirElemento("autores");           // <autores>
escirbirElemento("autor");             //   <autor
atributo("id", "1");                   //     id="1">
contenidoElemento("Nombre Autor");     //     Nombre Autor
finElemento();                         //   </autor>
finElemento();                         // </autores>
```

## Manejo de Errores
- **XMLStreamException**: Errores de formato XML
- **FileNotFoundException**: Archivo no encontrado
- **Assert**: Verifica que el writer esté inicializado

## Características de StAX
- **Escritura secuencial**: Escribe el XML en orden
- **Bajo consumo de memoria**: Ideal para XML grandes
- **Control preciso**: Control manual de cada elemento

## Uso Recomendado
```java
GeneradorXML.escribirCabecera();
GeneradorXML.escirbirElemento("libro");
// ... más elementos
```

**Perfecto para**: Generar documentos XML estructurados como configuraciones, datos de aplicación o intercambio de información.