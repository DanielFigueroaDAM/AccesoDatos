package objetos;

public class Libro {
    private Integer Id;
    private String Titulo;
    private String Autor;
    private Integer AnoPublicacion;
    private String Genero;

    public Libro(String titulo, String autor, Integer anoPublicacion, String genero) {
        Titulo = titulo;
        Autor = autor;
        AnoPublicacion = anoPublicacion;
        Genero = genero;
    }

    public Libro(Integer id,String titulo, String autor, Integer anoPublicacion, String genero) {
        Id = id;
        Autor = autor;
        Titulo = titulo;
        AnoPublicacion = anoPublicacion;
        Genero = genero;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Integer getAnoPublicacion() {
        return AnoPublicacion;
    }

    public void setAnoPublicacion(Integer anoPublicacion) {
        AnoPublicacion = anoPublicacion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Id=" + Id +
                ", Titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", AnoPublicacion=" + AnoPublicacion +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
