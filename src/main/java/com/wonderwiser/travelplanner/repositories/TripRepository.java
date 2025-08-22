package com.wonderwiser.travelplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonderwiser.travelplanner.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{

}
