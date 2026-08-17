package com.factoryops.factoryops.dto;

public class MeasurementCreationResponse {
	// Properties
	private MeasurementResponse measurement;
	private ThresholdViolationResponse violations;


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
}
