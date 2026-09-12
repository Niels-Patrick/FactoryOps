package com.factoryops.factoryops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.factoryops.factoryops.entity.Alert;
import com.factoryops.factoryops.entity.enums.AlertType;

public interface AlertRepository
		extends JpaRepository<Alert, UUID> {
	@Query("""
			SELECT a
			FROM Alert a
			WHERE a.acknowledged = false
				AND (:machineId IS NULL OR a.machine.id = :machineId)
				AND (:alertType IS NULL OR a.alertType = :alertType)
			""")
	Page<Alert> findActiveAlerts(
			@Param("machineId") UUID machineId,
			@Param("alertType") AlertType alertType,
			Pageable pageable
			);
}
