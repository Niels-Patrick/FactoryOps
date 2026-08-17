package com.factoryops.factoryops.dto;

public class ThresholdViolationResponse {
	// Properties
	private boolean temperatureExceeded;
	private boolean vibrationExceeded;
	private boolean pressureExceeded;
	private boolean anyExceeded;
	
	
	// Constructor
	public ThresholdViolationResponse() {
	}


	// Getters and setters
	public boolean isTemperatureExceeded() {
		return temperatureExceeded;
	}

	public void setTemperatureExceeded(boolean temperatureExceeded) {
		this.temperatureExceeded = temperatureExceeded;
	}

	public boolean isVibrationExceeded() {
		return vibrationExceeded;
	}

	public void setVibrationExceeded(boolean vibrationExceeded) {
		this.vibrationExceeded = vibrationExceeded;
	}

	public boolean isPressureExceeded() {
		return pressureExceeded;
	}

	public void setPressureExceeded(boolean pressureExceeded) {
		this.pressureExceeded = pressureExceeded;
	}

	public boolean isAnyExceeded() {
		return anyExceeded;
	}

	public void setAnyExceeded(boolean anyExceeded) {
		this.anyExceeded = anyExceeded;
	}
}
