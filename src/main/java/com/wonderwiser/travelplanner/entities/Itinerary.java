package com.wonderwiser.travelplanner.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itinerary")
public class Itinerary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "itinerary_day")		// Necessário porque "day" é um campo reservado pelo H2. Altera o nome do campo em DB
	private LocalDate day;
	
	public Itinerary() {
		
	}

	public Itinerary(Long id, LocalDate day) {
		this.id = id;
		this.day = day;
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
	
}
