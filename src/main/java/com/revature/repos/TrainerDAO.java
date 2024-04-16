package com.revature.repos;

import com.revature.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerDAO extends JpaRepository<Trainer, Integer> {
}
