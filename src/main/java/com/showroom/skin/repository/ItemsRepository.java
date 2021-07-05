package com.showroom.skin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showroom.skin.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
	List<Items> findAll();
	Optional<Items> findOne();
	Items modifyCart();
	void deleteCart();
}