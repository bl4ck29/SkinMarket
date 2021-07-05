package com.showroom.skin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showroom.skin.model.Patterns;

public interface PatternsRepository extends JpaRepository<Patterns, Integer> {
	List<Patterns> findAll();
	Optional<Patterns> findOne();
	Patterns modifyCart();
	void deleteCart();
}