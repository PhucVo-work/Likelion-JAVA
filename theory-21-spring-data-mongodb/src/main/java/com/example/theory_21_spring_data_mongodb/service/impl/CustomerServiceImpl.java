package com.example.theory_21_spring_data_mongodb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.theory_21_spring_data_mongodb.dto.CustomerDto;
import com.example.theory_21_spring_data_mongodb.entity.Customer;
import com.example.theory_21_spring_data_mongodb.exception.ResourceNotFoundException;
import com.example.theory_21_spring_data_mongodb.mapper.CustomerMapper;
import com.example.theory_21_spring_data_mongodb.repository.CustomerRepository;
import com.example.theory_21_spring_data_mongodb.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public CustomerDto create(CustomerDto dto) {
        return mapper.toDto(customerRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public CustomerDto update(String id, CustomerDto dto) {
        return customerRepository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromDto(dto, existing);
                    return mapper.toDto(customerRepository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
    }

    @Override
    public CustomerDto getById(String id) {
        return customerRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Not found: " + id));
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return mapper.toDtoList(customers);
    }

    @Override
    public void delete(String id) {
        customerRepository.findById(id)
                .ifPresentOrElse(
                        customerRepository::delete,
                        () -> {
                            throw new ResourceNotFoundException("Not found: " + id);
                        });
    }
}