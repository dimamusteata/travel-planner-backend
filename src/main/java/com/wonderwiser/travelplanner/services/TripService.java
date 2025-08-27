package com.wonderwiser.travelplanner.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wonderwiser.travelplanner.entities.Trip;
import com.wonderwiser.travelplanner.entities.User;
import com.wonderwiser.travelplanner.repositories.ItineraryRepository;
import com.wonderwiser.travelplanner.repositories.SlotRepository;
import com.wonderwiser.travelplanner.repositories.TripRepository;
import com.wonderwiser.travelplanner.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class TripService {
	
	private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final ItineraryRepository itineraryRepository;
    private final SlotRepository slotRepository;
    
	public TripService(TripRepository tripRepository, UserRepository userRepository,
			ItineraryRepository itineraryRepository, SlotRepository slotRepository) {
		super();
		this.tripRepository = tripRepository;
		this.userRepository = userRepository;
		this.itineraryRepository = itineraryRepository;
		this.slotRepository = slotRepository;
	}
	
	@Transactional
	 public Trip createTrip(Long userId, String title, LocalDate start, LocalDate end) {
	        User user = userRepository.findById(userId).get(); // sem validações
	        Trip t = new Trip(null, title, start, end, user);
	        return tripRepository.save(t);
	    }
	
	@Transactional
    public Trip getTrip(Long tripId) {
        return tripRepository.findById(tripId).get();
    }
	
	@Transactional
	public List<Trip> findAll(){
		return tripRepository.findAll();
	}
}
