package com.lun.exceptions;


import com.lun.dto.ErrorCodes;
import com.lun.dto.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InventoryExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> songNotFound(InventoryNotFoundException ex) {
		return new ResponseEntity<>(
				new ErrorInfo(ErrorCodes.ITEM_NOT_FOUND.code(),
				ex.getMessage()),
				HttpStatus.NOT_FOUND);
	}
}


