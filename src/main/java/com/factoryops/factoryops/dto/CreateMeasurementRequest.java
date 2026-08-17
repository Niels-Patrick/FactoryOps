package com.factoryops.factoryops.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.DecimalMin;

public class CreateMeasurementRequest {
	// Properties
	@NotNull
	private LocalDateTime measurementTimestamp;
	
	@NotNull
	@Digits(integer = 8, fraction = 2)
	private BigDecimal temperature;
	
	@NotNull
	@Digits(integer = 8, fraction = 2)
	@DecimalMin(
			value = "0.0",
			message = "Measurement vibration cannot be negative"
			)
	private BigDecimal vibration;
	
	@NotNull
	@Digits(integer = 8, fraction = 2)
	@DecimalMin(
			value = "0.0",
			message = "Measurement pressure cannot be negative"
			)
	private BigDecimal pressure;
	
	
	// Constructor
	public CreateMeasurementRequest() {
	}


	// Getters and setters
	public LocalDateTime getMeasurementTimestamp() {
		return measurementTimestamp;
	}

	public void setMeasurementTimestamp(LocalDateTime measurementTimestamp) {
		this.measurementTimestamp = measurementTimestamp;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getVibration() {
		return vibration;
	}

	public void setVibration(BigDecimal vibration) {
		this.vibration = vibration;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}
}
