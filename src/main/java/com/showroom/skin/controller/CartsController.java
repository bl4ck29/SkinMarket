package com.showroom.skin.controller;

import java.util.List;
import java.util.Optional;

import com.showroom.skin.repository.CartsRepository;
import com.showroom.skin.model.Carts;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CartsController {
    private final CartsRepository repository;

    public CartsController(CartsRepository repository){
        this.repository = repository;
    }

    @GetMapping("/carts")
    List<Carts> findAll(){return repository.findAll();}

    @GetMapping("/carts/{id}")
    Optional<Carts> findOne(@PathVariable int id){
        return repository.findById(id);
    }

    @PutMapping("/carts/{id}")
    Carts modifyCart(@RequestBody Carts newCart, @PathVariable int id){
        return repository.findById(id).map(cart ->{
            cart.setUserId(newCart.getUserId());
            return repository.save(cart);
        }).orElseGet(() ->{
            newCart.setCartId(id);
            return repository.save(newCart);
        });
    }

    @DeleteMapping("/carts/{id}")
    void deleteCart(@PathVariable int id) {repository.deleteById(id);}
}   