package com.wonderwiser.travelplanner.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wonderwiser.travelplanner.entities.Itinerary;
import com.wonderwiser.travelplanner.entities.Slot;
import com.wonderwiser.travelplanner.entities.Trip;
import com.wonderwiser.travelplanner.entities.User;
import com.wonderwiser.travelplanner.entities.enums.SlotStatus;
import com.wonderwiser.travelplanner.entities.enums.TimeOfDay;
import com.wonderwiser.travelplanner.repositories.ItineraryRepository;
import com.wonderwiser.travelplanner.repositories.SlotRepository;
import com.wonderwiser.travelplanner.repositories.TripRepository;
import com.wonderwiser.travelplanner.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	private final UserRepository userRepository;
	private final SlotRepository slotRepository;
	private final ItineraryRepository itineraryRepository;
	private final TripRepository tripRepository;
	
	
	public TestConfig(UserRepository userRepository, SlotRepository slotRepository, 
			ItineraryRepository itineraryRepository, TripRepository tripRepository) {
		
		this.userRepository = userRepository;
		this.slotRepository = slotRepository;
		this.itineraryRepository = itineraryRepository;
		this.tripRepository = tripRepository;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		// Cria os Objetos
		User user1 = new User(null, "Alex Green", "alex@gmail.com", "1q2w3e");
		User user2 = new User(null, "Mary Grey", "mary@hotmail.com", "12345");
		
		Slot slot1 = new Slot(null, TimeOfDay.MORNING, "Walk on the beach", SlotStatus.RESERVERD, "Also visit the local Cofe and try the expresso late, everyone seems to love it");
		Slot slot2 = new Slot(null, TimeOfDay.AFTERNOON, "Go to the crazy disco club", SlotStatus.RESERVERD, "Tonights its Afro night :)");
	
		Itinerary it1 = new Itinerary(null, LocalDate.now()); 
		Itinerary it2 = new Itinerary(null, LocalDate.of(2025, 12, 20)); 
		
		Trip trip1= new Trip(null, "Canada", LocalDate.of(2025, 12, 18), LocalDate.of(2026, 1, 3));
		Trip trip2= new Trip(null, "Madeira", LocalDate.of(2025, 8, 22), LocalDate.of(2025, 8, 24));
		
		// Guarda na BD
		userRepository.saveAll(Arrays.asList(user1, user2));
		slotRepository.saveAll(Arrays.asList(slot1, slot2));
		itineraryRepository.saveAll(Arrays.asList(it1, it2));
		tripRepository.saveAll(Arrays.asList(trip1, trip2));
		
		
	}

}
