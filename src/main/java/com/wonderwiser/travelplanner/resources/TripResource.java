package com.wonderwiser.travelplanner.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wonderwiser.travelplanner.dto.request.CreateTripRequest;
import com.wonderwiser.travelplanner.dto.response.TripResponse;
import com.wonderwiser.travelplanner.entities.Trip;
import com.wonderwiser.travelplanner.services.TripService;

@RestController
@RequestMapping(value = "/trips")
public class TripResource {
	
	@Autowired
	private TripService service;
	
	@GetMapping
	public ResponseEntity<List<Trip>> findAll(){
		List<Trip> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trip> findById(@PathVariable Long id){
		Trip obj = service.getTrip(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<TripResponse> create(@PathVariable Long userId,
	                                           @RequestBody CreateTripRequest req) {
	    Trip t = service.createTrip(userId, req.getTitle(), req.getStartDate(), req.getEndDate());
	    TripResponse out = toResponse(t); // converte Entidade → DTO de saída
	    return ResponseEntity.status(201).body(out);
	}
	
	
	private TripResponse toResponse(Trip t) {
	    Long uid = (t.getUser() != null) ? t.getUser().getId() : null;
	    String uname = (t.getUser() != null) ? t.getUser().getName() : null;
	    return new TripResponse(t.getId(), t.getTitle(), t.getStartDate(), t.getEndDate(), uid, uname);
	}

}
