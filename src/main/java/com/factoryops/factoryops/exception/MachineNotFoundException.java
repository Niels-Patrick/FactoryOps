package com.factoryops.factoryops.exception;

import java.util.UUID;

public class MachineNotFoundException extends RuntimeException {
	public MachineNotFoundException(UUID id) {
		super("Machine with ID " + id + " was not found");
	}
}
