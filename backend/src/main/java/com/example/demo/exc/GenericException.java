package com.example.demo.exc;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GenericException extends RuntimeException {
	private final String message;
	private final HttpStatus httpStatus;
	
	public GenericException(String message,HttpStatus httpStatus) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}
}
