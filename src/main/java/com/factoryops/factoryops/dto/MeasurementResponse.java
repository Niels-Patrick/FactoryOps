package com.factoryops.factoryops.dto;

import java.util.UUID;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public class MeasurementResponse {
	// Properties
	private UUID id;
	private UUID machineId;
	private LocalDateTime measurementTimestamp;
	private BigDecimal temperature;
	private BigDecimal vibration;
	private BigDecimal pressure;
	
	
	// Constructor
	public MeasurementResponse() {
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
