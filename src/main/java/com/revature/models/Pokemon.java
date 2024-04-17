package com.revature.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="pokemon")
public class Pokemon {


    @Id
    @Column(name = "pokemonId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pokemonId;
    @Column
    private String nickname;
    @Column
    private int level;
    @Column(nullable = false)
    private int pokedexEntry;
    @ManyToOne
    @JoinColumn(name = "trainersId")
    private Trainer trainer;


    public Pokemon() {

    }
    public Pokemon(String nickname, int level, int pokedexEntry, Trainer trainer) {
        this.nickname = nickname;
        this.level = level;
        this.pokedexEntry = pokedexEntry;
        this.trainer = trainer;
    }
    public Pokemon(int id, String nickname, int level, int pokedexEntry, Trainer trainer) {
        this.pokemonId = id;
        this.nickname = nickname;
        this.level = level;
        this.pokedexEntry = pokedexEntry;
        this.trainer = trainer;
    }
    public Pokemon(String nickname, int level, int pokedexEntry) {
        this.nickname = nickname;
        this.level = level;
        this.pokedexEntry = pokedexEntry;
    }
    public Pokemon(String nickname, int level) {
        this.nickname = nickname;
        this.level = level;
        this.pokedexEntry = 0;
    }
    public Pokemon(String nickname) {
        this.nickname = nickname;
        this.level = 0;
        this.pokedexEntry = 0;
    }
    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(int pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return pokedexEntry == pokemon.pokedexEntry && trainer == pokemon.trainer && Objects.equals(nickname, pokemon.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, pokedexEntry, trainer);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokemonId=" + pokemonId +
                ", nickname='" + nickname + '\'' +
                ", level=" + level +
                ", pokedexEntry=" + pokedexEntry +
                ", trainer=" + trainer +
                '}';
    }
}
