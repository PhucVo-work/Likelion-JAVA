package com.likelion.theory_21_spring_data_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.likelion.theory_21_spring_data_java.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {
  Customer findByEmail(String email);
}
