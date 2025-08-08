package com.example.theory_21_spring_data_mongodb_v2.services;

import java.util.List;

import com.example.theory_21_spring_data_mongodb_v2.dto.CustomerDto;

public interface CustomerService {
    CustomerDto create(CustomerDto dto);

    CustomerDto update(String id, CustomerDto dto);
    CustomerDto getById(String id);
    List<CustomerDto> getAll();
    
    List<CustomerDto> getCustomers();
    void delete(String id);
} 
