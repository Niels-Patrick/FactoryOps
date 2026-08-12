package com.factoryops.factoryops.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.factoryops.factoryops.entity.enums.MachineStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "machines")
public class Machine {
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String serialNumber;
	
	@Column(nullable = false)
	private String manufacturer;
	
	@Column(nullable = false)
	private String productionLine;
	
	@Column(nullable = false)
	private LocalDate installationDate;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MachineStatus status;
	
	@Min(0)
	@Column(nullable = false)
	private Integer operatingHours;
	
	
	// Constructor
	public Machine() {
	}

	
	// Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getProductionLine() {
		return productionLine;
	}

	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}

	public LocalDate getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(LocalDate installationDate) {
		this.installationDate = installationDate;
	}

	public MachineStatus getStatus() {
		return status;
	}

	public void setStatus(MachineStatus status) {
		this.status = status;
	}

	public Integer getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(Integer operatingHours) {
		this.operatingHours = operatingHours;
	}
}
