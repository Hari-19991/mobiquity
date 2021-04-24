package com.mobiquity.mobiquity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Atms not found.")
public class DataFoundException extends Exception {
	private static final long serialVersionUID = -3332292346834265371L;

	public DataFoundException() {
		super("AtmsFoundException with id=" );
	}
}