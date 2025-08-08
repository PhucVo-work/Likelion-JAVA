package com.example.demo.service;

import com.example.demo.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    CustomerDto getCustomer(Long id);
    List<CustomerDto> getAllCustomers();
    void updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);

    CustomerDto getCustomerByEmail(String email);
}
