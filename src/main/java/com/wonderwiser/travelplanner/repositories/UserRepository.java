package com.wonderwiser.travelplanner.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonderwiser.travelplanner.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
}
