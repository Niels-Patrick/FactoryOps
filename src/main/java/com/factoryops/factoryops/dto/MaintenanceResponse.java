package com.factoryops.factoryops.dto;

import java.util.UUID;
import java.time.LocalDate;

import com.factoryops.factoryops.entity.enums.MaintenanceType;

public class MaintenanceResponse {
	// Properties
	private UUID id;
	private UUID machineId;
	private LocalDate maintenanceDate;
	private String technician;
	private Integer durationHours;
	private MaintenanceType maintenanceType;
	private String description;
	
	
	// Constructor
	public MaintenanceResponse() {
	}


	// Getters and setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getMachineId() {
		return machineId;
	}

	public void setMachineId(UUID machineId) {
		this.machineId = machineId;
	}

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
