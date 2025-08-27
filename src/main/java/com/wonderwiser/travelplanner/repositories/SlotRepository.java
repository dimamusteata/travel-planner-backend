package com.wonderwiser.travelplanner.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wonderwiser.travelplanner.entities.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long>{
	 Optional<Slot> findByIdAndItineraryTrip_Id(Long slotId, Long tripId);
}
