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

    @Column(name = "nacimiento")
    private Date nacimiento;
    @Column(name = "PokedexEntry")
    private int pokedexEntry;
    @Column(name = "adestrador")
    private int adestrador;

    public Pokemon(String nome, Date nacimiento, int pokedexEntry, int adestrador) {
        this.nome = nome;
        this.nacimiento = nacimiento;
        this.pokedexEntry = pokedexEntry;
        this.adestrador = adestrador;
    }

    public Pokemon(int idPokemon, String nome, Date nacimiento, int pokedexEntry, int adestrador) {
        this.idPokemon = idPokemon;
        this.nome = nome;
        this.nacimiento = nacimiento;
        this.pokedexEntry = pokedexEntry;
        this.adestrador = adestrador;
    }

    public Pokemon() {
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

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
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
                ", fechaNacimiento=" + nacimiento +
                ", pokedexEntry=" + pokedexEntry +
                ", adestrador=" + adestrador +
                '}';
    }
}
