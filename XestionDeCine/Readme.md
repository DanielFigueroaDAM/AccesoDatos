### **Simulacro de exame: Xestión de Cine**

Escribe un programa que poida crear, modificar, ler e eliminar rexistros nas táboas de datos xeradas a través do seguinte script SQL.

#### **Script de creación de táboas:**

```sql
DROP TABLE IF EXISTS Pelicula;
DROP TABLE IF EXISTS Cartelera;

CREATE TABLE Pelicula (
    Id SERIAL PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Director VARCHAR(255),
    AnoEstreo INT,
    Xenero VARCHAR(255)
);

CREATE TABLE Cartelera (
    Id SERIAL PRIMARY KEY,
    IdPelicula INTEGER,
    PrezoEntrada DECIMAL(10, 2),
    Sala VARCHAR(50),
    SesionsDiarias INT,
    FOREIGN KEY (IdPelicula) REFERENCES Pelicula(Id)
);
```

---

#### **Funcionalidades a implementar:**

1. Escribe unha función que permita **serializar** nun ficheiro o contido da táboa `Pelicula`.
2. Escribe unha función que permita **deserializar** as entradas do ficheiro creado anteriormente.
3. Escribe unha función que permita **exportar en XML** as entradas da táboa `Pelicula`.

---

#### **Secuencia de operacións:**

1. Inserta na táboa `Pelicula` as seguintes películas (recorda que os valores da PK son autoxerados):

    * “Inception”, Director: Christopher Nolan, Ano: 2010, Xénero: Ciencia Ficción
    * “Titanic”, Director: James Cameron, Ano: 1997, Xénero: Romance
    * “Jurassic Park”, Director: Steven Spielberg, Ano: 1993, Xénero: Aventura
    * “Avatar”, Director: James Cameron, Ano: 2009, Xénero: Ciencia Ficción
    * “The Godfather”, Director: Francis Ford Coppola, Ano: 1972, Xénero: Drama

2. Consulta os **IDs** que teñen agora as películas e lístaos.

3. Inserta na táboa `Cartelera` as seguintes entradas:

    * (ID de “Inception”), 7.50, “Sala 1”, 3
    * (ID de “Titanic”), 6.00, “Sala 2”, 2
    * (ID de “Jurassic Park”), 5.50, “Sala 3”, 4
    * (ID de “Avatar”), 8.00, “Sala 1”, 5
    * (ID de “The Godfather”), 6.50, “Sala 4”, 2

4. Exporta as entradas da táboa `Pelicula` a un ficheiro XML.

5. Exporta as entradas da táboa `Pelicula` nun ficheiro serializado.

6. Mostra unha mensaxe na saída que poña:

   ```
   CARTELERA DE CINE
   ```

7. Aumenta en **1** o número de sesións diarias de cada película en `Cartelera`.

8. Lista o **prezo da entrada** da película “Avatar”.

9. Lee as entradas da táboa `Pelicula` desde o ficheiro serializado.

10. Escribe nun ficheiro de texto o contido lido do ficheiro serializado.

