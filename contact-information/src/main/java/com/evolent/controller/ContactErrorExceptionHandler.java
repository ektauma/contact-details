package com.evolent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.evolent.entity.ContactErrorResponse;
import com.evolent.exception.ContactNotFoundException;

@ControllerAdvice
public class ContactErrorExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ContactErrorResponse> handlerException(ContactNotFoundException exception) {

		ContactErrorResponse errorResponse = new ContactErrorResponse(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ContactErrorResponse> handlerException(Exception exception) {

		ContactErrorResponse errorResponse = new ContactErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
