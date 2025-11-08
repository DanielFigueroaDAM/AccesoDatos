package Model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Nome", length = 80)
    private String nome;


    @Column(name = "DataRexistro")
    private Date dataRexistro;

    public Usuario(int id, String nome, Date dataRexistro) {
        this.id = id;
        this.nome = nome;
        this.dataRexistro = dataRexistro;
    }

    public Usuario() {
    }

    public Usuario(String nome, Date dataRexistro) {
        this.nome = nome;
        this.dataRexistro = dataRexistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataRexistro() {
        return dataRexistro;
    }

    public void setDataRexistro(Date dataRexistro) {
        this.dataRexistro = dataRexistro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataRexistro=" + dataRexistro +
                '}';
    }
}
