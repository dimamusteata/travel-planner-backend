package com.wonderwiser.travelplanner.dto.response;

import java.time.LocalDate;

public class TripResponse {
	
	private Long id;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long userId;
	private String userName;

	public TripResponse() {
	}

	public TripResponse(Long id, String title, LocalDate startDate, LocalDate endDate, Long userId,
			String userName) {
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	

}
