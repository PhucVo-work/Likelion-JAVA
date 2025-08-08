package com.example.demo.mapper.impl;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public CustomerDto toDto(Customer entity) {
        CustomerDto dto = new CustomerDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Customer toEntity(CustomerDto dto) {
        Customer entity = new Customer();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public void updateEntity(CustomerDto dto, Customer entity) {
        BeanUtils.copyProperties(dto, entity, "id");
    }
}
