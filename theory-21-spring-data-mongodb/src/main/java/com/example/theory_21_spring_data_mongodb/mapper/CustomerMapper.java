package com.example.theory_21_spring_data_mongodb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.theory_21_spring_data_mongodb.dto.CustomerDto;
import com.example.theory_21_spring_data_mongodb.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto dto);

    List<CustomerDto> toDtoList(List<Customer> customers);

    void updateEntityFromDto(CustomerDto dto, @MappingTarget Customer entity);
}