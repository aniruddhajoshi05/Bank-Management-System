package com.bank.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class LoanServiceTest {
	
	@Mock
	LoanService service;
	
	@Test
	public void getLoanDetailsByLoanIdTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.getLoanDetails(11)).thenReturn(Mono.just(loan));
		 
		 StepVerifier
		 	.create(service.getLoanDetails(11))
		 	.expectNext(loan)
		 	.verifyComplete();
					
	}
	
	@Test
	public void getLoanDetailsByAccountIdTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.getLoanDetailsByAccountId(1)).thenReturn(Flux.just(loan));
		 
		 StepVerifier
		 	.create(service.getLoanDetailsByAccountId(1))
		 	.expectNext(loan)
		 	.verifyComplete();
					
	}

	@Test
	public void getLoanDetailsByTypeTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.getLoanDetailsByType("edu")).thenReturn(Flux.just(loan));
		 
		 StepVerifier
		 	.create(service.getLoanDetailsByType("edu"))
		 	.expectNext(loan)
		 	.verifyComplete();
					
	}
	
	@Test
	public void applyLoanTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36, 1L);
		
		Mockito.when(service.applyLoan(loan)).thenReturn(Mono.just(loan));
		 
		 StepVerifier
		 	.create(service.applyLoan(loan))
		 	.expectNext(loan)
		 	.verifyComplete();
					
	}
}
