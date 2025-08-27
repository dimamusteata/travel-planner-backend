package com.wonderwiser.travelplanner.dto.request;

import com.wonderwiser.travelplanner.entities.enums.SlotStatus;

public record SlotUpdateRequest(String notes, SlotStatus status) {
}