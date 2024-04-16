package com.revature.repos;

import com.revature.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TrainerDAO extends JpaRepository<Trainer, Integer> {
    Optional<Trainer> findById(int id);
    boolean existsById(int id);
}
