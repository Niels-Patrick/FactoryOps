package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import com.factoryops.factoryops.dto.CreateMachineRequest;
import com.factoryops.factoryops.dto.UpdateMachineRequest;
import com.factoryops.factoryops.dto.MachineResponse;
import com.factoryops.factoryops.service.MachineService;

import java.util.UUID;
import java.net.URI;

@RestController
@RequestMapping("/api/machines")
public class MachineController {
	private final MachineService machineService;
	
	public MachineController(MachineService machineService) {
		this.machineService = machineService;
	}
	
	
	@PostMapping
	public ResponseEntity<MachineResponse> createMachine(
			@Valid @RequestBody CreateMachineRequest request
			) {
		MachineResponse response = machineService.createMachine(request);
		
		URI location = URI.create("/api/machines/" + response.getId());
		
		return ResponseEntity
				.created(location)
				.body(response);
	}
	
	@GetMapping("/{id}")
	public MachineResponse getMachineById(@PathVariable UUID id) {
		return machineService.getMachineById(id);
	}
	
	@GetMapping
	public Page<MachineResponse> getMachines(Pageable pageable) {
		return machineService.getMachines(pageable);
	}
	
	@PutMapping("/{id}")
	public MachineResponse updateMachine(
			@PathVariable UUID id,
			@Valid @RequestBody UpdateMachineRequest request
			) {
		return machineService.updateMachine(id, request);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMachine(@PathVariable UUID id) {
		machineService.deleteMachine(id);
	}
}
