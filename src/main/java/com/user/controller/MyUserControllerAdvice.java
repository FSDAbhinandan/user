package com.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.exceptions.ExceptionMessage;
import com.user.exceptions.UserIsAlreadyPresentException;

@ControllerAdvice
public class MyUserControllerAdvice {

	@ExceptionHandler(UserIsAlreadyPresentException.class)
	public ResponseEntity<ExceptionMessage> handleUserIsAlreadyPresentException(UserIsAlreadyPresentException e){
		return new ResponseEntity<ExceptionMessage>(new ExceptionMessage(e.getMessage(),HttpStatus.CONFLICT),HttpStatus.CONFLICT);
	}
}
