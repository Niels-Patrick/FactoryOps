package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.repository.MachineRepository;
import com.factoryops.factoryops.repository.MeasurementRepository;
import com.factoryops.factoryops.dto.CreateMeasurementRequest;
import com.factoryops.factoryops.dto.MeasurementResponse;
import com.factoryops.factoryops.entity.Machine;
import com.factoryops.factoryops.entity.Measurement;
import com.factoryops.factoryops.exception.MachineNotFoundException;

import java.util.UUID;

@Service
public class MeasurementService {
	// Properties
	private final MeasurementRepository measurementRepository;
	private final MachineRepository machineRepository;
	

	// Constructor
	public MeasurementService(
			MeasurementRepository measurementRepository,
			MachineRepository machineRepository
			) {
		this.measurementRepository = measurementRepository;
		this.machineRepository = machineRepository;
	}
	
	
	// Public methods
	public MeasurementResponse createMeasurement(
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

		return mapToResponse(savedMeasurement);
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
