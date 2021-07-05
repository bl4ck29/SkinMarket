package com.showroom.skin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showroom.skin.model.Carts;

public interface CartsRepository extends JpaRepository<Carts, Integer> {
	List<Carts> findAll();
	Optional<Carts> findOne();
	Carts modifyCart();
	void deleteCart();
}