package br.com.tcc.feuc.api.exceptionhandler;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class IllegalArgumentExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Problema handleIllegalArgumentException(IllegalArgumentException e,HttpStatus status) {
		Problema response = new Problema();
		response.setStatus(status.value());
		response.setErrors(new ArrayList<>());
		response.getErrors().add(e.getMessage());
		return response;
	}
}
