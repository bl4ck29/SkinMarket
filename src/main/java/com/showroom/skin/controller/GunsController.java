package com.showroom.skin.controller;

import java.util.List;
import java.util.Optional;

import com.showroom.skin.repository.GunsRepository;
import com.showroom.skin.model.Guns;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GunsController {
    private final GunsRepository gunsRepository;

    public GunsController(GunsRepository gunsRepository){
        this.gunsRepository = gunsRepository;
    }

    @GetMapping("/gun_type")
    List<Guns> findAll(){return gunsRepository.findAll();}

    @GetMapping("/gun_type/{id}")
    Optional<Guns> findOne(@PathVariable int id){
        return gunsRepository.findById(id);
    }

    @PutMapping("/gun_type/{id}")
    Guns modifyCart(@RequestBody Guns newGun, @PathVariable int id){
        return gunsRepository.findById(id).map(gun ->{
            gun.setGunType(newGun.getGunType());
            gun.setGunName(newGun.getGunName());
            return gunsRepository.save(gun);
        }).orElseGet(() ->{
            newGun.setGunId(id);
            return gunsRepository.save(newGun);
        });
    }

    @DeleteMapping("/gun_type/{id}")
    void deleteCart(@PathVariable int id) {gunsRepository.deleteById(id);}
}   