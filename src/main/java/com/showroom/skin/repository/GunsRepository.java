package com.showroom.skin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showroom.skin.model.Guns;

public interface GunsRepository extends JpaRepository<Guns, Integer>{
    List<Guns> findAll();
    Optional<Guns> findOne();
    Guns modifyGun();
    void deleteGun();
}