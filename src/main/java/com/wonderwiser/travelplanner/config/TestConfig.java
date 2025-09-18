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
import com.wonderwiser.travelplanner.services.ItineraryGeneratorService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    private final ItineraryGeneratorService itineraryGeneratorService;

	private final UserRepository userRepository;
	private final SlotRepository slotRepository;
	private final ItineraryRepository itineraryRepository;
	private final TripRepository tripRepository;
	
	
	public TestConfig(UserRepository userRepository, SlotRepository slotRepository, 
			ItineraryRepository itineraryRepository, TripRepository tripRepository, ItineraryGeneratorService itineraryGeneratorService) {
		
		this.userRepository = userRepository;
		this.slotRepository = slotRepository;
		this.itineraryRepository = itineraryRepository;
		this.tripRepository = tripRepository;
		this.itineraryGeneratorService = itineraryGeneratorService;
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		User user1 = new User(null, "Alex Green", "alex@gmail.com", "1q2w3e");
		User user2 = new User(null, "Mary Grey", "mary@hotmail.com", "12345");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Trip trip1= new Trip(null, "Canada", LocalDate.of(2025, 12, 18), LocalDate.of(2026, 1, 3), user1);
		Trip trip2= new Trip(null, "Madeira", LocalDate.of(2025, 8, 22), LocalDate.of(2025, 8, 24), user2);
		
		tripRepository.saveAll(Arrays.asList(trip1, trip2));
		user1.getTrips().add(trip1);
		user2.getTrips().add(trip2);
		
		Itinerary it1 = new Itinerary(null, LocalDate.now(), trip1); 
		Itinerary it2 = new Itinerary(null, LocalDate.of(2025, 12, 20), trip2); 

		itineraryRepository.saveAll(Arrays.asList(it1, it2));
		
		Slot slot1 = new Slot(null, TimeOfDay.MORNING, "Walk on the beach", SlotStatus.RESERVERD, "Also visit the local CofeShop and try the expresso late, everyone seems to love it", it1);
		Slot slot2 = new Slot(null, TimeOfDay.AFTERNOON, "Go to the crazy disco club", SlotStatus.RESERVERD, "Tonights its Afro night :)", it2);
		
		ItineraryGeneratorService slotGenerator = new ItineraryGeneratorService(tripRepository, itineraryRepository);
		
		 // 3) gerar slots para cada trip (idempotente)
	    itineraryGeneratorService.generateForTrip(trip1.getId());
	    itineraryGeneratorService.generateForTrip(trip2.getId());
		
	    
	}

}
