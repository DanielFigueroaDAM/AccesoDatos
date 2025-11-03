package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Adestrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int idAdestrador;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    private Date nacemento;

    public Adestrador() {
    }

    public Adestrador(String nome, Date nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    public Adestrador(int idAdestrador, String nome, Date nacemento) {
        this.idAdestrador = idAdestrador;
        this.nome = nome;
        this.nacemento = nacemento;
    }

    public int getIdAdestrador() {
        return idAdestrador;
    }

    public void setIdAdestrador(int idAdestrador) {
        this.idAdestrador = idAdestrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "idAdestrador=" + idAdestrador +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}
