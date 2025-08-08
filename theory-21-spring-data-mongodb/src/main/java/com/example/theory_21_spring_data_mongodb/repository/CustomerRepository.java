package com.example.theory_21_spring_data_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.theory_21_spring_data_mongodb.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    
}
