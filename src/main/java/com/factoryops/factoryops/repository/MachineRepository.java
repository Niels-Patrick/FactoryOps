package com.factoryops.factoryops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factoryops.factoryops.entity.Machine;

import java.util.UUID;

public interface MachineRepository
		extends JpaRepository<Machine, UUID> {
}