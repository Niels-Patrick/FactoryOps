package com.factoryops.factoryops.service;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.factoryops.factoryops.repository.AlertRepository;
import com.factoryops.factoryops.entity.Alert;
import com.factoryops.factoryops.entity.Measurement;
import com.factoryops.factoryops.entity.Machine;
import com.factoryops.factoryops.entity.enums.AlertType;
import com.factoryops.factoryops.dto.AlertResponse;
import com.factoryops.factoryops.dto.ThresholdViolationResponse;

@Service
public class AlertService {
	// Properties
	private final AlertRepository alertRepository;

	
	// Constructor
	public AlertService(AlertRepository alertRepository) {
		this.alertRepository = alertRepository;
	}


	// Public methods
	public List<Alert> createAlerts(
			Measurement measurement,
			ThresholdViolationResponse violations
			) {
		List<Alert> alerts = new ArrayList();
		
		Machine machine = measurement.getMachine();
		
		if (violations.isTemperatureExceeded()) {
			alerts.add(createAlert(
					machine,
					measurement,
					AlertType.TEMPERATURE,
					measurement.getTemperature(),
					machine.getMaxTemperature()
					));
		}
		
		if (violations.isVibrationExceeded()) {
			alerts.add(createAlert(
					machine,
					measurement,
					AlertType.VIBRATION,
					measurement.getVibration(),
					machine.getMaxVibration()
					));
		}
		
		if (violations.isPressureExceeded()) {
			alerts.add(createAlert(
					machine,
					measurement,
					AlertType.PRESSURE,
					measurement.getPressure(),
					machine.getMaxPressure()
					));
		}
		
		return alertRepository.saveAll(alerts);
	}
	
	public AlertResponse mapToResponse(Alert alert) {
		AlertResponse response = new AlertResponse();
		
		response.setId(alert.getId());
		response.setMachineId(alert.getMachine().getId());
		response.setMeasurementId(alert.getMeasurement().getId());
		response.setAlertType(alert.getAlertType());
		response.setMeasuredValue(alert.getMeasuredValue());
		response.setThresholdValue(alert.getThresholdValue());
		response.setCreatedAt(alert.getCreatedAt());
		response.setAcknowledged(alert.getAcknowledged());
		
		return response;
	}


	// Private methods
	private Alert createAlert(
			Machine machine,
			Measurement measurement,
			AlertType alertType,
			BigDecimal measuredValue,
			BigDecimal thresholdValue
			) {
		Alert alert = new Alert();
		
		alert.setMachine(machine);
		alert.setMeasurement(measurement);
		alert.setAlertType(alertType);
		alert.setMeasuredValue(measuredValue);
		alert.setThresholdValue(thresholdValue);
		alert.setCreatedAt(LocalDateTime.now());
		alert.setAcknowledged(false);
		
		return alert;
	}
}
