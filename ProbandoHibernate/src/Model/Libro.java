package Model;

import javax.persistence.*;

@Entity(name = "Libro")
public class Libro {
    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "Xenero", length = 50)
    private String Xenero;

    @ManyToOne
    @JoinColumn(name = "AutorId")
    private Autor autorId;

    @ManyToOne
    @JoinColumn(name = "UsuarioId")
    private Usuario usuarioId;

    public Libro(int id, String titulo, String xenero, Autor autorId, Usuario usuarioId) {
        this.id = id;
        this.titulo = titulo;
        Xenero = xenero;
        this.autorId = autorId;
        this.usuarioId = usuarioId;
    }

    public Libro(String titulo, String xenero, Autor autorId, Usuario usuarioId) {
        this.titulo = titulo;
        Xenero = xenero;
        this.autorId = autorId;
        this.usuarioId = usuarioId;
    }

    public Libro() {
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

    public String getXenero() {
        return Xenero;
    }

    public void setXenero(String xenero) {
        Xenero = xenero;
    }

    public Autor getAutorId() {
        return autorId;
    }

    public void setAutorId(Autor autorId) {
        this.autorId = autorId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", Xenero='" + Xenero + '\'' +
                ", autorId=" + autorId +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
