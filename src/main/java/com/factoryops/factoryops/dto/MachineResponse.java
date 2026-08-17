package com.factoryops.factoryops.dto;

import java.util.UUID;
import java.time.LocalDate;
import java.math.BigDecimal;

import com.factoryops.factoryops.entity.enums.MachineStatus;

public class MachineResponse {
	// Properties
	private UUID id;
	private String name;
	private String serialNumber;
	private String manufacturer;
	private String productionLine;
	private LocalDate installationDate;
	private MachineStatus status;
	private Integer operatingHours;
	private BigDecimal maxTemperature;
	private BigDecimal maxVibration;
	private BigDecimal maxPressure;
	
	
	// Constructor
	public MachineResponse() {
	}


	// Getters and setters
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

	public BigDecimal getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(BigDecimal maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public BigDecimal getMaxVibration() {
		return maxVibration;
	}

	public void setMaxVibration(BigDecimal maxVibration) {
		this.maxVibration = maxVibration;
	}

	public BigDecimal getMaxPressure() {
		return maxPressure;
	}

	public void setMaxPressure(BigDecimal maxPressure) {
		this.maxPressure = maxPressure;
	}
}
