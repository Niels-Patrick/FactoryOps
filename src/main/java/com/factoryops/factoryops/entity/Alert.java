package com.factoryops.factoryops.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;

import com.factoryops.factoryops.entity.enums.AlertType;

import jakarta.persistence.*;

@Entity
@Table(name = "alerts")
public class Alert {
	// Properties
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "machine_id", nullable = false)
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name = "measurement_id", nullable = false)
	private Measurement measurement;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AlertType alertType;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal measuredValue;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal thresholdValue;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
	private boolean acknowledged;
	
	
	// Constructor
	public Alert() {
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

	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public BigDecimal getMeasuredValue() {
		return measuredValue;
	}

	public void setMeasuredValue(BigDecimal measuredValue) {
		this.measuredValue = measuredValue;
	}

	public BigDecimal getThresholdValue() {
		return thresholdValue;
	}

	public void setThresholdValue(BigDecimal thresholdValue) {
		this.thresholdValue = thresholdValue;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(Boolean acknowledged) {
		this.acknowledged = acknowledged;
	}
}
