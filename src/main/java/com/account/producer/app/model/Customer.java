package com.account.producer.app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Customer implements Serializable {

	private static final long serialVersionUID = -7253111342160352431L;

	@NotNull
	private String customerName;
	@NotNull
	private Integer customerNum;
}
