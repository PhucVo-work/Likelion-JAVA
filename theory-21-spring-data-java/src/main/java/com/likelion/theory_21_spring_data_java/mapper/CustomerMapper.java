package com.likelion.theory_21_spring_data_java.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

import com.likelion.theory_21_spring_data_java.dto.CustomerDto;
import com.likelion.theory_21_spring_data_java.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer entity);

    Customer toEntity(CustomerDto dto);

    List<CustomerDto> toDtoList(List<Customer> customers);

    void updateEntity(CustomerDto dto, @MappingTarget Customer entity);
}
