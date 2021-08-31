package com.bank.service;

import com.bank.model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {
	public Mono<Loan> applyLoan(Loan loan);

	public Mono<Loan> getLoanDetails(Integer id);

	public Flux<Loan> getLoanDetailsByAccountId(Integer accountId);

	public Flux<Loan> getLoanDetailsByType(String type);
}
