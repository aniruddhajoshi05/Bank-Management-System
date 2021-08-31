package com.bankmanagementsystem.updateaccountdetails.service;

import org.springframework.http.HttpStatus;

import com.bankmanagementsystem.updateaccountdetails.model.ResponseMessage;
import com.bankmanagementsystem.updateaccountdetails.model.User;

import reactor.core.publisher.Mono;

public interface UserService {

	public boolean updateAccount(User user, Long id) throws InterruptedException;

	ResponseMessage getResponse(long id, HttpStatus httpStatus, String message);

}
