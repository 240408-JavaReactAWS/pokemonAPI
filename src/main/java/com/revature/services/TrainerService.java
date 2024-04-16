package com.revature.services;

import com.revature.exceptions.TrainerNotFoundException;
import com.revature.models.Trainer;
import com.revature.repos.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {
    private TrainerDAO td;

    @Autowired
    public TrainerService(TrainerDAO td) {
        this.td = td;
    }

    public List<Trainer> getAllTrainers() {
        return td.findAll();
    }

    public Trainer findTrainerById(int id) throws TrainerNotFoundException {
        return td.findById(id).orElseThrow(() -> new TrainerNotFoundException("No Trainer found with id: " + id));
    }

    public Trainer createTrainer(Trainer trainer) {
        return td.save(trainer);
    }

    public boolean existsById(int id) {
        return td.existsById(id);
    }

    public Trainer edit(int id, Trainer updatedTrainer) {
        Optional<Trainer> optTrainer = td.findById(id);
        if (optTrainer.isPresent()) {
            Trainer trainer = optTrainer.get();
            trainer.setName(updatedTrainer.getName());
            trainer.setAge(updatedTrainer.getAge());
            trainer.setRegion(updatedTrainer.getRegion());
            td.save(trainer);
            return trainer;
        } else {
            return null;
        }
    }

    public String deleteById(int id) {
        if (this.existsById(id)) {
            td.deleteById(id);
            return "1";
        }
        return "";
    }
}
