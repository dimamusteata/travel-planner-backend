package com.wonderwiser.travelplanner.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonderwiser.travelplanner.entities.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long>{
	
	 Optional<Itinerary> findByTrip_Id(Long tripId);

}
