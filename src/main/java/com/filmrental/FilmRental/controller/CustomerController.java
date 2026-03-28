package com.filmrental.FilmRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.filmrental.FilmRental.model.Customer;
import com.filmrental.FilmRental.service.CustomerService;
// REST controller to handle customer-related APIs: get customer by ID and fetch all customers
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }
}