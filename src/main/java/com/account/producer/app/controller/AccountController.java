package com.account.producer.app.controller;

import javax.validation.Valid;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.concurrent.ListenableFuture;

import com.account.producer.app.exception.AccountServiceException;
import com.account.producer.app.model.Account;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RefreshScope
@RestController
@Slf4j
@RequestMapping(value = "/account")
public class AccountController {

	private final Gson gson;
	private final KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping("/create")
	public String addAccount(@Valid @RequestBody Account account) {

		String status = null;

		try {

			log.info("Sending msg..");
			ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("test", gson.toJson(account));

			status = "Account created successfully" + result.get().getProducerRecord().value();

		} catch (Exception e) {

			throw new AccountServiceException("Failed to send data.");
		}

		return status;
	}

}
