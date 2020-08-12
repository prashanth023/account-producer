package com.account.producer.app.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Account implements Serializable {

	private static final long serialVersionUID = -8144236940964443815L;

	@NotNull
	private String accountName;
	@NotNull
	private Integer accountType;
	@NotNull
	private Integer marketCap;

	private Set<Customer> customer;
	
}
