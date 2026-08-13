package com.factoryops.factoryops.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.factoryops.factoryops.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(
			MethodArgumentNotValidException exception
			) {
		Map<String, String> errors = new HashMap();
		
		exception.getBindingResult()
				.getFieldErrors()
				.forEach(error ->
					errors.put(
							error.getField(),
							error.getDefaultMessage()
							)
						);
		
		ErrorResponse response = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Validation failed",
				LocalDateTime.now(),
				errors
				);
		
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}
	
	@ExceptionHandler(MachineNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleMachineNotFoundException(
			MachineNotFoundException exception
			) {
		ErrorResponse response = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				LocalDateTime.now(),
				null
				);
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(response);
	}
	
	@ExceptionHandler(MaintenanceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleMaintenanceNotFoundException(
			MaintenanceNotFoundException exception
			) {
		ErrorResponse response = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				LocalDateTime.now(),
				null
				);
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(response);
	}
}
