package com.account.producer.app.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.account.producer.app.model.ExceptionResponse;



@ControllerAdvice
public class ExceptionHandlerControlerAdvice {


	@ExceptionHandler(AccountServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleAccountServiceException(
			final AccountServiceException accountServiceException, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(accountServiceException.getMessage());
		error.setRequestedUri(request.getRequestURI());

		return error;
	}
	
}
