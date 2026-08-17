package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;

import com.factoryops.factoryops.dto.ThresholdViolationResponse;
import com.factoryops.factoryops.entity.Measurement;
import com.factoryops.factoryops.entity.Machine;

@Service
public class MeasurementThresholdService {
	// Constructor
	public MeasurementThresholdService() {
	}
	
	
	// Public methods
	public ThresholdViolationResponse detectViolations(
			Measurement measurement
			) {
		Machine machine = measurement.getMachine();
		
		boolean temperatureExceeded = measurement.getTemperature()
				.compareTo(machine.getMaxTemperature()) > 0;
				
		boolean vibrationExceeded = measurement.getVibration()
				.compareTo(machine.getMaxVibration()) > 0;
		
		boolean pressureExceeded = measurement.getPressure()
				.compareTo(machine.getMaxPressure()) > 0;
				
		boolean anyExceeded = temperatureExceeded
				|| vibrationExceeded
				|| pressureExceeded;
				
		ThresholdViolationResponse response = new ThresholdViolationResponse();
		
		response.setTemperatureExceeded(temperatureExceeded);
		response.setVibrationExceeded(vibrationExceeded);
		response.setPressureExceeded(pressureExceeded);
		response.setAnyExceeded(anyExceeded);
		
		return response;
	}
}
