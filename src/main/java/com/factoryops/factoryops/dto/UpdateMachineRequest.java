package com.factoryops.factoryops.dto;

import java.time.LocalDate;
import java.math.BigDecimal;

import com.factoryops.factoryops.entity.enums.MachineStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.DecimalMin;

public class UpdateMachineRequest {
	//Properties
	@NotBlank(message = "Machine name is required")
	@Size(
			max = 100,
			message = "Machine name cannot exceed 100 characters"
			)
	private String name;
	
	@NotBlank(message = "Machine serial number is required")
	@Size(
			max = 100,
			message = "Machine serial number cannot exceed 100 characters"
			)
	private String serialNumber;
	
	@NotBlank(message = "Machine manufacturer  is required")
	@Size(
			max = 100,
			message = "Machine manufacturer cannot exceed 100 characters"
			)
	private String manufacturer;
	
	@NotBlank(message = "Machine production line is required")
	@Size(
			max = 100,
			message = "Machine production line cannot exceed 100 characters"
			)
	private String productionLine;
	
	@NotNull(message = "Machine installation date is required")
	private LocalDate installationDate;
	
	@NotNull(message = "Machine status is required")
	private MachineStatus status;
	
	@NotNull(message = "Machine operating hours is required")
	@Min(
			value = 0,
			message = "Machine operating hours cannot be negative"
			)
	private Integer operatingHours;
	
	@NotNull(message = "Machine maximum temperature is required")
	@DecimalMin(
			value = "0.0",
			message = "Machine maximum temperature cannot be negative"
			)
	@Digits(integer = 8, fraction = 2)
	private BigDecimal maxTemperature;
	
	@NotNull(message = "Machine maximum vibration is required")
	@DecimalMin(
			value = "0.0",
			message = "Machine maximum vibration cannot be negative"
			)
	@Digits(integer = 8, fraction = 2)
	private BigDecimal maxVibration;
	
	@NotNull(message = "Machine maximum pressure is required")
	@DecimalMin(
			value = "0.0",
			message = "Machine maximum pressure cannot be negative"
			)
	@Digits(integer = 8, fraction = 2)
	private BigDecimal maxPressure;
	
	
	// Constructor
	public UpdateMachineRequest() {
	}


	// Getters and setters
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
