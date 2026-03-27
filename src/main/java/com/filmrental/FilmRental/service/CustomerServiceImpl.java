package com.filmrental.FilmRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmrental.FilmRental.model.Customer;
import com.filmrental.FilmRental.repo.CustomerRepo;

import java.util.Optional;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public Customer getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
