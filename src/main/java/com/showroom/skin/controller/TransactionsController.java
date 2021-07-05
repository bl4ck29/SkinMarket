package com.showroom.skin.controller;

import java.util.List;
import java.util.Optional;

import com.showroom.skin.model.Transactions;
import com.showroom.skin.repository.TransactionsRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TransactionsController {
    private final TransactionsRepository repository;

    public TransactionsController(TransactionsRepository repository){
        this.repository = repository;
    }

    @GetMapping("/transactions")
    List<Transactions> findAll(){return repository.findAll();}

    @GetMapping("/Transactions/{id}")
    Optional<Transactions> findOne(@PathVariable int id){
        return repository.findById(id);
    }

    @PutMapping("/transactions/{id}")
    Transactions modifyCart(@RequestBody Transactions newTrans, @PathVariable int id){
        return repository.findById(id).map(trans ->{
            trans.setCartId(newTrans.getCartId());
            trans.setItemId(newTrans.getItemId());
            trans.setTransStatus(newTrans.getTransStatus());
            trans.setUpdateTime(newTrans.getUpdateTime());
            return repository.save(trans);
        }).orElseGet(() ->{
            newTrans.setTransId(id);
            return repository.save(newTrans);
        });
    }

    @DeleteMapping("/transactions/{id}")
    void deleteCart(@PathVariable int id) {repository.deleteById(id);}
}   