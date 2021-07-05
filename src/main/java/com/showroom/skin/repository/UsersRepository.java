package com.showroom.skin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.showroom.skin.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	List<Users> findAll();
	Optional<Users> findOne();
	Users modifyCart();
	void deleteCart();
}