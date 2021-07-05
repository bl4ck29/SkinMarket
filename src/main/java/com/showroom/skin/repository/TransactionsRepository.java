package com.showroom.skin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showroom.skin.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
	List<Transactions> findAll();
	Optional<Transactions> findOne();
	Transactions modifyCart();
	void deleteCart();
}