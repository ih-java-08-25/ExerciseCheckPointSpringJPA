package com.ironhack.exercisespringjpa.controller;

import com.ironhack.exercisespringjpa.model.Footballer;
import com.ironhack.exercisespringjpa.service.FootballerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/footballers")
public class FootballerController {
    public final FootballerService footballerService;

    public FootballerController (FootballerService footballerService){
        this.footballerService = footballerService;
    }
    @GetMapping
    public List<Footballer> findAll(){
        return footballerService.getAll();
    }
    @PostMapping("/create")
    public Footballer create(@RequestBody Footballer footballer){
        return footballerService.create(footballer);
    }
    @PutMapping("/update")
    public Footballer update (@RequestBody Footballer footballer){
        return footballerService.update(footballer);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        footballerService.delete(id);
    }
    @GetMapping("/findByAge")
    public List<Footballer> findByAge(){
        return footballerService.findFootballersByAgeASC();
    }
    @GetMapping("/findByName")
    public List<Footballer> findByName(@RequestParam String name){
        return footballerService.findFootballerByName(name);
    }
    }

