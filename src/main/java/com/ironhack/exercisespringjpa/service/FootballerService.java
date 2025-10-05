package com.ironhack.exercisespringjpa.service;

import com.ironhack.exercisespringjpa.model.Footballer;
import com.ironhack.exercisespringjpa.repository.FootballerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class FootballerService {
    public final FootballerRepository footballerRepository;

    public FootballerService(FootballerRepository footballerRepository){
        this.footballerRepository = footballerRepository;
    }
    public List<Footballer> getAll(){
        return footballerRepository.findAll();
    }
    public Footballer create(Footballer footballer){
        return footballerRepository.save(footballer);
    }
    public Footballer update (Footballer footballer) {
        return footballerRepository.save(footballer);
    }
    public void delete(UUID id){
         footballerRepository.deleteById(id);
    }
    public List<Footballer> findByNationality(String nationality){
        return footballerRepository.findFootballersByNationality(nationality);
    }
    public List<Footballer> findByPosition(String position){
        return footballerRepository.findFootballersByPosition(position);
    }
    public List<Footballer> findFootballersByAgeASC(){
        return footballerRepository.findFootballersByAgeASC();
    }
public List<Footballer> findFootballerByName(String name){
        return footballerRepository.findFootballerByName(name);
}
}