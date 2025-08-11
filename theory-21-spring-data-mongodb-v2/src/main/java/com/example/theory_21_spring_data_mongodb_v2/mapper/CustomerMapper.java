package com.example.theory_21_spring_data_mongodb_v2.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.theory_21_spring_data_mongodb_v2.dto.CustomerDto;
import com.example.theory_21_spring_data_mongodb_v2.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto dto);

    List<CustomerDto> toDtoList(List<Customer> customers);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(CustomerDto dto, @MappingTarget Customer entity);
}
