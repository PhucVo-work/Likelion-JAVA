package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/search")
    public CustomerDto getCustomerByEmail(@RequestParam String email) {
        return customerService.getCustomerByEmail(email);
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}