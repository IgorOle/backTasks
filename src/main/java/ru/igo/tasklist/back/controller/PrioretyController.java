package ru.igo.tasklist.back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.igo.tasklist.back.entity.Priority;
import ru.igo.tasklist.back.repository.PriorityRepository;

@RestController
@RequestMapping("/priority")
public class PrioretyController {
    private PriorityRepository prioretyRepository;

    public PrioretyController(PriorityRepository prioretyRepository) {
        this.prioretyRepository = prioretyRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {
        Priority save = prioretyRepository.save(priority);
        return  ResponseEntity.ok(save);
    }

    @PutMapping("/save")
    public ResponseEntity<Priority> save(@RequestBody Priority priority) {
        Priority save = prioretyRepository.save(priority);
        return  ResponseEntity.ok(save);
    }
}
