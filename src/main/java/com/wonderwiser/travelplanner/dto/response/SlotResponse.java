package com.wonderwiser.travelplanner.dto.response;

import java.time.LocalDate;

import com.wonderwiser.travelplanner.entities.Slot;
import com.wonderwiser.travelplanner.entities.enums.SlotStatus;
import com.wonderwiser.travelplanner.entities.enums.TimeOfDay;

public record SlotResponse(Long id, LocalDate day, TimeOfDay timeOfDay, String activityName, SlotStatus status,
		String notes) {
	public static SlotResponse of(Slot s) {
		return new SlotResponse(s.getId(), s.getDay(), s.getTimeOfDay(), // usa o teu getter
				s.getActivityName(), s.getStatus(), s.getNotes());
	}
}
