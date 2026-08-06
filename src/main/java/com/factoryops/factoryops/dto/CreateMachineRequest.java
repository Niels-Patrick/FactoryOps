package com.factoryops.factoryops.dto;

import java.time.LocalDate;

import com.factoryops.factoryops.entity.enums.MachineStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateMachineRequest {
	@NotBlank
	@Size(max = 100)
	private String name;
	
	@NotBlank
	@Size(max = 100)
	private String serialNumber;
	
	@NotBlank
	@Size(max = 100)
	private String manufacturer;
	
	@NotBlank
	@Size(max = 100)
	private String productionLine;
	
	@NotNull
	private LocalDate installationDate;
	
	@NotNull
	private MachineStatus status;
	
	@NotNull
	@Min(0)
	private Integer operatingHours;
	
	
	public CreateMachineRequest() {
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
