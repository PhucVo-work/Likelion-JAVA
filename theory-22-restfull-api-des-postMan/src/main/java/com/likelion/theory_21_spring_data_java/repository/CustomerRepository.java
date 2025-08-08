package com.likelion.theory_21_spring_data_java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.likelion.theory_21_spring_data_java.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {
  
  @Query("SELECT C FROM C WHERE C.address = %:address%") //JPQL
  List<Customer> findbyAddress (@Param("address") String address);

  Customer findByEmail(String email); // auto mation jpql
  
  @Query("SELECT C FROM C WHERE C.email = %:email%") //JPQL
  List<Customer> findCustomersByEmail(@Param("email") String email);

  @Query(nativeQuery = true, value = "SELECT * FROM customer WHERE email LIKE :email") // SQL
  List<Customer> findCustomersByEmailSQL(@Param("email") String email);
}
