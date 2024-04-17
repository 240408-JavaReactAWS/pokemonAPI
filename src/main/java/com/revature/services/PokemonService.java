package com.revature.services;

import com.revature.exceptions.TrainerNotFoundException;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repos.PokemonDAO;
import com.revature.repos.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class PokemonService {
    private PokemonDAO pokemonDAO;
    private TrainerDAO trainerDAO;

    @Autowired
    public PokemonService(PokemonDAO pokemonDAO, TrainerDAO trainerDAO) {
        this.pokemonDAO = pokemonDAO;
        this.trainerDAO = trainerDAO;
    }


    public Pokemon addPokemon (int trainerId, Pokemon pokemon) throws TrainerNotFoundException {
        Optional<Trainer> trainerOpt = trainerDAO.findById(trainerId);
        if (trainerOpt.isPresent()) {
            Trainer trainer = trainerOpt.get();
            pokemon.setTrainer(trainer);
            return pokemonDAO.save(pokemon);
        } else {
            throw new TrainerNotFoundException("Trainer has not registered yet");
        }
    }
    public Pokemon retrievePokemon (int pokemonId) {
        Optional<Pokemon> pokemonOpt = pokemonDAO.findById(pokemonId);
        if (pokemonOpt.isPresent()) {
            return pokemonOpt.get();
        } else {
            return null;
        }

    }
    public List<Pokemon> retrieveAllPokemon() {
        return pokemonDAO.findAll();
    }
    public List<Pokemon> retrieveAllPokemonByTrainerId(int trainerId) {
        Optional<Trainer> trainerOpt = trainerDAO.findById(trainerId);
        if (trainerOpt.isPresent()) {
            Trainer trainer = trainerOpt.get();
            return pokemonDAO.findAllByTrainer(trainer);
        } else {
            return null;
        }
    }
    public boolean deletePokemonById(int pokemonId) {
        Pokemon pokemon = this.retrievePokemon(pokemonId);
        if (pokemon == null) {
            return false;
        } else {
            pokemonDAO.deleteById(pokemonId);
            return true;
        }
    }
    // This is for when we want to alter the nickname or level of a specific Pokemon.
    public Pokemon updatePokemonById(int pokemonId, Pokemon pokemonEdit) {
        Pokemon storedPokemon = this.retrievePokemon(pokemonId);
        if (storedPokemon == null) {
            return null;
        }
        if (pokemonEdit.getNickname()!= null) {
            if (!pokemonEdit.getNickname().isEmpty()) {
                storedPokemon.setNickname(pokemonEdit.getNickname());
            }
        }
        if (pokemonEdit.getLevel() > storedPokemon.getLevel()) {
            storedPokemon.setLevel(pokemonEdit.getLevel());
        }
        return pokemonDAO.save(storedPokemon);
    }
}
