package com.wonderwiser.travelplanner.services;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wonderwiser.travelplanner.entities.Itinerary;
import com.wonderwiser.travelplanner.entities.Slot;
import com.wonderwiser.travelplanner.entities.Trip;
import com.wonderwiser.travelplanner.entities.enums.SlotStatus;
import com.wonderwiser.travelplanner.entities.enums.TimeOfDay;
import com.wonderwiser.travelplanner.repositories.ItineraryRepository;
import com.wonderwiser.travelplanner.repositories.TripRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class ItineraryGeneratorService {

    private final TripRepository tripRepo;
    private final ItineraryRepository itinRepo;	

    public ItineraryGeneratorService(TripRepository tripRepo, ItineraryRepository itinRepo) {
        this.tripRepo = tripRepo;
        this.itinRepo = itinRepo;
    }

    @Transactional
    public List<Slot> generateForTrip(Long tripId) {
        Trip trip = tripRepo.findById(tripId)
            .orElseThrow(() -> new EntityNotFoundException("Trip not found"));

        Itinerary itin = itinRepo.findByTrip_Id(tripId).orElseGet(() -> {
            Itinerary i = new Itinerary();
            i.setTrip(trip);
            return i;
        });

        // limpar e regenerar
        itin.getSlots().clear();

        LocalDate d = trip.getStartDate();
        while (!d.isAfter(trip.getEndDate())) {
            addSlot(itin, d, TimeOfDay.MORNING,   "Manhã — (stub)");
            addSlot(itin, d, TimeOfDay.AFTERNOON, "Tarde — (stub)");
            addSlot(itin, d, TimeOfDay.EVENING,   "Noite — (stub)");
            d = d.plusDays(1);
        }

        Itinerary saved = itinRepo.saveAndFlush(itin);

        return saved.getSlots().stream()
            .sorted(Comparator.comparing(Slot::getDay)
                              .thenComparing(Slot::getTimeOfDay))
            .toList();
    }
    
    private void addSlot(Itinerary itin, LocalDate day, TimeOfDay tod, String title) {
        Slot s = new Slot();
        s.setItinerary(itin);
        s.setDay(day);
        s.setTimeOfDay(tod);
        s.setActivityName(title);
        s.setStatus(SlotStatus.FREE);
        s.setNotes(null);
        itin.getSlots().add(s);
    }
}
