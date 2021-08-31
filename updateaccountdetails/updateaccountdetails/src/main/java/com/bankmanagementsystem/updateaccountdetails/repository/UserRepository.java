package com.bankmanagementsystem.updateaccountdetails.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagementsystem.updateaccountdetails.model.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
