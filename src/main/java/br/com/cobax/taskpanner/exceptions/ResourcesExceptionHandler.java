package br.com.cobax.taskpanner.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> validationException(MethodArgumentNotValidException e, HttpServletRequest request){
		String campoErro = e.getBindingResult().getAllErrors().get(0).getCodes()[0];
		
		
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), Instant.now(), e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), campoErro);
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	}

}
