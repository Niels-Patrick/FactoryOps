package com.factoryops.factoryops.dto;

import java.util.UUID;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import com.factoryops.factoryops.entity.enums.AlertType;

public class AlertResponse {
	// Properties
	private UUID id;
	private UUID machineId;
	private UUID measurementId;
	private AlertType alertType;
	private BigDecimal measuredValue;
	private BigDecimal thresholdValue;
	private LocalDateTime createdAt;
	private boolean acknowledged;
	
	
	// Constructor
	public AlertResponse() {
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

	public UUID getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(UUID measurementId) {
		this.measurementId = measurementId;
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

	public boolean isAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(boolean acknowledged) {
		this.acknowledged = acknowledged;
	}
}
