package com.wonderwiser.travelplanner.entities.enums;

public enum TimeOfDay {

	MORNING(1),
	AFTERNOON(2),
	EVENING(3),
	NIGHT(4);
	
	private int code;
	
	private TimeOfDay(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TimeOfDay valueOf(int code) {
		for(TimeOfDay time : TimeOfDay.values()) {
			if(time.code == code) return time;
		}
		throw new IllegalArgumentException("Invalid TimeOfDay code");
	}
}
