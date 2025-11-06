# Guía Completa de Hibernate - Conceptos y Operaciones CRUD

## 1. **Configuración de Hibernate**

### HibernateConfig
```java
// Configuración principal de Hibernate
public class HibernateConfig {
    public static SessionFactory getSessionFactory() {
        // Retorna la SessionFactory para crear sesiones
    }
}
```

## 2. **Anotaciones JPA/Hibernate Mapeadas**

### @Entity
```java
@Entity
@Table(name = "Pokemon")
public class Pokemon {
    // Indica que la clase es una entidad JPA
    // Se mapea a la tabla "Pokemon" en la base de datos
}
```

### @Id y @GeneratedValue
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idPokemon;

// @Id: Marca el campo como clave primaria
// @GeneratedValue: Estrategia de generación automática
// Strategy.IDENTITY: usa auto-increment de la base de datos
```

### @Column
```java
@Column(name = "nome", nullable = false, length = 50)
private String nome;

// name: nombre de la columna en la BD
// nullable: si permite valores nulos
// length: longitud máxima para campos String
```

## 3. **Operaciones CRUD Básicas**

### INSERT (Crear)
```java
public static void insertarPokemon(Pokemon pokemon){
    try(Session sesion = HibernateConfig.getSessionFactory().openSession()){
        Transaction transaccion = sesion.beginTransaction();
        sesion.save(pokemon);  // Persiste el objeto
        transaccion.commit();  // Confirma la transacción
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}
```

### UPDATE (Actualizar)
```java
public static void actualizarPokemonNombrePorID(int id, String nuevoNombre){
    try(Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        Pokemon pokemon = session.get(Pokemon.class, id);  // Busca por ID
        if (pokemon != null) {
            pokemon.setNome(nuevoNombre);  // Modifica el objeto
            session.update(pokemon);       // Actualiza en BD
        }
        transaction.commit();
    }
}
```

### DELETE (Eliminar)
```java
public static void borrarPokemonPorID(int id){
    try(Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        Pokemon pokemon = session.get(Pokemon.class, id);
        if (pokemon != null) {
            session.delete(pokemon);  // Elimina el objeto
        }
        transaction.commit();
    }
}
```

### SELECT (Consultar)
```java
// Consulta por ID
Pokemon pokemon = session.get(Pokemon.class, id);

// Consulta con HQL (Hibernate Query Language)
List<Pokedex> resultados = session.createQuery("from Pokedex", Pokedex.class).getResultList();
```

## 4. **Gestión de Sesiones y Transacciones**

### Patrón Try-with-Resources
```java
try(Session session = HibernateConfig.getSessionFactory().openSession()){
    // La sesión se cierra automáticamente al salir del try
}
```

### Transacciones
```java
Transaction transaction = session.beginTransaction();
// Operaciones de BD...
transaction.commit();  // Confirma los cambios
// transaction.rollback() para deshacer en caso de error
```

## 5. **Consultas HQL (Hibernate Query Language)**

### Consulta Básica
```java
// FROM con nombre de entidad (no tabla)
session.createQuery("from Pokedex", Pokedex.class).getResultList();
```

### Eliminación Masiva
```java
session.createQuery("DELETE FROM Pokedex").executeUpdate();
```

## 6. **Métodos de Session Más Comunes**

### Operaciones Básicas
- `session.save(object)`: Inserta un nuevo registro
- `session.get(Class, id)`: Busca por clave primaria
- `session.update(object)`: Actualiza un objeto existente
- `session.delete(object)`: Elimina un objeto
- `session.merge(object)`: Fusiona estado de objeto desconectado

### Consultas
- `session.createQuery(hql)`: Crea consulta HQL
- `session.createNativeQuery(sql)`: Consulta SQL nativa
- `session.createCriteria(Class)`: Consulta por criterios (deprecado en Hibernate 5+)

## 7. **Buenas Prácticas Observadas**

### 1. Manejo Correcto de Recursos
```java
try(Session session = ...) {
    // Sesión autocerrable
}
```

### 2. Gestión de Transacciones
- Siempre usar transacciones para operaciones de escritura
- Commit explícito para confirmar cambios

### 3. Manejo de Excepciones
- Captura y log de excepciones específicas
- Mensajes descriptivos de error

## 8. **Posibles Mejoras**

### Consultas con Parámetros
```java
public static Pokemon buscarPorNombre(String nombre) {
    try(Session session = HibernateConfig.getSessionFactory().openSession()) {
        return session.createQuery("FROM Pokemon WHERE nome = :nombre", Pokemon.class)
                     .setParameter("nombre", nombre)
                     .uniqueResult();
    }
}
```

### Consultas Paginadas
```java
public static List<Pokemon> listarPokemonsPaginados(int pagina, int tamaño) {
    try(Session session = HibernateConfig.getSessionFactory().openSession()) {
        return session.createQuery("FROM Pokemon", Pokemon.class)
                     .setFirstResult((pagina - 1) * tamaño)
                     .setMaxResults(tamaño)
                     .getResultList();
    }
}
```

### Transacciones con Rollback
```java
public static void operacionConRollback(Pokemon pokemon) {
    Session session = HibernateConfig.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        session.save(pokemon);
        // Otras operaciones...
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        throw e;
    } finally {
        session.close();
    }
}
```

## 9. **Estructura Recomendada para Servicios**

```java
public class PokemonService {
    
    public void crear(Pokemon pokemon) { /* INSERT */ }
    
    public Pokemon buscarPorId(int id) { /* SELECT por ID */ }
    
    public List<Pokemon> listarTodos() { /* SELECT todos */ }
    
    public void actualizar(Pokemon pokemon) { /* UPDATE */ }
    
    public void eliminar(int id) { /* DELETE */ }
    
    // Consultas específicas del negocio
    public List<Pokemon> buscarPorEntrenador(int idEntrenador) { /* ... */ }
}
```

