package com.revature.repos;

import com.revature.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {
}
