package com.example.theory_21_spring_data_mongodb.service;

import java.util.List;

import com.example.theory_21_spring_data_mongodb.dto.CustomerDto;

public interface CustomerService {
    CustomerDto create(CustomerDto dto);

    CustomerDto update(String id, CustomerDto dto);
    CustomerDto getById(String id);
    List<CustomerDto> getAll();
    void delete(String id);
}
