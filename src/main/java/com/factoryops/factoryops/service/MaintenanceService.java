package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.repository.MachineRepository;
import com.factoryops.factoryops.repository.MaintenanceRepository;
import com.factoryops.factoryops.dto.CreateMaintenanceRequest;
import com.factoryops.factoryops.dto.UpdateMaintenanceRequest;
import com.factoryops.factoryops.dto.MaintenanceResponse;
import com.factoryops.factoryops.entity.Machine;
import com.factoryops.factoryops.entity.Maintenance;
import com.factoryops.factoryops.exception.MachineNotFoundException;
import com.factoryops.factoryops.exception.MaintenanceNotFoundException;

import java.util.UUID;

@Service
public class MaintenanceService {
	// Properties
	private final MachineRepository machineRepository;
	private final MaintenanceRepository maintenanceRepository;
	
	
	// Constructor
	public MaintenanceService(
			MachineRepository machineRepository,
			MaintenanceRepository maintenanceRepository
			) {
		this.machineRepository = machineRepository;
		this.maintenanceRepository = maintenanceRepository;
	}
	
	
	// Public methods
	public MaintenanceResponse createMaintenance(
			UUID machineId,
			CreateMaintenanceRequest request
			) {
		Machine machine = machineRepository.findById(machineId)
				.orElseThrow(() -> new MachineNotFoundException(machineId));
		
		Maintenance maintenance = new Maintenance();
		
		maintenance.setMachine(machine);
		maintenance.setMaintenanceDate(request.getMaintenanceDate());
		maintenance.setTechnician(request.getTechnician());
		maintenance.setDurationHours(request.getDurationHours());
		maintenance.setMaintenanceType(request.getMaintenanceType());
		maintenance.setDescription(request.getDescription());
		
		Maintenance savedMaintenance = maintenanceRepository.save(maintenance);
		
		return mapToResponse(savedMaintenance);
	}
	
	public Page<MaintenanceResponse> getMaintenancesByMachine(
			UUID machineId,
			Pageable pageable
			) {
		machineRepository.findById(machineId)
			.orElseThrow(() -> new MachineNotFoundException(machineId));
		
		Page<Maintenance> maintenances = maintenanceRepository
				.findByMachineId(machineId, pageable);
		
		return maintenances.map(this::mapToResponse);
	}
	
	public MaintenanceResponse getMaintenance(UUID id) {
		Maintenance maintenance = maintenanceRepository.findById(id)
				.orElseThrow(() -> new MaintenanceNotFoundException(id));
		
		return mapToResponse(maintenance);
	}
	
	public MaintenanceResponse updateMaintenance(
			UUID id,
			UpdateMaintenanceRequest request
			) {
		Maintenance maintenance = maintenanceRepository.findById(id)
				.orElseThrow(() -> new MaintenanceNotFoundException(id));
		
		maintenance.setMaintenanceDate(request.getMaintenanceDate());
		maintenance.setTechnician(request.getTechnician());
		maintenance.setDurationHours(request.getDurationHours());
		maintenance.setMaintenanceType(request.getMaintenanceType());
		maintenance.setDescription(request.getDescription());
		
		Maintenance updatedMaintenance = maintenanceRepository.save(maintenance);
		
		return mapToResponse(updatedMaintenance);
	}
	
	public void deleteMaintenance(UUID id) {
		Maintenance maintenance = maintenanceRepository.findById(id)
				.orElseThrow(() -> new MaintenanceNotFoundException(id));
		
		maintenanceRepository.delete(maintenance);
	}
	
	
	// Private methods
	private MaintenanceResponse mapToResponse(Maintenance maintenance) {
		MaintenanceResponse response = new MaintenanceResponse();
		
		response.setId(maintenance.getId());
		response.setMachineId(maintenance.getMachine().getId());
		response.setMaintenanceDate(maintenance.getMaintenanceDate());
		response.setTechnician(maintenance.getTechnician());
		response.setDurationHours(maintenance.getDurationHours());
		response.setMaintenanceType(maintenance.getMaintenanceType());
		response.setDescription(maintenance.getDescription());
		
		return response;
	}
}
