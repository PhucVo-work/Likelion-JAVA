package com.example.theory_21_spring_data_mongodb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.theory_21_spring_data_mongodb.dto.CustomerDto;
import com.example.theory_21_spring_data_mongodb.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable String id) {
        return customerService.getById(id);
    }

    @PostMapping
    public CustomerDto create(@RequestBody CustomerDto dto) {
        return customerService.create(dto);
    }

    @PutMapping("/{id}")
    public CustomerDto update(@PathVariable String id, @RequestBody CustomerDto dto) {
        return customerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }
}