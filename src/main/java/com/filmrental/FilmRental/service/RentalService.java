package com.filmrental.FilmRental.service;

import java.util.List;

import com.filmrental.FilmRental.dto.CustomerRentalDTO;
import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.model.Rental;

public interface RentalService {

    // Existing
    List<Rental> getAllRentals();

    // NEW METHOD
    List<RentalStaffDTO> getRentalStaffDetails();
    List<CustomerRentalDTO> getRentalsByCustomerId(Short customerId);
}