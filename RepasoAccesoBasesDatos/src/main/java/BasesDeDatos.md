# Clase AnimeSql - Detalle de Parametrización de Consultas

## Uso de PreparedStatement y Parametrización

### **1. INSERT - Inserción de Datos**

```java
public static boolean insertarAnime(Anime anime) {
    String sql = "INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";
    PreparedStatement ps;
    try (Connection conn = Conexion.conexion()) {
        ps = conn.prepareStatement(sql);
        
        // PARAMETRIZACIÓN - Orden correlativo de los ?
        ps.setString(1, anime.getNombre());       // Primer ? = nombre
        ps.setString(2, anime.getDescripcion());  // Segundo ? = descripcion  
        ps.setDate(3, anime.getFecha());          // Tercer ? = fecha
        ps.setInt(4, anime.getPuntuacion());      // Cuarto ? = puntuacion
        
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }
}
```

**Ejemplo de parámetros en ejecución:**
```java
// Consulta preparada: INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)
// Con parámetros: ["Naruto", "Ninja juvenil", "2002-10-03", 85]
// Consulta final ejecutada: INSERT INTO anime (nome, descripcion, data, puntuacion) VALUES ('Naruto', 'Ninja juvenil', '2002-10-03', 85)
```

### **2. SELECT con Filtro - Búsqueda Parametrizada**

```java
public static List<Anime> leerBaseDatosFiltrada(String filtro) {
    String sql = "SELECT * FROM anime WHERE nome LIKE ?";
    PreparedStatement ps;
    try (Connection conn = Conexion.conexion()) {
        ps = conn.prepareStatement(sql);
        
        // PARAMETRIZACIÓN CON PATTERN LIKE
        ps.setString(1, "%" + filtro + "%");  // ? = "%dragon%"
        
        ResultSet rs = ps.executeQuery();
        // Procesar resultados...
    }
}
```

**Ejemplos de búsqueda:**
```java
leerBaseDatosFiltrada("dragon");
// Parámetro: "%dragon%"
// Encuentra: "Dragon Ball", "Dragon Quest", "Dragon's Dogma"

leerBaseDatosFiltrada("ball");
// Parámetro: "%ball%"
// Encuentra: "Dragon Ball", "Kuroko's Basketball"
```

### **3. UPDATE - Actualización con Condición**

```java
public static boolean actualizarAnime(Anime anime, String nombreViejo) {
    String sql = "UPDATE anime SET nome = ?, descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
    PreparedStatement ps;
    try (Connection conn = Conexion.conexion()) {
        ps = conn.prepareStatement(sql);
        
        // PARAMETRIZACIÓN DE CAMPOS A ACTUALIZAR
        ps.setString(1, anime.getNombre());       // SET nome = nuevo_nombre
        ps.setString(2, anime.getDescripcion());  // SET descripcion = nueva_descripcion
        ps.setDate(3, anime.getFecha());          // SET data = nueva_fecha
        ps.setInt(4, anime.getPuntuacion());      // SET puntuacion = nueva_puntuacion
        
        // PARAMETRIZACIÓN DE CONDICIÓN WHERE
        ps.setString(5, nombreViejo);             // WHERE nome = nombre_anterior
        
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }
}
```

**Ejemplo de actualización:**
```java
// Cambiar "Naruto" por "Naruto Shippuden"
Anime animeActualizado = new Anime("Naruto Shippuden", "Secuela de Naruto", fecha, 90);
actualizarAnime(animeActualizado, "Naruto");

// Consulta ejecutada:
// UPDATE anime 
// SET nome = 'Naruto Shippuden', descripcion = 'Secuela de Naruto', data = '...', puntuacion = 90 
// WHERE nome = 'Naruto'
```

### **4. DELETE - Eliminación con Condición**

```java
public static boolean eliminarAnime(String nombre){
    String sql = "DELETE FROM anime WHERE nome = ?";
    PreparedStatement ps;
    try (Connection conn = Conexion.conexion()) {
        ps = conn.prepareStatement(sql);
        
        // PARAMETRIZACIÓN DE CONDICIÓN WHERE
        ps.setString(1, nombre);  // WHERE nome = 'nombre_especifico'
        
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    }
}
```

## Métodos setXXX() de PreparedStatement

### **Tipos de Datos Comunes:**
```java
ps.setString(posicion, valor);     // VARCHAR, TEXT
ps.setInt(posicion, valor);        // INT
ps.setDate(posicion, valor);       // DATE (java.sql.Date)
ps.setDouble(posicion, valor);     // DOUBLE, FLOAT  
ps.setBoolean(posicion, valor);    // BOOLEAN, TINYINT(1)
ps.setTimestamp(posicion, valor);  // DATETIME, TIMESTAMP
```

### **Ventajas de la Parametrización:**

1. **Seguridad contra SQL Injection:**
```java
// MAL - Vulnerable a SQL injection
String sql = "DELETE FROM anime WHERE nome = '" + nombre + "'";

// BIEN - Protegido con parametrización  
String sql = "DELETE FROM anime WHERE nome = ?";
ps.setString(1, nombre); // Seguro incluso si nombre = "'; DROP TABLE anime; --"
```

2. **Mejor Rendimiento:**
    - Las consultas preparadas se cachean
    - Reutilización de planes de ejecución

3. **Manejo Automático de Tipos:**
    - Conversión automática de tipos Java a SQL
    - Escape automático de caracteres especiales

## Flujo Completo de Ejecución

```java
// 1. PREPARAR CONSULTA
String sql = "INSERT INTO anime (nome, descripcion) VALUES (?, ?)";
PreparedStatement ps = conn.prepareStatement(sql);

// 2. ESTABLECER PARÁMETROS
ps.setString(1, "One Piece");      // Primer parámetro
ps.setString(2, "Piratas buscando tesoro"); // Segundo parámetro

// 3. EJECUTAR
int resultado = ps.executeUpdate();

// Consulta real ejecutada:
// INSERT INTO anime (nome, descripcion) VALUES ('One Piece', 'Piratas buscando tesoro')
```

## Consideraciones de la Parametrización

### **Orden de Parámetros:**
Los parámetros se numeran secuencialmente desde 1, en el orden que aparecen los `?` en la consulta.

### **Tipos de Datos:**
Usar siempre el método `setXXX()` correspondiente al tipo de columna en la base de datos.

### **Valores Nulos:**
```java
ps.setNull(posicion, Types.VARCHAR); // Para establecer NULL explícitamente
```

Esta parametrización es fundamental para aplicaciones seguras y eficientes que interactúan con bases de datos.