package com.wonderwiser.travelplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonderwiser.travelplanner.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
}
