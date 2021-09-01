package com.bank.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class LoanRepositoryTest {
	
	@Mock
	LoanRepository repository;

	@Test
	public void getLoanDetailsByLoanIdTest() {
		
		Loan loan = new Loan(12L, "edu", 5000, "24/08/2021", 7.65, 36,1L);
		Mockito.when(repository.getLoanDetails(12)).thenReturn(Mono.just(loan));
		
		StepVerifier.create(repository.getLoanDetails(12))
				.expectSubscription()
				.expectNext(loan)
				.verifyComplete();
		
	}
	
	@Test
	public void getLoanDetailsByAccountIdTest() {
		
		Loan loan = new Loan(12L, "edu", 5000, "24/08/2021", 7.65, 36,1L);
		Mockito.when(repository.getLoanDetailsByAccountId(1)).thenReturn(Flux.just(loan));
		
		StepVerifier.create(repository.getLoanDetailsByAccountId(1))
				.expectSubscription()
				.expectNext(loan)
				.verifyComplete();
		
	}
	
	@Test
	public void getLoanDetailsByLoanTypeTest() {
		
		Loan loan = new Loan(12L, "edu", 5000, "24/08/2021", 7.65, 36,1L);
		Mockito.when(repository.getLoanDetailsByType("edu")).thenReturn(Flux.just(loan));
		
		StepVerifier.create(repository.getLoanDetailsByType("edu"))
				.expectSubscription()
				.expectNext(loan)
				.verifyComplete();
		
	}
}
