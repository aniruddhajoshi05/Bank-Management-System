package com.bank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bank.model.Loan;
import com.bank.repository.LoanRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class LoanServiceImplTest {
	
	@MockBean
	LoanRepository repository;
	
	LoanServiceImpl service;
	
	@BeforeEach
	public void setupTest() {
		service = new LoanServiceImpl();		
	}
	
	@Test
	public void getLoanDetailsByLoanIdTest() {
		
		Loan loan = new Loan(11l, "edu", 5000, "24/08/2021", 7.65, 36,1l);
		
		Mockito.when(repository.getLoanDetails(11)).thenReturn(Mono.just(loan));
		 
		 StepVerifier
		 	.create(service.getLoanDetailsByAccountId(11))
		 	.expectNext(loan)
		 	.expectComplete()
		 	.verify();
					
	}
	
	@Test
	public void getLoanDetailsByAccountIdTest() {
		
		Loan loan = new Loan(11l, "edu", 5000, "24/08/2021", 7.65, 36,1l);
		
		Mockito.when(repository.getLoanDetailsByAccountId(1)).thenReturn(Flux.just(loan));
		 
		 StepVerifier
		 	.create(service.getLoanDetailsByAccountId(1))
		 	.expectNext()
		 	.expectComplete()
		 	.verify();
					
	}

	@Test
	public void getLoanDetailsByTypeTest() {
		
		Loan loan = new Loan(11l, "edu", 5000, "24/08/2021", 7.65, 36,1l);
		
		Mockito.when(repository.getLoanDetailsByType("edu")).thenReturn(Flux.just(loan));
		 
		 StepVerifier
		 	.create(service.getLoanDetailsByType("edu"))
		 	.expectNext()
		 	.expectComplete()
		 	.verify();
					
	}
	
	@Test
	public void applyLoanTest() {
		
		Loan loan = new Loan(11L, "edu", 5000, "24/08/2021", 7.65, 36,1L);
		
		Mockito.when(repository.save(loan)).thenReturn(Mono.just(loan));
		 
		 StepVerifier
		 	.create(service.applyLoan(loan))
		 	.expectNext()
		 	.expectComplete()
		 	.verify();
					
	}
}
