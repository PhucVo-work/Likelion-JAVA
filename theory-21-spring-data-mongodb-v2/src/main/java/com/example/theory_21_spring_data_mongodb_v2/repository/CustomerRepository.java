package com.example.theory_21_spring_data_mongodb_v2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.theory_21_spring_data_mongodb_v2.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{}")
    List<Customer> findAllCustomers();
}
