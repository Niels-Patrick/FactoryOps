package com.factoryops.factoryops.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factoryops.factoryops.entity.Alert;

public interface AlertRepository
		extends JpaRepository<Alert, UUID> {
}
