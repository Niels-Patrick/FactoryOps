package com.factoryops.factoryops.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.factoryops.factoryops.service.AlertService;
import com.factoryops.factoryops.dto.AlertResponse;

import java.util.UUID;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {
	// Properties
	private final AlertService alertService;
	
	
	// Constructor
	public AlertController(AlertService alertService) {
		this.alertService = alertService;
	}
	
	
	// Public methods
	@GetMapping
	public Page<AlertResponse> getActiveAlerts(
			@PageableDefault(
					size = 20,
					sort = "createdAt",
					direction = Sort.Direction.DESC
					) Pageable pageable
			) {
		return alertService.getActiveAlerts(pageable);
	}
	
	@PatchMapping("/{alertId}/acknowledge")
	public AlertResponse acknowledgeAlert(@PathVariable UUID alertId) {
		return alertService.acknowledgeAlert(alertId);
	}
}
