package com.bankmanagementsystem.updateaccountdetails.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bankmanagementsystem.updateaccountdetails.model.User;
import com.bankmanagementsystem.updateaccountdetails.service.UserService;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	UserService userService;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}
	
	@Test
	public void updateAccountTest() throws InterruptedException {
		
		User user = new User(1l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India", "abc@gmail.com", "1234ftyg", "1029384761", "04/02/2001", "Savings");
		
		Mockito.when(userService.updateAccount(user,1l)).thenReturn(true);
		 
		 webTestClient.put().uri("/update-account/{id}",1l)
		 			.contentType(MediaType.APPLICATION_JSON)
		 			.body(Mono.just(user), User.class)
		 			.exchange()
		 			.expectStatus().isOk()
		 			.expectBody()
		 			.jsonPath("$.message", "Account Updated");
		 			
					
	}
	
	@Test
    public void updateAccountDetails_BadRequestTest() throws InterruptedException {
       
		User user = new User(1l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India", "abc@gmail.com", "1234ftyg", "1029384761", "04/02/2001", "Savings");
       
        Mockito.when(userService.updateAccount(user, 2l)).thenReturn(false);
       
        webTestClient
        .put().uri("/update-account/{id}", 2l)
        .contentType(MediaType.APPLICATION_JSON)
        .body(Mono.just(user), User.class)
        .exchange()
        .expectStatus().isBadRequest()
        .expectBody(User.class);
       
    }
	
	@AfterAll
	public static void tearDown() {
		
		System.out.println("After All called...");
	}
	
	
}
