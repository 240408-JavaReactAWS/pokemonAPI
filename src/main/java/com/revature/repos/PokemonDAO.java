package com.revature.repos;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {
    public List<Pokemon> findAllByTrainer(Trainer trainer);
}
