package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.factoryops.factoryops.dto.MaintenanceResponse;
import com.factoryops.factoryops.service.MaintenanceService;
import com.factoryops.factoryops.dto.UpdateMaintenanceRequest;

import jakarta.validation.Valid;

import java.util.UUID;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceResourceController {
	// Properties
	private final MaintenanceService maintenanceService;
	
	
	// Constructor
	public MaintenanceResourceController(
			MaintenanceService maintenanceService
			) {
		this.maintenanceService = maintenanceService;
	}
	
	
	// Public methods
	@GetMapping("/{id}")
	public MaintenanceResponse getMaintenance(@PathVariable UUID id) {
		return maintenanceService.getMaintenance(id);
	}
	
	@PutMapping("/{id}")
	public MaintenanceResponse updateMaintenance(
			@PathVariable UUID id,
			@Valid @RequestBody UpdateMaintenanceRequest request
			) {
		return maintenanceService.updateMaintenance(id, request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMaintenance(@PathVariable UUID id) {
		maintenanceService.deleteMaintenance(id);
	}
}
