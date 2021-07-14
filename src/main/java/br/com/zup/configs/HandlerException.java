package br.com.zup.configs;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.configs.exception.CepException;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ CepException.class})
    public ResponseEntity<SpringException> handleException(Exception ex) {
		var exception = new SpringException(HttpStatus.NOT_FOUND, ex.getMessage(), getCurrentPath());
		
		return ResponseEntity.status(exception.getStatus()).body(exception);
	}

	public static String getCurrentPath() {
		return ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
	}

}


class SpringException {

	private int status;
	private String message;
	private String path;

	public SpringException() {
	}

	public SpringException(HttpStatus status, String message, String path) {
		this.status = status.value();
		this.message = message;
		this.path = path;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status.value();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
