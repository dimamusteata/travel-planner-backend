package com.wonderwiser.travelplanner.entities.enums;

public enum SlotStatus {

	FREE(1),
	RESERVERD(2),
	BOOKED(3);
	
	private int code;
	
	private SlotStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static SlotStatus valueOf(int code) {
		for(SlotStatus value : SlotStatus.values()) {
			if (value.code == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid SlotStatus code");
	}
}
