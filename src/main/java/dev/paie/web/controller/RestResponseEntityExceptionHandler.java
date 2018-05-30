<<<<<<< HEAD
package dev.paie.web.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NotFoundException.class, DataIntegrityViolationException.class,
			IllegalArgumentException.class, IllegalStateException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<Object> notFoundHandle(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Code de cotisations non trouvé";
		return ResponseEntity.badRequest().body(bodyOfResponse);
	}
=======
package dev.paie.web.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NotFoundException.class, DataIntegrityViolationException.class,
			IllegalArgumentException.class, IllegalStateException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<Object> notFoundHandle(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Code de cotisations non trouvé";
		return ResponseEntity.badRequest().body(bodyOfResponse);
	}
>>>>>>> master
}