package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {
        Optional.ofNullable(customerRepository.selectByEmail(customerDto.getEmail()))
                .ifPresentOrElse(
                        existing -> {
                                throw new IllegalArgumentException("Customer already exists with email: " + customerDto.getEmail());
                        },
                        () -> {
                            Customer newCustomer = customerMapper.toEntity(customerDto);
                            customerRepository.insert(newCustomer);
                        }
                );
    }

    @Override
    public CustomerDto getCustomer(Long id) {
        return Optional.ofNullable(customerRepository.selectById(id))
                .map(customerMapper:: toDto)
                .orElse(null);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return  customerRepository.selectAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        Optional.ofNullable(customerRepository.selectById(id))
                .ifPresentOrElse(
                        existing -> {
                            customerMapper.updateEntity(customerDto, existing);
                            customerRepository.update(existing);
                        },
                        () -> {
                            throw new NoSuchElementException("Customer not found with id: " + id);
                        }
                );
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional.ofNullable(customerRepository.selectById(id))
                .ifPresentOrElse(
                        customer -> customerRepository.delete(id),
                        () -> {
                            throw new NoSuchElementException("Customer not found with id: " + id);
                        }
                );
    }

    @Override
    public CustomerDto getCustomerByEmail(String email) {
        return Optional.ofNullable(customerRepository.selectByEmail(email))
                .map(customerMapper:: toDto)
                .orElse(null);
    }
}
