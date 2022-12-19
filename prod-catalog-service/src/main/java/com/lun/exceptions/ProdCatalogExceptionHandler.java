package com.lun.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PCExceptionHandler {


	@ExceptionHandler
	public ResponseEntity<?> songNotFound(SongNotFoundException ex) {
		return ResponseEntity.badRequest()
				.body(new ResponseStatusError(1001, ex.getMessage()));
	}

}

@Data
@AllArgsConstructor
class ResponseStatusError {

	private int status;
	private String message;
}