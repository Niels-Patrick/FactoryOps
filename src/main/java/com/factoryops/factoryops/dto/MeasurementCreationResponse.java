package com.factoryops.factoryops.dto;

import java.util.List;

public class MeasurementCreationResponse {
	// Properties
	private MeasurementResponse measurement;
	private ThresholdViolationResponse violations;
	private List<AlertResponse> alerts;


	// Constructor
	public MeasurementCreationResponse() {
	}


	// Getters and setters
	public MeasurementResponse getMeasurement() {
		return measurement;
	}

	public void setMeasurement(MeasurementResponse measurement) {
		this.measurement = measurement;
	}

	public ThresholdViolationResponse getViolations() {
		return violations;
	}

	public void setViolations(ThresholdViolationResponse violations) {
		this.violations = violations;
	}

	public List<AlertResponse> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<AlertResponse> alerts) {
		this.alerts = alerts;
	}
}
