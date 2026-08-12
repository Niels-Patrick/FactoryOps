package com.factoryops.factoryops.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.factoryops.factoryops.entity.enums.MaintenanceType;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "maintenances")
public class Maintenance {
	// Properties
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machine machine;
	
	@Column(nullable = false)
	private LocalDate maintenanceDate;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private String technician;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MaintenanceType maintenanceType;
	
	@Min(0)
	@Column(nullable = false)
	private Integer durationHours;
	
	
	// Constructor
	public Maintenance() {
	}


	// Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public LocalDate getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(LocalDate maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public MaintenanceType getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(MaintenanceType maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public Integer getDurationHours() {
		return durationHours;
	}

	public void setDurationHours(Integer durationHours) {
		this.durationHours = durationHours;
	}
}
