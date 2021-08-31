package com.bankmanagementsystem.updateaccountdetails.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.bankmanagementsystem.updateaccountdetails.model.User;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DirtiesContext
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Before All called...");
	}
	
	@Test
    public void updateUser() {
		
		User user = new User(1l,"ABC", "abc123", "Aniruddh", "Xyz", "Maharashtra", "India",
				"abc@gmail.com", "1234ftyg", "1029384761", "04/02/2001", "Savings");
        String newAccountType = "Current";
        Mono<User> updatedUser = userRepository.findById(1l)
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
