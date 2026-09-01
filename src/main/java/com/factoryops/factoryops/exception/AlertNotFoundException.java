package com.factoryops.factoryops.exception;

import java.util.UUID;

public class AlertNotFoundException extends RuntimeException {
	public AlertNotFoundException(UUID id) {
		super("Alert with ID " + id + " was not found");
	}
}
