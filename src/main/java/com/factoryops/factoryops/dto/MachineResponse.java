package com.factoryops.factoryops.dto;

import java.util.UUID;
import java.time.LocalDate;

import com.factoryops.factoryops.entity.enums.MachineStatus;

public class MachineResponse {
	private UUID id;
	private String name;
	private String serialNumber;
	private String manufacturer;
	private String productionLine;
	private LocalDate installationDate;
	private MachineStatus status;
	private Integer operatingHours;
	
	
	public MachineResponse() {
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getProductionLine() {
		return productionLine;
	}


	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
	}


	public LocalDate getInstallationDate() {
		return installationDate;
	}


	public void setInstallationDate(LocalDate installationDate) {
		this.installationDate = installationDate;
	}


	public MachineStatus getStatus() {
		return status;
	}


	public void setStatus(MachineStatus status) {
		this.status = status;
	}


	public Integer getOperatingHours() {
		return operatingHours;
	}


	public void setOperatingHours(Integer operatingHours) {
		this.operatingHours = operatingHours;
	}
}
