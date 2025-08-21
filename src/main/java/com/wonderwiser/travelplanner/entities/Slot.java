package com.wonderwiser.travelplanner.entities;

import java.util.Objects;

import com.wonderwiser.travelplanner.entities.enums.SlotStatus;
import com.wonderwiser.travelplanner.entities.enums.TimeOfDay;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Slot() {
		
	}

	public Slot(Long id, TimeOfDay timeofDay, String activityName, SlotStatus status, String notes) {
		this.id = id;
		this.timeOfDay = timeofDay;
		this.activityName = activityName;
		this.status = status;
		this.notes = notes;
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
		Slot other = (Slot) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
