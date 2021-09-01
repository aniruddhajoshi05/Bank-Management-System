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

import reactor.core.publisher.Flux;
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
		 
		 webTestClient.post().uri("/loan/apply/{userId}",11)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.body(Mono.just(loan), Loan.class)
		 			.exchange()
		 			.expectStatus().isOk()
		 			.expectBody();
					
	}
	
	@Test
	public void getLoanDetailsByLoanIdTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.getLoanDetails(1)).thenReturn(Mono.just(loan));
		 
		 webTestClient.get().uri("/loan/{loanId}",1)
		 			.exchange()
		 			.expectStatus().isOk()
		 			.expectBody();
					
	}
	
	@Test
	public void getLoanDetailsByAccountIdTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.getLoanDetailsByAccountId(11)).thenReturn(Flux.just(loan));
		 
		 webTestClient.get().uri("/loan/account/{accountId}",1)
		 			.exchange()
		 			.expectStatus().isOk()
		 			.expectBody();
					
	}
	
	@Test
	public void getLoanDetailsByTypeTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.getLoanDetailsByType("edu")).thenReturn(Flux.just(loan));
		 
		 webTestClient.get().uri("/loan/type/{type}","edu")
		 			.exchange()
		 			.expectStatus().isOk()
		 			.expectBody();
					
	}

}
