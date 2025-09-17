package com.example.customer.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.customer.service.model.Customer;
import com.example.customer.service.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Create
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // Get all
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get by id
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            return "Failed to delete customer with id: " + id;
        }

        customerRepository.deleteById(id);
        return "Customer deleted with id: " + id;
    }
}
