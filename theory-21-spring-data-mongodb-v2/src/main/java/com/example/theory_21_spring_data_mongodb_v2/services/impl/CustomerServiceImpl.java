package com.example.theory_21_spring_data_mongodb_v2.services.impl;

import java.util.List;


import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.example.theory_21_spring_data_mongodb_v2.dto.CustomerDto;
import com.example.theory_21_spring_data_mongodb_v2.entity.Customer;
import com.example.theory_21_spring_data_mongodb_v2.exception.ResourceNotFoundException;
import com.example.theory_21_spring_data_mongodb_v2.mapper.CustomerMapper;
import com.example.theory_21_spring_data_mongodb_v2.repository.CustomerRepository;
import com.example.theory_21_spring_data_mongodb_v2.services.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    private final CacheManager cacheManager; // Inject CacheManager

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
        cacheManager.getCache("customers").clear();
        List<Customer> customers = customerRepository.findAll();
        return mapper.toDtoList(customers);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAllCustomers();
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