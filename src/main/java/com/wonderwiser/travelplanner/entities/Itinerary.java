package com.wonderwiser.travelplanner.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itinerary")
public class Itinerary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "itinerary_day")		// Necessário porque "day" é um campo reservado pelo H2. Altera o nome do campo em DB
	private LocalDate day;

	@ManyToOne()
	@JoinColumn(name = "trip_id")
	private Trip trip;
	
	
	@OneToMany(mappedBy = "itinerary")
	@OrderBy("timeOfDay ASC")
	private Set<Slot> slots = new HashSet<>();
	
	public Itinerary() {
		
	}

	public Itinerary(Long id, LocalDate day, Trip trip) {
		this.id = id;
		this.day = day;
		this.trip = trip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}
	
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itinerary other = (Itinerary) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
