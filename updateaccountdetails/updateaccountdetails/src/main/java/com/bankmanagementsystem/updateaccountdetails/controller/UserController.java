package com.bankmanagementsystem.updateaccountdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagementsystem.updateaccountdetails.model.ResponseMessage;
import com.bankmanagementsystem.updateaccountdetails.model.User;
import com.bankmanagementsystem.updateaccountdetails.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/update-account")
@Slf4j
@Api(value = "User controller", description = "Operations for updating account details of the user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation("Update Account")
	@PutMapping("/{id}")
	public Mono<ResponseEntity<ResponseMessage>> updateAccountDetails(@RequestBody User user, @PathVariable Long id)
			throws InterruptedException {

		log.info("************* START *************");

		boolean updatedAccount = userService.updateAccount(user, id);

		if (!updatedAccount) {
			log.error("Account update failed!");
			return Mono.just(ResponseEntity.badRequest()
					.body(userService.getResponse(id, HttpStatus.BAD_REQUEST, "Account update failed!")));
		}
		log.info("Account updated!");
		return Mono.just(ResponseEntity.ok().body(userService.getResponse(id, HttpStatus.OK, "Account Updated!")));

	}

}
