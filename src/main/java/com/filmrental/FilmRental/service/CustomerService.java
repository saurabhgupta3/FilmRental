package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
}