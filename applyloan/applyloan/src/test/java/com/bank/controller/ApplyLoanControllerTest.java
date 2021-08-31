package com.bank.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bank.model.Loan;
import com.bank.service.LoanService;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ApplyLoanControllerTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	LoanService service;

	@Test
	public void applyLoanTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.applyLoan(loan)).thenReturn(Mono.just(loan));
		 
		 webTestClient.put().uri("loan/apply/{userId}",11)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.body(Mono.just(loan), Loan.class)
		 			.exchange()
		 			.expectStatus().isOk()
		 			.expectBody();
					
	}

}
