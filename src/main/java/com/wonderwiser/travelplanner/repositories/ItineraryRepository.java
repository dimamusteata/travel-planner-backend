package com.wonderwiser.travelplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonderwiser.travelplanner.entities.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long>{

}
