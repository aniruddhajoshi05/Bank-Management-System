package com.bankmanagementsystem.updateaccountdetails.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bankmanagementsystem.updateaccountdetails.model.ResponseMessage;
import com.bankmanagementsystem.updateaccountdetails.model.User;
import com.bankmanagementsystem.updateaccountdetails.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

	@Autowired
	UserService userService;

	public Mono<ServerResponse> updateAccount(ServerRequest serverRequest) {

		Long id = Long.parseLong(serverRequest.pathVariable("id"));
		Mono<User> accountTobeUpdated = serverRequest.bodyToMono(User.class);
		return accountTobeUpdated.flatMap(user -> {
			try {
				if (userService.updateAccount(user, id)) {
					return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
							Mono.just(userService.getResponse(id, HttpStatus.OK, "Account Successfully Updated!")),
							ResponseMessage.class);
				} else {
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).body(
							Mono.just(userService.getResponse(id, HttpStatus.BAD_REQUEST, "Account update failed! User doesn't exists")),
							ResponseMessage.class);
				}
			} catch (Exception e) {
				return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).body(
						Mono.just(userService.getResponse(id, HttpStatus.BAD_REQUEST, "Account update failed!")),
						ResponseMessage.class);
			}
		});

	}

}
