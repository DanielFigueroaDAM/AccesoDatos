package model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPokemon;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    private Date fechaNacimiento;
    private int pokedexEntry;
    private int adestrador;

    public Pokemon(String nome, Date fechaNacimiento, int pokedexEntry, int adestrador) {
        this.nome = nome;
        this.fechaNacimiento = fechaNacimiento;
        this.pokedexEntry = pokedexEntry;
        this.adestrador = adestrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(int pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public int getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(int adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "idPokemon=" + idPokemon +
                ", nome='" + nome + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", pokedexEntry=" + pokedexEntry +
                ", adestrador=" + adestrador +
                '}';
    }
}
