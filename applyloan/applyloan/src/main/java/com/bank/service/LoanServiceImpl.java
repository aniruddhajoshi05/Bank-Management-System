package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Loan;
import com.bank.repository.LoanRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository repository;

	@Override
	public Mono<Loan> applyLoan(Loan loan) {
		return repository.save(loan);
	}
	
	@Override
	public Mono<Loan> getLoanDetails(Integer id) {
		return repository.getLoanDetails(id);
	}

	@Override
	public Flux<Loan> getLoanDetailsByAccountId(Integer accountId) {
		return repository.getLoanDetailsByAccountId(accountId);
	}

	@Override
	public Flux<Loan> getLoanDetailsByType(String type) {
		return repository.getLoanDetailsByType(type);
	}

}
