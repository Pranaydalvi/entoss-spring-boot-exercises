package com.pranay.entoss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranay.entoss.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
