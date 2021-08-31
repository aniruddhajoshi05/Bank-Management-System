package com.bankmanagementsystem.updateaccountdetails.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bankmanagementsystem.updateaccountdetails.model.ResponseMessage;
import com.bankmanagementsystem.updateaccountdetails.model.User;
import com.bankmanagementsystem.updateaccountdetails.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean updateAccount(User user, Long id) throws InterruptedException {

		user.setId(id);

		Mono<User> updatedUser = userRepository.findById(id).flatMap(u -> {
			return userRepository.save(user);
		});

		List<Boolean> updated = new ArrayList<>();
		updated.add(false);

		updatedUser.subscribe(u -> updated.add(0, true));

		Thread.sleep(500);
		return updated.get(0);

	}

	public ResponseMessage getResponse(long id, HttpStatus httpStatus, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(httpStatus.name());
		response.setStatusCode(httpStatus.value());
		response.setMessage(message);
		return response;
	}

}
