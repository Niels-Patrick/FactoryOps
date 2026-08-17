package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.repository.MachineRepository;
import com.factoryops.factoryops.repository.MeasurementRepository;
import com.factoryops.factoryops.dto.CreateMeasurementRequest;
import com.factoryops.factoryops.dto.MeasurementResponse;
import com.factoryops.factoryops.dto.MeasurementCreationResponse;
import com.factoryops.factoryops.dto.ThresholdViolationResponse;
import com.factoryops.factoryops.entity.Machine;
import com.factoryops.factoryops.entity.Measurement;
import com.factoryops.factoryops.exception.MachineNotFoundException;
import com.factoryops.factoryops.service.MeasurementThresholdService;

import java.util.UUID;

@Service
public class MeasurementService {
	// Properties
	private final MeasurementRepository measurementRepository;
	private final MachineRepository machineRepository;
	private final MeasurementThresholdService measurementThresholdService;
	

	// Constructor
	public MeasurementService(
			MeasurementRepository measurementRepository,
			MachineRepository machineRepository,
			MeasurementThresholdService measurementThresholdService
			) {
		this.measurementRepository = measurementRepository;
		this.machineRepository = machineRepository;
		this.measurementThresholdService = measurementThresholdService;
	}
	
	
	// Public methods
	public MeasurementCreationResponse createMeasurement(
			UUID machineId,
			CreateMeasurementRequest request
			) {
		Machine machine = machineRepository.findById(machineId)
				.orElseThrow(() -> new MachineNotFoundException(machineId));

		Measurement measurement = new Measurement();

		measurement.setMachine(machine);
		measurement.setMeasurementTimestamp(request.getMeasurementTimestamp());
		measurement.setTemperature(request.getTemperature());
		measurement.setVibration(request.getVibration());
		measurement.setPressure(request.getPressure());

		Measurement savedMeasurement = measurementRepository.save(measurement);
		
		MeasurementResponse measurementResponse = mapToResponse(savedMeasurement);
		
		ThresholdViolationResponse violations = measurementThresholdService
				.detectViolations(savedMeasurement);
		
		MeasurementCreationResponse response = new MeasurementCreationResponse();
		
		response.setMeasurement(measurementResponse);
		response.setViolations(violations);

		return response;
	}
	
	public Page<MeasurementResponse> getMeasurementsByMachine(
			UUID machineId,
			Pageable pageable
			) {
		machineRepository.findById(machineId)
			.orElseThrow(() -> new MachineNotFoundException(machineId));
		
		Page<Measurement> measurements = measurementRepository
				.findByMachineId(machineId, pageable);
		
		return measurements.map(this::mapToResponse);
	}
	
	
	// Private methods
	private MeasurementResponse mapToResponse(Measurement measurement) {
		MeasurementResponse response = new MeasurementResponse();
		
		response.setId(measurement.getId());
		response.setMachineId(measurement.getMachine().getId());
		response.setMeasurementTimestamp(measurement.getMeasurementTimestamp());
		response.setTemperature(measurement.getTemperature());
		response.setVibration(measurement.getVibration());
		response.setPressure(measurement.getPressure());
		
		return response;
	}
}
