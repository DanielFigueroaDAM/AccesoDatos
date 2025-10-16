### Simulacro de examen: **Xestión de Biblioteca**

Escribe un programa que poida crear, modificar, ler e eliminar rexistros nas táboas de datos xeradas a través do seguinte script SQL.

#### Script de creación de táboas:

```sql
DROP TABLE IF EXISTS Libro;
DROP TABLE IF EXISTS InventarioBiblioteca;

CREATE TABLE Libro (
    Id SERIAL PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Autor VARCHAR(255),
    AnoPublicacion INT,
    Genero VARCHAR(255)
);

CREATE TABLE InventarioBiblioteca (
    Id SERIAL PRIMARY KEY,
    IdLibro INTEGER,
    CopiasTotais INT,
    CopiasPrestadas INT,
    FOREIGN KEY (IdLibro) REFERENCES Libro(Id)
);
```

#### Funcionalidades a implementar:

1. Escribe unha función que permita **serializar** nun ficheiro o contido da táboa `Libro`.
2. Escribe unha función que permita **deserializar** as entradas do ficheiro creado anteriormente.
3. Escribe unha función que permita **exportar en XML** as entradas da táboa `Libro`.

#### Secuencia de operacións:

1. Inserta na táboa `Libro` os seguintes libros (recorda que os valores da PK son autoxerados):

    * "Cien Años de Soledad", Autor: Gabriel García Márquez, 1967, Xénero: Realismo Mágico
    * "1984", Autor: George Orwell, 1949, Xénero: Distopía
    * "El Principito", Autor: Antoine de Saint-Exupéry, 1943, Xénero: Infantil
    * "Don Quijote de la Mancha", Autor: Miguel de Cervantes, 1605, Xénero: Clásico
    * "Harry Potter y la Piedra Filosofal", Autor: J.K. Rowling, 1997, Xénero: Fantasía

2. Consulta os IDs que teñen agora os libros e lístaos.

3. Inserta na táboa `InventarioBiblioteca` as seguintes entradas:

    * (ID de "Cien Años de Soledad"), 10, 2
    * (ID de "1984"), 8, 3
    * (ID de "El Principito"), 15, 5
    * (ID de "Don Quijote de la Mancha"), 5, 1
    * (ID de "Harry Potter y la Piedra Filosofal"), 20, 12

4. Exporta as entradas da táboa `Libro` a XML.

5. Exporta as entradas da táboa `Libro` nun ficheiro serializado.

6. Mostra unha mensaxe que poña:

   ```
   INVENTARIO BIBLIOTECA
   ```

7. Modifica o número de copias prestadas en `InventarioBiblioteca` sumándolle 2 a cada libro.

8. Lista as copias dispoñibles do libro "1984" (CopiasTotais - CopiasPrestadas).

9. Lee as entradas de libros do ficheiro serializado.

10. Escribe nun ficheiro de texto o contido lido do ficheiro serializado.

