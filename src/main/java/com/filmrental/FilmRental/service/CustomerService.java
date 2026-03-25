package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.model.Customer;

public interface CustomerService {
    Customer getCustomerById(Long id);
}