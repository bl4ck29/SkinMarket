package com.showroom.skin.controller;

import java.util.List;
import java.util.Optional;

import com.showroom.skin.model.Items;
import com.showroom.skin.repository.ItemsRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ItemsController {
    private final ItemsRepository itemsRepository;

    public ItemsController(ItemsRepository itemsRepository){
        this.itemsRepository = itemsRepository;
    }

    @GetMapping("/items")
    List<Items> findAll(){return itemsRepository.findAll();}

    @GetMapping("/items/{id}")
    Optional<Items> findOne(@PathVariable int id){
        return itemsRepository.findById(id);
    }

    @PutMapping("/items/{id}")
    Items modifyCart(@RequestBody Items newItem, @PathVariable int id){
        return itemsRepository.findById(id).map(item ->{
            item.setAuthor(newItem.getAuthor());
            item.setGunId(newItem.getGunId());
            item.setItemImage(newItem.getItemImage());
            item.setPatternId(newItem.getPatternId());
            return itemsRepository.save(item);
        }).orElseGet(() ->{
            newItem.setItemId(id);;
            return itemsRepository.save(newItem);
        });
    }

    @DeleteMapping("items/{id}")
    void deleteCart(@PathVariable int id) {itemsRepository.deleteById(id);}
}   