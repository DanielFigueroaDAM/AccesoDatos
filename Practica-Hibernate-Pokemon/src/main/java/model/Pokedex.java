package model;

import javax.persistence.*;
@Entity
@Table(name = "Pokedex")
public class Pokedex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long idPokedex;

    @Column(name = "nome",nullable = false,length = 50)
    private String nome;

    @Column(name = "Peso", precision = 10, scale = 2)
    private double peso;

    @Column(name = "Misc")
    private String misc;

    public Pokedex() {
    }

    public Pokedex(String nome, double peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public Pokedex(Long idPokedex, String nome, double peso, String misc) {
        this.idPokedex = idPokedex;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public Long getIdPokedex() {
        return idPokedex;
    }

    public void setIdPokedex(Long idPokedex) {
        this.idPokedex = idPokedex;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "idPokedex=" + idPokedex +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", misc='" + misc + '\'' +
                '}';
    }
}
