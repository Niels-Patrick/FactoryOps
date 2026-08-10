package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;

import com.factoryops.factoryops.dto.CreateMachineRequest;
import com.factoryops.factoryops.dto.MachineResponse;
import com.factoryops.factoryops.service.MachineService;

import java.util.UUID;

@RestController
@RequestMapping("/api/machines")
public class MachineController {
	private final MachineService machineService;
	
	public MachineController(MachineService machineService) {
		this.machineService = machineService;
	}
	
	
	@PostMapping
	public MachineResponse createMachine(
			@Valid @RequestBody CreateMachineRequest request
			) {
		return machineService.createMachine(request);
	}
	
	@GetMapping("/{id}")
	public MachineResponse getMachineById(@PathVariable UUID id) {
		return machineService.getMachineById(id);
	}
	
	@GetMapping
	public Page<MachineResponse> getMachines(Pageable pageable) {
		return machineService.getMachines(pageable);
	}
}
