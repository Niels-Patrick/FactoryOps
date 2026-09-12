package com.factoryops.factoryops.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import com.factoryops.factoryops.dto.AlertResponse;
import com.factoryops.factoryops.repository.AlertRepository;
import com.factoryops.factoryops.entity.Alert;

class AlertServiceTest {
	@Mock
	private AlertRepository alertRepository;
	
	private AlertService alertService;
	
	
	@BeforeEach
	void setUp() {
		alertService = new AlertService(alertRepository);
	}
	
	
	@Test
	void shouldReturnAcknowledgedIsNowTrue() {
		
	}
}
