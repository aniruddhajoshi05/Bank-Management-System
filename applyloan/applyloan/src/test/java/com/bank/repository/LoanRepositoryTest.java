package com.bank.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.model.Loan;

import reactor.test.StepVerifier;

@SpringBootTest
public class LoanRepositoryTest {
	
	@Autowired
	LoanRepository repository;
	
	@BeforeEach
	public void setDatabase() {

		Loan loan = new Loan(12L, "edu", 5000, "24/08/2021", 7.65, 36,1L);
		repository.save(loan);
	}

	@Test
	public void getLoanDetailsByLoanIdTest() {
		
		
		StepVerifier.create(repository.getLoanDetails(12))
				.expectSubscription()
				.verifyComplete();
		
	}
	
	@Test
	public void getLoanDetailsByAccountIdTest() {
		
		StepVerifier.create(repository.getLoanDetailsByAccountId(1))
				.expectSubscription()
				.verifyComplete();
		
	}
	
	@Test
	public void getLoanDetailsByLoanTypeTest() {
		
		StepVerifier.create(repository.getLoanDetailsByType("edu"))
				.expectSubscription()
				.verifyComplete();
		
	}
}
