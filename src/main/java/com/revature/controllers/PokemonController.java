package com.revature.controllers;

import com.revature.models.Pokemon;
import com.revature.exceptions.TrainerNotFoundException;
import com.revature.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PokemonController {
    PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping(value = "/trainers/{trainer_id}/pokemon")
    public ResponseEntity<?> createPokemon(@PathVariable int trainer_id, @RequestBody Pokemon pokemon) {
        try {
            Pokemon addedPokemon = pokemonService.addPokemon(trainer_id, pokemon);
            return ResponseEntity.ok().body(addedPokemon);
        } catch (TrainerNotFoundException t) {
            System.out.println(t.getMessage());
        }
        return ResponseEntity.status(400).build();
    }
    @GetMapping(value = "/pokemon/{pokemon_id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable int pokemon_id) {
        Pokemon pokemon = pokemonService.retrievePokemon(pokemon_id);
        if (pokemon != null) {
            return ResponseEntity.ok().body(pokemon);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }
    @GetMapping(value="/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        return ResponseEntity.ok().body(pokemonService.retrieveAllPokemon());
    }
    @DeleteMapping(value="/pokemon/{pokemon_id}")
    public ResponseEntity<?> deletePokemon(@PathVariable int pokemon_id) {
        if (pokemonService.deletePokemonById(pokemon_id)) {
            return ResponseEntity.ok().body(1);
        }
        return ResponseEntity.status(400).body(0);
    }
}
