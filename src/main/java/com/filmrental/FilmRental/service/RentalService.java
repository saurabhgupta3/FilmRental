package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.model.Rental;

import java.util.List;

public interface RentalService {

    // Existing
    List<Rental> getAllRentals();

    // NEW METHOD
    List<RentalStaffDTO> getRentalStaffDetails();
}