package com.wonderwiser.travelplanner.dto.request;

import java.time.LocalDate;

public class CreateTripRequest {
	
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	

	public CreateTripRequest() {
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	    
	
}
