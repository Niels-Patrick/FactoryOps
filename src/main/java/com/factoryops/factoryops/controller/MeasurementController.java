package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import jakarta.validation.Valid;

import com.factoryops.factoryops.dto.CreateMeasurementRequest;
import com.factoryops.factoryops.dto.MeasurementResponse;
import com.factoryops.factoryops.dto.MeasurementCreationResponse;
import com.factoryops.factoryops.service.MeasurementService;

import java.util.UUID;
import java.net.URI;

@RestController
@RequestMapping("/api/machines/{machineId}/measurements")
public class MeasurementController {
	// Properties
	private final MeasurementService measurementService;
	
	
	// Constructor
	public MeasurementController(MeasurementService measurementService) {
		this.measurementService = measurementService;
	}
	
	
	// Routes
	@PostMapping
	public ResponseEntity<MeasurementCreationResponse> createMeasurement(
			@PathVariable UUID machineId,
			@Valid @RequestBody CreateMeasurementRequest request
			) {
		MeasurementCreationResponse response = measurementService
				.createMeasurement(machineId, request);
		
		URI location = URI.create(
				"/api/measurements/" +
				response.getMeasurement().getId()
				);
		
		return ResponseEntity
				.created(location)
				.body(response);
	}
	
	@GetMapping
	public Page<MeasurementResponse> getMeasurementsByMachine(
			@PathVariable UUID machineId,
			@PageableDefault(
					size = 20,
					sort = "measurementTimestamp",
					direction = Sort.Direction.ASC
					) Pageable pageable
			) {
		return measurementService.getMeasurementsByMachine(
				machineId,
				pageable
				);
	}
}
