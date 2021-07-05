package com.showroom.skin.controller;

import java.util.List;
import java.util.Optional;

import com.showroom.skin.model.Users;
import com.showroom.skin.repository.UsersRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UsersController {
    private final UsersRepository repository;

    public UsersController(UsersRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    List<Users> findAll(){return repository.findAll();}

    @GetMapping("/users/{id}")
    Optional<Users> findOne(@PathVariable int id){
        return repository.findById(id);
    }

    @PutMapping("/users/{id}")
    Users modifyCart(@RequestBody Users newUser, @PathVariable int id){
        return repository.findById(id).map(user ->{
            user.setLoginType(newUser.getLoginType());
            user.setUserName(newUser.getUserName());
            user.setUserPasswd(newUser.getUserPasswd());
            user.setUserProfile(newUser.getUserProfile());
            user.setUserRole(newUser.getUserRole());
            return repository.save(user);
        }).orElseGet(() ->{
            newUser.setUserId(id);
            return repository.save(newUser);
        });
    }

    @DeleteMapping("/users/{id}")
    void deleteCart(@PathVariable int id) {repository.deleteById(id);}
}   