package com.likelion.theory_21_spring_data_java.services;

import java.util.List;

import com.likelion.theory_21_spring_data_java.dto.CustomerDto;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long id);
    CustomerDto getCustomerByEmail(String email);
    List<CustomerDto> getAllCustomers();
    List<CustomerDto> getAllCustomerByAdrress(String address);
    void updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);
} 
