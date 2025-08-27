package com.wonderwiser.travelplanner.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wonderwiser.travelplanner.dto.request.SlotUpdateRequest;
import com.wonderwiser.travelplanner.dto.response.SlotResponse;
import com.wonderwiser.travelplanner.entities.Slot;
import com.wonderwiser.travelplanner.repositories.SlotRepository;
import com.wonderwiser.travelplanner.services.ItineraryGeneratorService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/trips")
public class TripItineraryResource {

    private final ItineraryGeneratorService generator;
    private final SlotRepository slotRepo;

    public TripItineraryResource(ItineraryGeneratorService generator, SlotRepository slotRepo) {
        this.generator = generator;
        this.slotRepo = slotRepo;
    }

    // POST /trips/{id}/itinerary:generate
    @PostMapping("/{id}/itinerary:generate")
    public ResponseEntity<List<SlotResponse>> generate(@PathVariable Long id) {
        List<Slot> slots = generator.generateForTrip(id);
        List<SlotResponse> body = slots.stream().map(SlotResponse::of).toList();
        return ResponseEntity.ok(body);
    }

    // PATCH /trips/{id}/slots/{slotId}
    @PatchMapping("/{id}/slots/{slotId}")
    public ResponseEntity<SlotResponse> updateSlot(
            @PathVariable Long id,
            @PathVariable Long slotId,
            @RequestBody SlotUpdateRequest req) {

    	Slot slot = slotRepo.findByIdAndItineraryTrip_Id(slotId, id)
    		    .orElseThrow(() -> new EntityNotFoundException("Slot not found for this trip"));

        if (req.notes() != null) slot.setNotes(req.notes());
        if (req.status() != null) slot.setStatus(req.status());

        Slot saved = slotRepo.save(slot);
        return ResponseEntity.ok(SlotResponse.of(saved));
    }
}
