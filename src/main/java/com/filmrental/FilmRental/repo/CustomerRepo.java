package com.filmrental.FilmRental.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.filmrental.FilmRental.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
