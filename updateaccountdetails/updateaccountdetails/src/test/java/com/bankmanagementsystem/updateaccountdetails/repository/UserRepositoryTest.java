package com.bankmanagementsystem.updateaccountdetails.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import com.bankmanagementsystem.updateaccountdetails.model.User;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DirtiesContext
@SpringBootTest
public class UserRepositoryTest {
	
	@MockBean
	UserRepository userRepository;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}
	
	@Test
    public void updateUser() {
		
		User user = new User(2l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India",
				"abc@gmail.com", "1234ftyg", "1029384761", "04/02/2001", "Savings");
        String newAccountType = "Current";
        
        Mockito.when(userRepository.findById(2l)).thenReturn(Mono.just(user));
		Mockito.when(userRepository.save(user)).thenReturn(Mono.just(user));
        
        Mono<User> updatedUser = userRepository.findById(2l)
                .map(user1 -> {
                    user1.setAccountType(newAccountType);
                    return user1;
                })
                .flatMap((user1) -> {
                    return userRepository.save(user1);
                });

        StepVerifier.create(updatedUser)
                .expectSubscription()
                .expectNextMatches(user1 -> user1.getAccountType().equals(newAccountType))
                .verifyComplete();

    }
	
	@AfterAll
	public static void tearDown() {
		
		System.out.println("After All called...");
	}

}
