package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;

import com.factoryops.factoryops.repository.MachineRepository;
import com.factoryops.factoryops.dto.CreateMachineRequest;
import com.factoryops.factoryops.dto.MachineResponse;
import com.factoryops.factoryops.entity.Machine;

@Service
public class MachineService {
	private final MachineRepository machineRepository;
	
	public MachineService(MachineRepository machineRepository) {
		this.machineRepository = machineRepository;
	}
	
	
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
		
		MachineResponse response = new MachineResponse();
		
		response.setId(savedMachine.getId());
		response.setName(savedMachine.getName());
		response.setSerialNumber(savedMachine.getSerialNumber());
		response.setManufacturer(savedMachine.getManufacturer());
		response.setProductionLine(savedMachine.getProductionLine());
		response.setInstallationDate(savedMachine.getInstallationDate());
		response.setStatus(savedMachine.getStatus());
		response.setOperatingHours(savedMachine.getOperatingHours());
		
		return response;
	}
}
