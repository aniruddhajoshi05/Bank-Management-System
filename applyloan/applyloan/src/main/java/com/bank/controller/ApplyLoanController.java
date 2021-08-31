package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Loan;
import com.bank.service.LoanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loan")
@Slf4j
@Api(value = "Loan controller", description = "Apply loan and get details")
public class ApplyLoanController {

	@Autowired
	LoanService service;

	@ApiOperation("Get loan details from loan id")
	@GetMapping("/{id}")
	public Mono<Loan> getLoanDetails(@PathVariable Integer id) {
		return service.getLoanDetails(id);
	}
	
	@ApiOperation("Get loan details from account id")
	@GetMapping("/account/{accountId}")
	public Flux<Loan> getLoanDetailsByAccountId(@PathVariable Integer accountId) {
		return service.getLoanDetailsByAccountId(accountId);
	}

	@ApiOperation("Get loan details from loan type")
	@GetMapping("/type/{type}")
	public Flux<Loan> getLoanDetailsByType(@PathVariable String type) {
		return service.getLoanDetailsByType(type);
	}
	
	@ApiOperation("Apply Loan")
	@PostMapping("/apply/{userId}")
	public Mono<Loan> applyLoan(@RequestBody Loan loan, @PathVariable Long userId) {
		loan.setUserId(userId);
		return service.applyLoan(loan);
	}

}
