package com.account.producer.app.model;

import lombok.Data;

@Data
public class ExceptionResponse{

	private String errorMessage;
	private String requestedUri;
}
