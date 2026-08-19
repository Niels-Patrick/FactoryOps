package com.factoryops.factoryops.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import com.factoryops.factoryops.dto.ThresholdViolationResponse;
import com.factoryops.factoryops.entity.Machine;
import com.factoryops.factoryops.entity.Measurement;

class MeasurementThresholdServiceTest {
	private final MeasurementThresholdService service = new MeasurementThresholdService();
	
	
	@Test
	void shouldReturnNoViolationsWhenMeasurementsAreWithinThresholds() {
		Machine machine = new Machine();
		
		machine.setMaxTemperature(new BigDecimal("80.00"));
		machine.setMaxVibration(new BigDecimal("5.00"));
		machine.setMaxPressure(new BigDecimal("180.00"));
		
		Measurement measurement = new Measurement();
		
		measurement.setMachine(machine);
		measurement.setTemperature(new BigDecimal("70.00"));
		measurement.setVibration(new BigDecimal("3.00"));
		measurement.setPressure(new BigDecimal("150.00"));
		
		ThresholdViolationResponse result = service
				.detectViolations(measurement);
		
		assertFalse(result.isTemperatureExceeded());
		assertFalse(result.isVibrationExceeded());
		assertFalse(result.isPressureExceeded());
		assertFalse(result.isAnyExceeded());
	}
	
	@Test
	void shouldDetectTemperatureViolation() {
		Machine machine = new Machine();
		
		machine.setMaxTemperature(new BigDecimal("80.00"));
		machine.setMaxVibration(new BigDecimal("5.00"));
		machine.setMaxPressure(new BigDecimal("180.00"));
		
		Measurement measurement = new Measurement();
		
		measurement.setMachine(machine);
		measurement.setTemperature(new BigDecimal("85.00"));
		measurement.setVibration(new BigDecimal("3.00"));
		measurement.setPressure(new BigDecimal("150.00"));
		
		ThresholdViolationResponse result = service
				.detectViolations(measurement);
		
		assertTrue(result.isTemperatureExceeded());
		assertFalse(result.isVibrationExceeded());
		assertFalse(result.isPressureExceeded());
		assertTrue(result.isAnyExceeded());
	}
	
	@Test
	void shouldDetectMultipleViolations() {
		Machine machine = new Machine();
		
		machine.setMaxTemperature(new BigDecimal("80.00"));
		machine.setMaxVibration(new BigDecimal("5.00"));
		machine.setMaxPressure(new BigDecimal("180.00"));
		
		Measurement measurement = new Measurement();
		
		measurement.setMachine(machine);
		measurement.setTemperature(new BigDecimal("95.00"));
		measurement.setVibration(new BigDecimal("8.00"));
		measurement.setPressure(new BigDecimal("200.00"));
		
		ThresholdViolationResponse result = service
				.detectViolations(measurement);
		
		assertTrue(result.isTemperatureExceeded());
		assertTrue(result.isVibrationExceeded());
		assertTrue(result.isPressureExceeded());
		assertTrue(result.isAnyExceeded());
	}
	
	@Test
	void shouldNotDetectViolationWhenMeasurementEqualsThreshold() {
		Machine machine = new Machine();
		
		machine.setMaxTemperature(new BigDecimal("80.00"));
		machine.setMaxVibration(new BigDecimal("5.00"));
		machine.setMaxPressure(new BigDecimal("180.00"));
		
		Measurement measurement = new Measurement();
		
		measurement.setMachine(machine);
		measurement.setTemperature(new BigDecimal("80.00"));
		measurement.setVibration(new BigDecimal("5.00"));
		measurement.setPressure(new BigDecimal("180.00"));
		
		ThresholdViolationResponse result = service
				.detectViolations(measurement);
		
		assertFalse(result.isTemperatureExceeded());
		assertFalse(result.isVibrationExceeded());
		assertFalse(result.isPressureExceeded());
		assertFalse(result.isAnyExceeded());
	}
}
