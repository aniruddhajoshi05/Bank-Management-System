package com.bank.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bank.model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanRepository extends ReactiveCrudRepository<Loan, Long>{
	
	//push Loan Details
	//@Query("insert into loan (loan_type,loan_amount,date,rate_of_interest,duration_of_loan,user_id) values(?,?,?,?,?,?)")
	//public Mono<Loan> save(Loan loan);

	@Query("select * from loan where loan_id=?")
	public Mono<Loan> getLoanDetails(Integer id);

	@Query("select * from loan where user_id=?")
	public Flux<Loan> getLoanDetailsByAccountId(Integer accountId);

	@Query("select * from loan where loan_type=?")
	public Flux<Loan> getLoanDetailsByType(String type);
	
}
