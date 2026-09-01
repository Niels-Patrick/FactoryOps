package com.factoryops.factoryops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.factoryops.factoryops.entity.Alert;

public interface AlertRepository
		extends JpaRepository<Alert, UUID> {
	Page<Alert> findByAcknowledgedFalse(Pageable pageable);
}
