package com.showroom.skin.controller;

import java.util.List;
import java.util.Optional;

import com.showroom.skin.model.Patterns;
import com.showroom.skin.repository.PatternsRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatternsController{
    private final PatternsRepository repository;

    public PatternsController(PatternsRepository repository){
        this.repository = repository;
    }

    @GetMapping("/patterns")
    List<Patterns> findAll(){return repository.findAll();}

    @GetMapping("/patterns/{id}")
    Optional<Patterns> findOne(@PathVariable int id){
        return repository.findById(id);
    }

    @PutMapping("/patterns/{id}")
    Patterns modifyPatterns(@RequestBody Patterns newPattern, @PathVariable int id){
        return repository.findById(id).map(patt ->{
            patt.setPatternName(newPattern.getPatternName());
            return repository.save(patt);
        }).orElseGet(() ->{
            newPattern.setPatternId(id);
            return repository.save(newPattern);
        });
    }
}