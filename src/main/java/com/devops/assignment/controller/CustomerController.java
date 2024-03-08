package com.devops.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devops.assignment.repository.CustomerRepository;
import com.devops.assignment.model.Customer;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @GetMapping("/customer/{custId}")
    public Customer getCustomerById(@PathVariable String custId) {
        return repository.findByCustId(custId);
    }

    @PutMapping("/customer/{custId}")
    public Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable String custId) {

        Customer cust = repository.findByCustId(custId);
        cust.setCustId(newCustomer.getCustId());
        cust.setName(newCustomer.getName());
        cust.setEmail(newCustomer.getEmail());
        return repository.save(cust);

    }

}
