package com.factoryops.factoryops.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "measurements")
public class Measurement {
	// Properties
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machine machine;
	
	@Column(name = "measurement_timestamp", nullable = false)
	private LocalDateTime measurementTimestamp;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal temperature;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal vibration;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal pressure;
	
	
	// Constructor
	public Measurement() {
	}


	// Getters and setters
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
