package model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int idPokemon;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "Nacemento")
    private Date nacemento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PokedexEntry")
    private Pokedex pokedexEntry;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Adestrador")
    private Adestrador adestrador;

    public Pokemon(String nome, Date nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexEntry = pokedexEntry;
        this.adestrador = adestrador;
    }

    public Pokemon(int idPokemon, String nome, Date nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        this.idPokemon = idPokemon;
        this.nome = nome;
        this.nacemento = nacemento;
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

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public Pokedex getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(Pokedex pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "idPokemon=" + idPokemon +
                ", nome='" + nome + '\'' +
                ", fechaNacimiento=" + nacemento +
                ", pokedexEntry=" + pokedexEntry +
                ", adestrador=" + adestrador +
                '}';
    }
}
