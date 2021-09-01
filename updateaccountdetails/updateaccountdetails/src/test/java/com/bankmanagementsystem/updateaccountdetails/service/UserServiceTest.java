package com.bankmanagementsystem.updateaccountdetails.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.bankmanagementsystem.updateaccountdetails.model.ResponseMessage;
import com.bankmanagementsystem.updateaccountdetails.model.User;
import com.bankmanagementsystem.updateaccountdetails.repository.UserRepository;

import reactor.core.publisher.Mono;

@SpringBootTest
public class UserServiceTest {
	
	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}
	
	@Test
	public void updateAccountTest() throws InterruptedException {
		
		User user = new User(2l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India", "abc@gmail.com", "1234ftyg", "1029384761", "04/02/2001", "Savings");

		Mockito.when(userRepository.findById(2l)).thenReturn(Mono.just(user));
		Mockito.when(userRepository.save(user)).thenReturn(Mono.just(user));
		
		boolean updatedUser = userService.updateAccount(user, 2l);
		
		assertTrue(updatedUser);
	
		
	}
	
	@Test
    public void updateAccountTest_UpdateFailed() throws InterruptedException {
		User user = new User(1l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India", "abc@gmail.com", 
				"1234ftyg", "1029384761", "04/02/2001", "Savings");
       
        Mockito.when(userRepository.findById(1l)).thenReturn(Mono.empty());
       
        boolean updatedUserMono = userService.updateAccount(user, 1l);
       
        assertFalse(updatedUserMono);
       
    }
	
	@Test
	public void getResponseTest() {
		User user = new User(2l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India", "abc@gmail.com", 
				"1234ftyg", "1029384761", "04/02/2001", "Savings");
		
		ResponseMessage response = userService.getResponse(2l, HttpStatus.OK, "Account Updated");
		assertEquals(2l, response.getId());
		assertEquals(200, response.getStatusCode());
		assertEquals("OK", response.getStatus());
		assertEquals("Account Updated", response.getMessage());
	}
	
	@AfterAll
	public static void tearDown() {
		
		System.out.println("After All called...");
	}
	

}
