package objeto;

public class Pelicula {
    private int id;
    private String titulo;
    private String director;
    private int anoEstreo;
    private String xenero;

    public Pelicula(int id, String titulo, String director, int anoEstreo, String xenero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anoEstreo = anoEstreo;
        this.xenero = xenero;
    }

    public Pelicula(String titulo, String director, int anoEstreo, String xenero) {
        this.titulo = titulo;
        this.director = director;
        this.anoEstreo = anoEstreo;
        this.xenero = xenero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnoEstreo() {
        return anoEstreo;
    }

    public void setAnoEstreo(int anoEstreo) {
        this.anoEstreo = anoEstreo;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anoEstreo=" + anoEstreo +
                ", xenero='" + xenero + '\'' +
                '}';
    }
}
