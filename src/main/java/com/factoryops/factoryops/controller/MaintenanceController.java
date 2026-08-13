package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import jakarta.validation.Valid;

import com.factoryops.factoryops.dto.CreateMaintenanceRequest;
import com.factoryops.factoryops.dto.MaintenanceResponse;
import com.factoryops.factoryops.service.MaintenanceService;

import java.util.UUID;
import java.net.URI;

@RestController
@RequestMapping("/api/machines/{machineId}/maintenances")
public class MaintenanceController {
	// Properties
	private final MaintenanceService maintenanceService;
	
	// Constructor
	public MaintenanceController(MaintenanceService maintenanceService) {
		this.maintenanceService = maintenanceService;
	}
	
	
	// Routes
	@PostMapping
	public ResponseEntity<MaintenanceResponse> createMaintenance(
			@PathVariable UUID machineId,
			@Valid @RequestBody CreateMaintenanceRequest request
			) {
		MaintenanceResponse response = maintenanceService
				.createMaintenance(machineId, request);
		
		URI location = URI.create("/api/maintenances/" + response.getId());
		
		return ResponseEntity
				.created(location)
				.body(response);
	}
	
	@GetMapping
	public Page<MaintenanceResponse> getMaintenancesByMachine(
			@PathVariable UUID machineId,
			@PageableDefault(
					size = 10,
					sort = "maintenanceDate",
					direction = Sort.Direction.DESC
					) Pageable pageable
			) {
		return maintenanceService.getMaintenancesByMachine(
				machineId,
				pageable
				);
	}
}
