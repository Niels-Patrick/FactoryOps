package com.factoryops.factoryops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, UUID> {
	Page<Measurement> findByMachineId(
			UUID machineId,
			Pageable pageable
			);
}
