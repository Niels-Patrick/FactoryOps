package com.factoryops.factoryops.service;

import org.springframework.stereotype.Service;

import com.factoryops.factoryops.repository.MachineRepository;

@Service
public class MachineService {
	private final MachineRepository machineRepository;
	
	public MachineService(MachineRepository machineRepository) {
		this.machineRepository = machineRepository;
	}
}
