package com.revature.controllers;

import com.revature.exceptions.TrainerNotFoundException;
import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    private TrainerService ts;

    @Autowired
    public TrainerController(TrainerService ts) {
        this.ts = ts;
    }

    @GetMapping
    public List<Trainer> getAllTrainersHandler() {
        return ts.getAllTrainers();
    }

    @PostMapping
    public Trainer createTrainerHandler(@RequestBody Trainer trainer) {
        return ts.createTrainer(trainer);
    }

    @GetMapping("{id}")
    public ResponseEntity<Trainer> getTrainerByIdHandler(@PathVariable int id) {
        Trainer trainer;
        try {
            trainer = ts.findTrainerById(id);
        } catch (TrainerNotFoundException e) {
            return new ResponseEntity<>(NOT_FOUND);
        }
        return new ResponseEntity<>(trainer, OK);
    }

    // TODO PATCH /trainers/{id}
    // @PatchMapping("{id}")
    // public ResponseEntity<Trainer> updateTrainerByIdHandler(@PathVariable int id) {
    //     Trainer trainer;
    //     if (ts.exists(id)) {
    //         try {
    //             trainer = ts.editTrainer()
    //         } catch (TrainerNotFoundException e) {
    //             return new ResponseEntity<>(NOT_FOUND);
    //         }
    //     }

    //     return new ResponseEntity<>(trainer, OK);
    // }
    // TODO DELETE /trainers/{id}
}
