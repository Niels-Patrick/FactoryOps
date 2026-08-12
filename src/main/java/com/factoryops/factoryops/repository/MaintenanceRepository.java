package com.factoryops.factoryops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factoryops.factoryops.entity.Maintenance;

public interface MaintenanceRepository
		extends JpaRepository<Maintenance, UUID> {
}
