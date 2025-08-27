package com.wonderwiser.travelplanner.entities;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wonderwiser.travelplanner.entities.enums.SlotStatus;
import com.wonderwiser.travelplanner.entities.enums.TimeOfDay;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_slot")
public class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private TimeOfDay timeOfDay;
	private String activityName;
	private SlotStatus status;
	private String notes;
	@Column(name = "slot_day") 
	private LocalDate day;


	
	@ManyToOne
	@JoinColumn(name = "itinerary_id")
	@JsonIgnore
	private Itinerary itinerary;
	
	public Slot() {
		
	}

	public Slot(Long id, TimeOfDay timeofDay, String activityName, SlotStatus status, String notes, Itinerary itinierary) {
		this.id = id;
		this.timeOfDay = timeofDay;
		this.activityName = activityName;
		this.status = status;
		this.notes = notes;
		this.itinerary = itinierary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TimeOfDay getTimeofDay() {
		return timeOfDay;
	}

	public void setTimeofDay(TimeOfDay timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public LocalDate getDay() { return day; }
	public void setDay(LocalDate day) { this.day = day; }

	public SlotStatus getStatus() {
		return status;
	}

	public void setStatus(SlotStatus status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}


	public TimeOfDay getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(TimeOfDay timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Slot other = (Slot) obj;
	    // Se algum id é null, considere diferentes (evita colapsar no Set)
	    if (this.id == null || other.id == null) return false;
	    return Objects.equals(this.id, other.id);
	}

	@Override
	public int hashCode() {
	    // Se id é null, usa um hash constante pequeno para não quebrar o contrato
	    return (id == null) ? 31 : id.hashCode();
	}
	
}
