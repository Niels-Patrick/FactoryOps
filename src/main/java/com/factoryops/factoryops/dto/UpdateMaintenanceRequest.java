package com.factoryops.factoryops.dto;

import java.time.LocalDate;

import com.factoryops.factoryops.entity.enums.MaintenanceType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateMaintenanceRequest {
	// Properties
	@NotNull(message = "Maintenance date is required")
	private LocalDate maintenanceDate;
	
	@NotBlank(message = "Technician name is required")
	@Size(
			max = 100,
			message = "Technician name cannot exceed 100 characters"
			)
	private String technician;
	
	@NotNull(message = "Maintenance duration (hours) is required")
	@Min(
			value = 0,
			message = "Maintenance duration (hours) cannot be negative"
			)
	private Integer durationHours;
	
	@NotNull(message = "Maintenance type is required")
	private MaintenanceType maintenanceType;
	
	private String description;
	
	
	// Constructor
	public UpdateMaintenanceRequest() {
	}


	// Getters and setters
	public LocalDate getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(LocalDate maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public Integer getDurationHours() {
		return durationHours;
	}

	public void setDurationHours(Integer durationHours) {
		this.durationHours = durationHours;
	}

	public MaintenanceType getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(MaintenanceType maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
