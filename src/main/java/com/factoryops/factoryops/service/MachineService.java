package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.repository.MachineRepository;
import com.factoryops.factoryops.dto.CreateMachineRequest;
import com.factoryops.factoryops.dto.UpdateMachineRequest;
import com.factoryops.factoryops.dto.MachineResponse;
import com.factoryops.factoryops.entity.Machine;
import com.factoryops.factoryops.exception.MachineNotFoundException;

import java.util.UUID;

@Service
public class MachineService {
	// Properties
	private final MachineRepository machineRepository;
	
	
	// Constructor
	public MachineService(MachineRepository machineRepository) {
		this.machineRepository = machineRepository;
	}
	
	
	// Public methods
	public MachineResponse createMachine(CreateMachineRequest request) {
		Machine machine = new Machine();
		
		machine.setName(request.getName());
		machine.setSerialNumber(request.getSerialNumber());
		machine.setManufacturer(request.getManufacturer());
		machine.setProductionLine(request.getProductionLine());
		machine.setInstallationDate(request.getInstallationDate());
		machine.setStatus(request.getStatus());
		machine.setOperatingHours(request.getOperatingHours());
		
		Machine savedMachine = machineRepository.save(machine);
		
		return mapToResponse(savedMachine);
	}
	
	public MachineResponse getMachineById(UUID id) {
		Machine machine = machineRepository.findById(id)
				.orElseThrow(() -> new MachineNotFoundException(id));
		
		return mapToResponse(machine);
	}
	
	public Page<MachineResponse> getMachines(Pageable pageable) {
		Page<Machine> machines = machineRepository.findAll(pageable);
		
		return machines.map(this::mapToResponse);
	}
	
	public MachineResponse updateMachine(
			UUID id,
			UpdateMachineRequest request
			) {
		Machine machine = machineRepository.findById(id)
				.orElseThrow(() -> new MachineNotFoundException(id));
		
		machine.setName(request.getName());
		machine.setSerialNumber(request.getSerialNumber());
		machine.setManufacturer(request.getManufacturer());
		machine.setProductionLine(request.getProductionLine());
		machine.setInstallationDate(request.getInstallationDate());
		machine.setStatus(request.getStatus());
		machine.setOperatingHours(request.getOperatingHours());
		
		Machine updatedMachine = machineRepository.save(machine);
		
		return mapToResponse(updatedMachine);
	}
	
	public void deleteMachine(UUID id) {
		Machine machine = machineRepository.findById(id)
				.orElseThrow(() -> new MachineNotFoundException(id));
		
		machineRepository.delete(machine);
	}
	
	
	// Private methods
	private MachineResponse mapToResponse(Machine machine) {
		MachineResponse response = new MachineResponse();
		
		response.setId(machine.getId());
		response.setName(machine.getName());
		response.setSerialNumber(machine.getSerialNumber());
		response.setManufacturer(machine.getManufacturer());
		response.setProductionLine(machine.getProductionLine());
		response.setInstallationDate(machine.getInstallationDate());
		response.setStatus(machine.getStatus());
		response.setOperatingHours(machine.getOperatingHours());
		
		return response;
	}
}
