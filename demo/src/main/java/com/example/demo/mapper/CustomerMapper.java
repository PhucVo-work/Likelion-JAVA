package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;

public interface CustomerMapper {
    CustomerDto toDto(Customer entity);
    Customer toEntity(CustomerDto dto);
    void updateEntity(CustomerDto dto, Customer entity);
}
