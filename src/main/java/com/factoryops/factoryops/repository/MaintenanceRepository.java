package com.factoryops.factoryops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.entity.Maintenance;

public interface MaintenanceRepository
		extends JpaRepository<Maintenance, UUID> {
	Page<Maintenance> findByMachineId(
			UUID machineId,
			Pageable pageable
			);
}
