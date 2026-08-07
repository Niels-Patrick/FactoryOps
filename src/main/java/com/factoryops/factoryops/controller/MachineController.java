package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.factoryops.factoryops.dto.CreateMachineRequest;
import com.factoryops.factoryops.dto.MachineResponse;
import com.factoryops.factoryops.service.MachineService;

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
}
