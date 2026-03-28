package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Integer id);
    List<Customer> getAllCustomers();
}
