package com.factoryops.factoryops.exception;

import java.util.UUID;

public class MaintenanceNotFoundException extends RuntimeException {
	public MaintenanceNotFoundException(UUID id) {
		super("Maintenance not found with ID: " + id);
	}
}
